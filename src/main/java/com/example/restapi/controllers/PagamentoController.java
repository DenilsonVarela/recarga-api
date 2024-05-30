package com.example.restapi.controllers;

import com.example.restapi.dtos.PagamentoDto;
import com.example.restapi.models.PagamentoModel;
import com.example.restapi.repositories.PagamentoRepository;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
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
 * Controlador para lidar com operações de pagamento.
 */
@RestController
@RequestMapping("/v1")
@OpenAPIDefinition
public class PagamentoController {

    @Autowired
    PagamentoRepository pagamentoRepository;

    /**
     * Cria um novo pagamento.
     * @param pagamentoDto O objeto de transferência de dados do pagamento.
     * @return O modelo de pagamento criado.
     */
    @Operation(summary = "Cria um novo pagamento")
    @PostMapping("/pagamento")
    public ResponseEntity<PagamentoModel> salvarPagamento(@RequestBody @Valid PagamentoDto pagamentoDto) {
        var pagamentoModel = new PagamentoModel();
        BeanUtils.copyProperties(pagamentoDto, pagamentoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(pagamentoRepository.save(pagamentoModel));
    }

    /**
     * Lista todos os pagamentos.
     * @return Uma lista de todos os modelos de pagamento.
     */
    @Operation(summary = "Lista todos os pagamentos")
    @GetMapping("/pagamento")
    public ResponseEntity<List<PagamentoModel>> listarTodosPagamento(){
        return ResponseEntity.status(HttpStatus.OK).body(pagamentoRepository.findAll());
    }

    /**
     * Lista um pagamento por ID.
     * @param id O ID do pagamento.
     * @return O modelo de pagamento se encontrado, caso contrário uma mensagem de erro.
     */
    @Operation(summary = "Lista um pagamento por ID")
    @GetMapping("/pagamento/{id}")
    public ResponseEntity<Object> listarPagamentoPorId(@PathVariable(value="id") UUID id){
        Optional<PagamentoModel> pagamento0 = pagamentoRepository.findById(id);
        if(pagamento0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pagamento não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pagamento0.get());
    }

    /**
     * Atualiza um pagamento por ID.
     * @param id O ID do pagamento.
     * @param pagamentoDto O objeto de transferência de dados do pagamento.
     * @return O modelo de pagamento atualizado se encontrado, caso contrário uma mensagem de erro.
     */
    @Operation(summary = "Atualiza um pagamento por ID")
    @PutMapping("/pagamento/{id}")
    public ResponseEntity<Object> atualizarPagamento(@PathVariable(value = "id") UUID id,
                                                   @RequestBody @Valid PagamentoDto pagamentoDto) {
        Optional<PagamentoModel> pagamento0 = pagamentoRepository.findById(id);
        if(pagamento0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pagamento não encontrado.");
        }
        var pagamentoModel = pagamento0.get();
        BeanUtils.copyProperties(pagamentoDto, pagamentoModel);
        return ResponseEntity.status(HttpStatus.OK).body(pagamentoRepository.save(pagamentoModel));
    }

    /**
     * Deleta um pagamento por ID.
     * @param id O ID do pagamento.
     * @return Uma mensagem de sucesso se o pagamento foi deletado, caso contrário uma mensagem de erro.
     */
    @Operation(summary = "Deleta um pagamento por ID")
    @DeleteMapping("/pagamento/{id}")
    public ResponseEntity<Object> deletarPagamento(@PathVariable(value="id") UUID id) {
        Optional<PagamentoModel> pagamento0 = pagamentoRepository.findById(id);
        if (pagamento0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pagamento não encontrado.");
        }
        pagamentoRepository.delete(pagamento0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Produto deletado com sucesso.");
    }
}