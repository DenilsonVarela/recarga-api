package com.example.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlataformaRecargaService {
    @Autowired
    private PlataformaRecargaMock plataformaRecargaMock;

    public boolean realizarRecarga(String numeroTelefone, Double valor) {
        return plataformaRecargaMock.realizarRecarga(numeroTelefone, valor);
    }
}

