package com.calculo_folha_pagamento_lab1_grupo5.backend.model;

import jakarta.persistence.Entity;
//Admin não é Usuário?
@Entity
public class Admin {

    private Long idAdmin;

    public Long getId() {
        return idAdmin;
    }
}
