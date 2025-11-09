package com.calculo_folha_pagamento_lab1_grupo5.backend.DTO;

import java.time.LocalDate;

public class FolhaPagDTO {

    private Long idFolhaPagamento;
    private String nome;
    private LocalDate dataGeracao;
    private double SalarioLiquido;

    public FolhaPagDTO(String nome, LocalDate dataGeracao, double SalarioLiquido){
        this.dataGeracao=dataGeracao;
        this.SalarioLiquido= SalarioLiquido;
    }

    public FolhaPagDTO (){} 

    public String getNome() {
        return nome;
    }

    public LocalDate getDataGeracao() {
        return dataGeracao;
    }
    
    public double getSalarioLiquido() {
        return SalarioLiquido;
    }

    public void setDataGeracao(LocalDate dataGeracao) {
        this.dataGeracao = dataGeracao;
    }

    public void setSalarioLiquido(double salarioLiquido) {
        SalarioLiquido = salarioLiquido;
    }

    public Long getIdFolhaPagamento() {
        return idFolhaPagamento;
    }

    public void setIdFolhaPagamento(Long idFolhaPagamento) {
        this.idFolhaPagamento = idFolhaPagamento;
    }  
}
