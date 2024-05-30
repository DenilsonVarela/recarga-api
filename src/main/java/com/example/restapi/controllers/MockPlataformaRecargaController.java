package com.example.restapi.controllers;

import com.example.restapi.models.RecargaModel;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/mock-plataforma-recarga")
public class MockPlataformaRecargaController {

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

