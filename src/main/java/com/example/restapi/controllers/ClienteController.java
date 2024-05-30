package com.example.restapi.controllers;

import com.example.restapi.dtos.ClienteDto;
import com.example.restapi.models.ClienteModel;
import com.example.restapi.repositories.ClienteRepository;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Controlador para lidar com solicitações relacionadas ao cliente.
 */
@OpenAPIDefinition(info = @Info(title = "Projeto de RestAPI", version = "v1", description = "Implementação de uma API REST com Spring Boot"))
@RestController
@RequestMapping("/v1")
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

    /**
     * Endpoint para criar um novo cliente.
     * @param clienteDto O objeto de transferência de dados do cliente.
     * @return O modelo de cliente criado.
     */
    @Operation(summary = "Cria um novo cliente")
    @PostMapping("/cliente")
    public ResponseEntity<ClienteModel> salvarCliente(@RequestBody @Valid ClienteDto clienteDto) {
        var clienteModel = new ClienteModel();
        BeanUtils.copyProperties(clienteDto, clienteModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteRepository.save(clienteModel));
    }

    /**
     * Endpoint para recuperar todos os clientes.
     * @return Uma lista de todos os modelos de clientes.
     */
    @Operation(summary = "Lista todos os clientes")
    @GetMapping("/cliente")
    public ResponseEntity<List<ClienteModel>> listarTodosClientes(){
        return ResponseEntity.status(HttpStatus.OK).body(clienteRepository.findAll());
    }

    /**
     * Endpoint para recuperar um cliente por ID.
     * @param id O ID do cliente.
     * @return O modelo de cliente se encontrado, caso contrário uma mensagem de erro.
     */
    @Operation(summary = "Lista um cliente por ID")
    @GetMapping("/cliente/{id}")
    public ResponseEntity<Object> listarClientePorId(@PathVariable(value="id") UUID id){
        Optional<ClienteModel> cliente0 = clienteRepository.findById(id);
        if(cliente0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(cliente0.get());
    }

    /**
     * Endpoint para atualizar um cliente.
     * @param id O ID do cliente.
     * @param clienteDto O objeto de transferência de dados do cliente.
     * @return O modelo de cliente atualizado se encontrado, caso contrário uma mensagem de erro.
     */
    @Operation(summary = "Atualiza um cliente por ID")
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

    /**
     * Endpoint para deletar um cliente.
     * @param id O ID do cliente.
     * @return Uma mensagem de sucesso se o cliente foi deletado, caso contrário uma mensagem de erro.
     */
    @Operation(summary = "Deleta um cliente por ID")
    @DeleteMapping("/cliente/{id}")
    public ResponseEntity<Object> deletarCliente(@PathVariable(value="id") UUID id) {
        Optional<ClienteModel> cliente0 = clienteRepository.findById(id);
        if (cliente0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
        }
        clienteRepository.delete(cliente0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado com sucesso.");
    }
}
