package com.example.restapi.service;

import com.example.restapi.config.RabbitMQConfig;
import com.example.restapi.models.ClienteModel;
import com.example.restapi.models.PagamentoModel;
import com.example.restapi.models.RecargaModel;
import com.example.restapi.repositories.ClienteRepository;
import com.example.restapi.repositories.PagamentoRepository;
import com.example.restapi.repositories.RecargaRepository;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Component
public class RecargaConsumer {
    @Autowired
    private RecargaRepository recargaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void processarRecarga(RecargaModel recarga) {

        // Simulando chamada à plataforma de recarga
        String url = "http://localhost:8080/v1/mock-plataforma-recarga/recarga";
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<String> response = restTemplate.postForEntity(url, recarga, String.class);
            if (response.getStatusCode() == HttpStatus.OK) {

                // Buscando o cliente
                ClienteModel cliente = clienteRepository.findById(recarga.getCliente().getIdCliente())
                        .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
                recarga.setCliente(cliente);
                recarga.setDataRecarga(LocalDateTime.now());

                // Buscando o pagamento
                PagamentoModel pagamento = pagamentoRepository.findById(recarga.getPagamento().getIdPagamento())
                        .orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));
                recarga.setPagamento(pagamento);

                recargaRepository.save(recarga);
                System.out.println("Mensagem consumida com sucesso");
            } else {
                System.out.println("Falha ao consumir a mensagem");
            }
        } catch (Exception e) {
            System.out.println("Erro ao consumir a mensagem");
        }
    }
}
