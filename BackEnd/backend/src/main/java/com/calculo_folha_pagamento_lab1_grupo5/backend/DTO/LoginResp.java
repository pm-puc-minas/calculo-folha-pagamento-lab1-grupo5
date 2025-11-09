package com.calculo_folha_pagamento_lab1_grupo5.backend.DTO;

public class LoginResp {

    private String mensagem;

    public LoginResp(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}

