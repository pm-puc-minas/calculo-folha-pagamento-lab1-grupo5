package com.calculo_folha_pagamento_lab1_grupo5.backend.model;
import jakarta.persistence.Entity;

@Entity
public class Admin{

    private Long AdminId;

    public Long getId() {
        return AdminId;
    }
    
}
