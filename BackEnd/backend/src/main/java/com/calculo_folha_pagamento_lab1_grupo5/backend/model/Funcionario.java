package com.calculo_folha_pagamento_lab1_grupo5.backend.model;
import java.time.LocalDate;
import jakarta.persistence.Entity;

@Entity
public class Funcionario extends Usuario {

    private Long idFuncionario;
    private String cargo;
    private Double salarioBruto;
    private Double cargaHorariaDiaria;
    private int horasTrabalhadas;
    private int diasTrabalhadasSemana;
    private int diasTrabalhados;
    private LocalDate dataAdmissao;
    private Boolean receberValeTransporte=false;
    private Boolean receberValeAlimentacao=false;
    private Double custoValeTransporte;
    private Double custoDiarioAlimentacao;
    private Boolean periculosidade;
    private EGrauInsalubridade insalubridade;
    private int dependentes;

    //getters
    public Long getIdFuncionario() {
        return idFuncionario;
    }
    public String getCargo() {
        return cargo;
    }
    public double getSalarioBruto() {
        return salarioBruto;
    }
    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }
    public int getDiasTrabalhadasSemana() {
        return diasTrabalhadasSemana;
    }
    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }
    public Boolean getReceberValeTransporte() {
        return receberValeTransporte;
    }
    public Boolean getReceberValeAlimentacao() {
        return receberValeAlimentacao;
    }
    public Boolean getPericulosidade() {
        return periculosidade;
    }
    public EGrauInsalubridade getInsalubridade() {
        return insalubridade;
    }
    public Double getCargaHorariaDiaria() {
        return cargaHorariaDiaria;
    }

    public boolean isPericulosidade(){
        return periculosidade;
    }

    public EGrauInsalubridade isInsalubridade(){
        return insalubridade;
    }
    public Double getCustoValeTransporte() {
        return custoValeTransporte;
    }
    public Double getCustoDiarioAlimentacao() {
        return custoDiarioAlimentacao;
    }
    public int getdiasTrabalhados() {
        return diasTrabalhados;
    }
    public int getDependentes() {
        return dependentes;
    }
    public void setIdFuncionario(Long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public void setSalarioBruto(Double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }
    public void setCargaHorariaDiaria(Double cargaHorariaDiaria) {
        this.cargaHorariaDiaria = cargaHorariaDiaria;
    }
    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }
    public void setDiasTrabalhadasSemana(int diasTrabalhadasSemana) {
        this.diasTrabalhadasSemana = diasTrabalhadasSemana;
    }
    public void setdiasTrabalhados(int diasTrabalhados) {
        this.diasTrabalhados = diasTrabalhados;
    }
    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }
    public void setReceberValeTransporte(Boolean receberValeTransporte) {
        this.receberValeTransporte = receberValeTransporte;
    }
    public void setReceberValeAlimentacao(Boolean receberValeAlimentacao) {
        this.receberValeAlimentacao = receberValeAlimentacao;
    }
    public void setCustoValeTransporte(Double custoValeTransporte) {
        this.custoValeTransporte = custoValeTransporte;
    }
    public void setCustoDiarioAlimentacao(Double custoDiarioAlimentacao) {
        this.custoDiarioAlimentacao = custoDiarioAlimentacao;
    }
    public void setPericulosidade(Boolean periculosidade) {
        this.periculosidade = periculosidade;
    }
    public void setInsalubridade(EGrauInsalubridade insalubridade) {
        this.insalubridade = insalubridade;
    }
    public void setDependentes(int dependentes) {
        this.dependentes = dependentes;
    }
}