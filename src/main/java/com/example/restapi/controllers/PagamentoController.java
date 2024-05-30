package com.example.restapi.controllers;

import com.example.restapi.dtos.PagamentoDto;
import com.example.restapi.models.PagamentoModel;
import com.example.restapi.repositories.PagamentoRepository;

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
@RequestMapping("/v1")
public class PagamentoController {

    @Autowired
    PagamentoRepository pagamentoRepository;

    @PostMapping("/pagamento")
    public ResponseEntity<PagamentoModel> salvarPagamento(@RequestBody @Valid PagamentoDto pagamentoDto) {
        var pagamentoModel = new PagamentoModel();
        BeanUtils.copyProperties(pagamentoDto, pagamentoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(pagamentoRepository.save(pagamentoModel));
    }

    @GetMapping("/pagamento")
    public ResponseEntity<List<PagamentoModel>> listarTodosPagamento(){
        return ResponseEntity.status(HttpStatus.OK).body(pagamentoRepository.findAll());
    }

    @GetMapping("/pagamento/{id}")
    public ResponseEntity<Object> listarPagamentoPorId(@PathVariable(value="id") UUID id){
        Optional<PagamentoModel> pagamento0 = pagamentoRepository.findById(id);
        if(pagamento0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pagamento não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pagamento0.get());
    }

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