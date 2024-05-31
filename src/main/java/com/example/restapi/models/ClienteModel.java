package com.example.restapi.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

/**
 * Modelo de entidade para a tabela de clientes.
 * Esta classe é usada para mapear a tabela de clientes no banco de dados.
 */
@Entity
@Table(name = "TB_CLIENTES")
public class ClienteModel implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ID do cliente. Este é o campo chave primária.
     */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private UUID idCliente;
    /**
     * Nome do cliente.
     */
    private String nome;
    /**
     * CPF do cliente.
     */
    private String cpf;
    /**
     * Telefone do cliente.
     */
    private String telefone;

    /**
     * Retorna o ID do cliente.
     * @return O ID do cliente.
     */
    public UUID getIdCliente() {
        return idCliente;
    }

    /**
     * Define o ID do cliente.
     * @param idCliente O ID do cliente.
     */
    public void setIdCliente(UUID idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Retorna o nome do cliente.
     * @return O nome do cliente.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do cliente.
     * @param nome O nome do cliente.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o CPF do cliente.
     * @return O CPF do cliente.
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Define o CPF do cliente.
     * @param cpf O CPF do cliente.
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Retorna o telefone do cliente.
     * @return O telefone do cliente.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o telefone do cliente.
     * @param telefone O telefone do cliente.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
