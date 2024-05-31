package com.example.restapi.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

/**
 * Modelo de entidade para a tabela de pagamentos.
 * Esta classe é usada para mapear a tabela de pagamentos no banco de dados.
 */
@Entity
@Table(name = "TB_PAGAMENTOS")
public class PagamentoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ID do pagamento. Este é o campo chave primária.
     */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private UUID idPagamento;

    /**
     * Método de pagamento usado.
     */
    private String metodoPagamento;

    /**
     * Retorna o ID do pagamento.
     * @return O ID do pagamento.
     */
    public UUID getIdPagamento() {
        return idPagamento;
    }

    /**
     * Define o ID do pagamento.
     * @param idPagamento O ID do pagamento.
     */
    public void setIdPagamento(UUID idPagamento) {
        this.idPagamento = idPagamento;
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
