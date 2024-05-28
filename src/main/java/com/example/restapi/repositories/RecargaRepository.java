package com.example.restapi.repositories;

import com.example.restapi.models.RecargaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RecargaRepository extends JpaRepository<RecargaModel, UUID> {

    List<RecargaModel> findByCliente_IdCliente(UUID idCliente);
}
