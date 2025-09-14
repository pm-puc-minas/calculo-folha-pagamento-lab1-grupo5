package com.calculo_folha_pagamento_lab1_grupo5.backend.model;
import java.util.ArrayList;
import jakarta.persistence.Entity;

@Entity
public class Gestao {

    private ArrayList<Funcionario> funcionarios= new ArrayList<>();
    private Admin administrador;

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public Admin getAdministrador() {
        return administrador;
    }
}
