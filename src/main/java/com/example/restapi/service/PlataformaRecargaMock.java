package com.example.restapi.service;

import org.springframework.stereotype.Service;

@Service
public class PlataformaRecargaMock {
    public boolean realizarRecarga(String numeroTelefone, Double valor) {
        return Math.random() > 0.2;
    }
}

