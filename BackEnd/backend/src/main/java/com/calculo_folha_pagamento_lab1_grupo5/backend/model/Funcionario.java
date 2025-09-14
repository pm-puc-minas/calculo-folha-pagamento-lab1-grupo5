package com.calculo_folha_pagamento_lab1_grupo5.backend.model;
import jakarta.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Funcionario extends Usuario {

    private Long funcionario_id;
    private String cargo;
    private Double salario_base;
    private int horas_trabalhadas;
    private int dias_trabalhados_semana;
    private LocalDate data_admissao;
    private Boolean receber_vale_transporte;
    private Boolean receber_vale_alimentacao;
    private Boolean periculosidade;
    private GrauInsalubridade insalubridade;

    public Long getIdFuncionario() {
        return funcionario_id;
    }
    public String getCargo() {
        return cargo;
    }
    public Double getSalarioBase() {
        return salario_base;
    }
    public int getHorasTrabalhadas() {
        return horas_trabalhadas;
    }
    public int getDiasTrabalhadosSemana() {
        return dias_trabalhados_semana;
    }
    public LocalDate getDataAdmissao() {
        return data_admissao;
    }
    public Boolean getReceberValeTransporte() {
        return receber_vale_transporte;
    }
    public Boolean getReceberValeAlimentacao() {
        return receber_vale_alimentacao;
    }
    public Boolean getPericulosidade() {
        return periculosidade;
    }
    public GrauInsalubridade getInsalubridade() {
        return insalubridade;
    }
}