package com.example.restapi.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Modelo de entidade para a tabela de recargas.
 * Esta classe é usada para mapear a tabela de recargas no banco de dados.
 */
@Entity
@Table(name = "TB_RECARGAS")
public class RecargaModel implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ID da recarga. Este é o campo chave primária.
     */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private UUID idRecarga;

    /**
     * Cliente que está realizando a recarga.
     */
    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "idCliente")
    private ClienteModel cliente;

    /**
     * Pagamento usado para a recarga.
     */
    @ManyToOne
    @JoinColumn(name = "pagamento_id", referencedColumnName = "idPagamento")
    private PagamentoModel pagamento;

    /**
     * Valor da recarga.
     */
    private Double valor;

    /**
     * Data da recarga.
     */
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime dataRecarga;

    /**
     * Retorna o ID da recarga.
     * @return O ID da recarga.
     */
    public UUID getIdRecarga() {
        return idRecarga;
    }

    /**
     * Define o ID da recarga.
     * @param idRecarga O ID da recarga.
     */
    public void setIdRecarga(UUID idRecarga) {
        this.idRecarga = idRecarga;
    }

    /**
     * Retorna o cliente que está realizando a recarga.
     * @return O cliente que está realizando a recarga.
     */
    public ClienteModel getCliente() {
        return cliente;
    }

    /**
     * Define o cliente que está realizando a recarga.
     * @param cliente O cliente que está realizando a recarga.
     */
    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    /**
     * Retorna o pagamento usado para a recarga.
     * @return O pagamento usado para a recarga.
     */
    public PagamentoModel getPagamento() {
        return pagamento;
    }

    /**
     * Define o pagamento usado para a recarga.
     */
    public void setPagamento(PagamentoModel pagamentoModel) {
        this.pagamento = pagamentoModel;
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
     * Retorna a data da recarga.
     * @return A data da recarga.
     */
    public LocalDateTime getDataRecarga() {
        return dataRecarga;
    }

    /**
     * Define a data da recarga.
     * @param dataRecarga A data da recarga.
     */
    public void setDataRecarga(LocalDateTime dataRecarga) {
        this.dataRecarga = dataRecarga;
    }
}
