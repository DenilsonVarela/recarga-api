package com.example.restapi.repositories;

import com.example.restapi.models.RecargaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Repositório para a entidade RecargaModel.
 * Este repositório é usado para realizar operações de banco de dados na tabela de recargas.
 */
@Repository
public interface RecargaRepository extends JpaRepository<RecargaModel, UUID> {

    /**
     * Busca recargas por ID do cliente.
     * @param idCliente O ID do cliente.
     * @return Uma lista de recargas realizadas pelo cliente.
     */
    List<RecargaModel> findByCliente_IdCliente(UUID idCliente);
}
