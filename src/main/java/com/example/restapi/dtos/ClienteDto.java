package com.example.restapi.dtos;

import jakarta.validation.constraints.NotBlank;

/**
 * Classe de transferência de dados para o Cliente.
 * Esta classe é usada para receber dados do cliente em requisições.
 */
public class ClienteDto {
    @NotBlank
    private String nome;
    @NotBlank
    private String cpf;
    @NotBlank
    private String telefone;

    /**
     * Construtor para a classe ClienteDto.
     * @param nome O nome do cliente.
     * @param cpf O CPF do cliente.
     * @param telefone O telefone do cliente.
     */
    public ClienteDto(String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
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
