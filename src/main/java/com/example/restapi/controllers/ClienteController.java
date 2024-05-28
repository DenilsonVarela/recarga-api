package com.example.restapi.controllers;

import com.example.restapi.dtos.ClienteDto;
import com.example.restapi.models.ClienteModel;
import com.example.restapi.repositories.ClienteRepository;
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
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

    @PostMapping("/cliente")
    public ResponseEntity<ClienteModel> salvarCliente(@RequestBody @Valid ClienteDto clienteDto) {
        var clienteModel = new ClienteModel();
        BeanUtils.copyProperties(clienteDto, clienteModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteRepository.save(clienteModel));
    }

    @GetMapping("/cliente")
    public ResponseEntity<List<ClienteModel>> listarTodosClientes(){
        return ResponseEntity.status(HttpStatus.OK).body(clienteRepository.findAll());
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<Object> listarClientePorId(@PathVariable(value="id") UUID id){
        Optional<ClienteModel> cliente0 = clienteRepository.findById(id);
        if(cliente0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(cliente0.get());
    }

    @PutMapping("/cliente/{id}")
    public ResponseEntity<Object> atualizarCliente(@PathVariable(value = "id") UUID id,
                                                   @RequestBody @Valid ClienteDto clienteDto) {
        Optional<ClienteModel> cliente0 = clienteRepository.findById(id);
        if(cliente0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
        }
        var clienteModel = cliente0.get();
        BeanUtils.copyProperties(clienteDto, clienteModel);
        return ResponseEntity.status(HttpStatus.OK).body(clienteRepository.save(clienteModel));
    }

    @DeleteMapping("/cliente/{id}")
    public ResponseEntity<Object> deletarCliente(@PathVariable(value="id") UUID id) {
        Optional<ClienteModel> cliente0 = clienteRepository.findById(id);
        if (cliente0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
        }
        clienteRepository.delete(cliente0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Produto deletado com sucesso.");
    }
}