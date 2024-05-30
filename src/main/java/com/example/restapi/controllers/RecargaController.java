package com.example.restapi.controllers;

import com.example.restapi.models.RecargaModel;
import com.example.restapi.service.RecargaConsumer;
import com.example.restapi.service.RecargaService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Controlador para lidar com operações de recarga.
 */
@RestController
@RequestMapping("/v1")
@OpenAPIDefinition
public class RecargaController {

    @Autowired
    RecargaService recargaService ;

    @Autowired
    RecargaConsumer recargaConsumer;

    /**
     * Solicita uma recarga.
     * @param recarga O modelo de recarga.
     * @return Uma resposta indicando o resultado da solicitação de recarga.
     */
    @Operation(summary = "Solicita uma recarga")
    @PostMapping("/recarga")
    public ResponseEntity<?> solicitarRecarga(@RequestBody RecargaModel recarga) {
        String resultado = recargaService.solicitarRecarga(recarga);
        return ResponseEntity.accepted().body(resultado);
    }

    /**
     * Lista todas as recargas de um determinado cliente.
     * @param clienteId O ID do cliente.
     * @return Uma lista de todas as recargas do cliente.
     */
    @Operation(summary = "Lista todas as recargas de determinado cliente")
    @GetMapping("/recargaCliente/{clienteId}")
    public List<RecargaModel> listarRecargasPorCliente(@PathVariable UUID clienteId) {
        return recargaService.listarRecargasPorCliente(clienteId);
    }
}
