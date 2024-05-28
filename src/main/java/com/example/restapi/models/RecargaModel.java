package com.example.restapi.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_RECARGAS")
public class RecargaModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private UUID idRecarga;

    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "idCliente")
    private ClienteModel cliente;

    @ManyToOne
    @JoinColumn(name = "pagamento_id", referencedColumnName = "idPagamento")
    private PagamentoModel pagamento;
    private Double valor;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime dataRecarga;

    public UUID getIdRecarga() {
        return idRecarga;
    }

    public void setIdRecarga(UUID idRecarga) {
        this.idRecarga = idRecarga;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public PagamentoModel getPagamento() {
        return pagamento;
    }

    public void setPagamento(PagamentoModel pagamentoModel) {
        this.pagamento = pagamentoModel;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataRecarga() {
        return dataRecarga;
    }

    public void setDataRecarga(LocalDateTime dataRecarga) {
        this.dataRecarga = dataRecarga;
    }
}
