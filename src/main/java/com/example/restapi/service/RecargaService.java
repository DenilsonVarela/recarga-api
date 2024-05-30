package com.example.restapi.service;

import com.example.restapi.config.RabbitMQConfig;
import com.example.restapi.models.RecargaModel;
import com.example.restapi.repositories.RecargaRepository;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RecargaService {
    @Autowired
    private RecargaRepository recargaRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public String solicitarRecarga(RecargaModel recarga) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, recarga);
        return "Mensagem enviada com sucesso para a fila.";
    }

    public List<RecargaModel> listarRecargasPorCliente(UUID clienteId) {
       return recargaRepository.findByCliente_IdCliente(clienteId);
    }
}
