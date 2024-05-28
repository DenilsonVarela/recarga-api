package com.example.restapi.service;

import com.example.restapi.models.ClienteModel;
import com.example.restapi.models.PagamentoModel;
import com.example.restapi.models.RecargaModel;
import com.example.restapi.repositories.ClienteRepository;
import com.example.restapi.repositories.PagamentoRepository;
import com.example.restapi.repositories.RecargaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class RecargaService {
    @Autowired
    private RecargaRepository recargaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private PlataformaRecargaService plataformaRecargaService;

    public RecargaModel realizarRecarga(RecargaModel recarga) {
        boolean sucesso = plataformaRecargaService.realizarRecarga(recarga.getCliente().getTelefone(), recarga.getValor());
        if (sucesso) {
            ClienteModel cliente = clienteRepository.findById(recarga.getCliente().getIdCliente())
                    .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
            recarga.setCliente(cliente);
            recarga.setDataRecarga(LocalDateTime.now());

            PagamentoModel pagamento = pagamentoRepository.findById(recarga.getPagamento().getIdPagamento()) // Busque o pagamento
                    .orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));
            recarga.setPagamento(pagamento); // Defina o pagamento na recarga

            return recargaRepository.save(recarga);
        } else {
            throw new RuntimeException("Falha na recarga com a plataforma externa.");
        }
    }

    public List<RecargaModel> listarRecargasPorCliente(UUID clienteId) {
        return recargaRepository.findByCliente_IdCliente(clienteId);
    }
}

