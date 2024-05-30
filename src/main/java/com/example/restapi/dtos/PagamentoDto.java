package com.example.restapi.dtos;

import jakarta.validation.constraints.NotBlank;

public class PagamentoDto {
    @NotBlank
    private String metodoPagamento;

    public PagamentoDto() {
    }

    public PagamentoDto(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

}
