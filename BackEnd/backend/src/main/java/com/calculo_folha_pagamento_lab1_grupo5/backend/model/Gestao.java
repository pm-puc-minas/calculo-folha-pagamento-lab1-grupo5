package com.calculo_folha_pagamento_lab1_grupo5.backend.model;
import java.util.ArrayList;
import jakarta.persistence.Entity;

@Entity
public class Gestao {

    private final ArrayList<Funcionario> funcionarios= new ArrayList<>();
    private Admin admin;
    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }
    public Admin getAdmin() {
        return admin;
    }
}
