package com.example.restapi.dtos;

import com.example.restapi.models.PagamentoModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RecargaDto {
    @NotBlank
    private String cliente;
    @NotBlank
    private String dataRecarga;
    @NotNull
    private Double valor;

    @NotNull
    private String pagamento;

    public RecargaDto(String cliente, String dataRecarga, Double valor, String pagamentoId) {
        this.cliente = cliente;
        this.dataRecarga = dataRecarga;
        this.valor = valor;
        this.pagamento = pagamentoId;
    }

    public String getcliente() {
        return cliente;
    }
    public void setcliente(String cliente) {
        this.cliente = cliente;
    }
    public String getdataRecarga() {
        return dataRecarga;
    }
    public void setdataRecarga(String dataRecarga) {
        this.dataRecarga = dataRecarga;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getPagamentoId() {
        return pagamento;
    }

    public void setPagamentoId(String pagamentoId) {
        this.pagamento = pagamentoId;
    }
}
