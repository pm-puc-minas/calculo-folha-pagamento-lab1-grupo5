package com.calculo_folha_pagamento_lab1_grupo5.backend.DTO;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginReq {

    @Email(message = "Email inválido")
    @NotBlank(message = "O email tem que ser obrigatório")
    private String email;

    @NotBlank(message = "A senha tem que ser obrigatória")
    private String senha;

    // Getters e Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
