package com.example.restapi.controllers;

import com.example.restapi.models.RecargaModel;
import com.example.restapi.service.RecargaConsumer;
import com.example.restapi.service.RecargaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1")
public class RecargaController {

    @Autowired
    RecargaService recargaService ;

    @Autowired
    RecargaConsumer recargaConsumer;

    @PostMapping("/recarga/teste")
    public ResponseEntity<?> solicitarRecarga(@RequestBody RecargaModel recarga) {
        String resultado = recargaService.solicitarRecarga(recarga);
        return ResponseEntity.accepted().body(resultado);
    }

    @GetMapping("/recargaCliente/{clienteId}")
    public List<RecargaModel> listarRecargasPorCliente(@PathVariable UUID clienteId) {
        return recargaService.listarRecargasPorCliente(clienteId);
    }
}
