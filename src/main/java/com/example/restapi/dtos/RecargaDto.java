package com.example.restapi.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Classe de transferência de dados para a Recarga.
 * Esta classe é usada para receber dados da recarga em requisições.
 */
public class RecargaDto {
    @NotBlank
    private String cliente;
    @NotBlank
    private String dataRecarga;
    @NotNull
    private Double valor;

    @NotNull
    private String pagamento;

    /**
     * Construtor para a classe RecargaDto.
     * @param cliente O cliente que está realizando a recarga.
     * @param dataRecarga A data da recarga.
     * @param valor O valor da recarga.
     * @param pagamentoId O ID do pagamento.
     */
    public RecargaDto(String cliente, String dataRecarga, Double valor, String pagamentoId) {
        this.cliente = cliente;
        this.dataRecarga = dataRecarga;
        this.valor = valor;
        this.pagamento = pagamentoId;
    }

    /**
     * Retorna o cliente que está realizando a recarga.
     * @return O cliente que está realizando a recarga.
     */
    public String getcliente() {
        return cliente;
    }

    /**
     * Define o cliente que está realizando a recarga.
     * @param cliente O cliente que está realizando a recarga.
     */
    public void setcliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * Retorna a data da recarga.
     * @return A data da recarga.
     */
    public String getdataRecarga() {
        return dataRecarga;
    }

    /**
     * Define a data da recarga.
     * @param dataRecarga A data da recarga.
     */
    public void setdataRecarga(String dataRecarga) {
        this.dataRecarga = dataRecarga;
    }

    /**
     * Retorna o valor da recarga.
     * @return O valor da recarga.
     */
    public Double getValor() {
        return valor;
    }

    /**
     * Define o valor da recarga.
     * @param valor O valor da recarga.
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    /**
     * Retorna o ID do pagamento.
     * @return O ID do pagamento.
     */
    public String getPagamentoId() {
        return pagamento;
    }

    /**
     * Define o ID do pagamento.
     * @param pagamentoId O ID do pagamento.
     */
    public void setPagamentoId(String pagamentoId) {
        this.pagamento = pagamentoId;
    }
}
