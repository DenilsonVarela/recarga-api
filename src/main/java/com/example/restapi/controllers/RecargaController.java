package com.example.restapi.controllers;

import com.example.restapi.dtos.RecargaDto;
import com.example.restapi.models.RecargaModel;
import com.example.restapi.repositories.RecargaRepository;
import com.example.restapi.service.RecargaService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class RecargaController {

    @Autowired
    RecargaService recargaService ;

    @PostMapping("/recarga")
    public ResponseEntity<?> realizarRecarga(@RequestBody RecargaModel recarga) {
        try {
            RecargaModel novaRecarga = recargaService.realizarRecarga(recarga);
            return ResponseEntity.ok(novaRecarga);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Falha na recarga: " + e.getMessage());
        }
    }

    @GetMapping("/recargaCliente/{clienteId}")
    public List<RecargaModel> listarRecargasPorCliente(@PathVariable UUID clienteId) {
        return recargaService.listarRecargasPorCliente(clienteId);
    }

}