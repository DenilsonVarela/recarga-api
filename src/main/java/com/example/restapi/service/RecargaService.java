package com.example.restapi.service;

import com.example.restapi.config.RabbitMQConfig;
import com.example.restapi.models.RecargaModel;
import com.example.restapi.repositories.RecargaRepository;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Classe de serviço para realizar operações de recarga.
 * Esta classe é responsável por realizar operações de recarga, como solicitar recarga e listar recargas por cliente.
 */
@Service
public class RecargaService {
    // Injeta o repositório de recargas
    @Autowired
    private RecargaRepository recargaRepository;
    // Injeta o RabbitTemplate para enviar mensagens para a fila
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * Solicita uma recarga.
     * Esta função é responsável por enviar uma mensagem de recarga para a fila.
     * @param recarga A recarga a ser solicitada.
     * @return Uma mensagem de sucesso.
     */
    public String solicitarRecarga(RecargaModel recarga) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, recarga);
        return "Mensagem enviada com sucesso para a fila.";
    }

    public List<RecargaModel> listarRecargasPorCliente(UUID clienteId) {
       return recargaRepository.findByCliente_IdCliente(clienteId);
    }
}
