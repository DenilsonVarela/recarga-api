package com.example.restapi.dtos;

import jakarta.validation.constraints.NotBlank;

/**
 * Classe de transferência de dados para o Pagamento.
 * Esta classe é usada para receber dados do pagamento em requisições.
 */
public class PagamentoDto {
    @NotBlank
    private String metodoPagamento;

    /**
     * Construtor padrão para a classe PagamentoDto.
     */
    public PagamentoDto() {
    }

    /**
     * Construtor para a classe PagamentoDto.
     * @param metodoPagamento O método de pagamento.
     */
    public PagamentoDto(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    /**
     * Retorna o método de pagamento.
     * @return O método de pagamento.
     */
    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    /**
     * Define o método de pagamento.
     * @param metodoPagamento O método de pagamento.
     */
    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

}
