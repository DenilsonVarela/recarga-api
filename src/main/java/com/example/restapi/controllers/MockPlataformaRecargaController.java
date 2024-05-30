package com.example.restapi.controllers;

import com.example.restapi.models.RecargaModel;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador que simula uma plataforma de recarga.
 */
@RestController
@RequestMapping("/v1/mock-plataforma-recarga")
@OpenAPIDefinition
public class MockPlataformaRecargaController {

    /**
     * Realiza uma recarga.
     * @param recarga O modelo de recarga.
     * @return Uma resposta indicando sucesso ou falha na recarga.
     */
    @Operation(summary = "Realiza uma recarga")
    @PostMapping("/recarga")
    public ResponseEntity<String> realizarRecarga(@RequestBody RecargaModel recarga) {

        // Simular sucesso ou falha aleatoriamente
        if (Math.random() > 0.5) {
            return ResponseEntity.ok("Sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Falha ao efetuar recarga.");
        }
    }
}

