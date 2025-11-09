package com.calculo_folha_pagamento_lab1_grupo5.backend;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.calculo_folha_pagamento_lab1_grupo5.backend.controller.AdmController;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.Admin;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.AdminService;

@WebMvcTest(AdmController.class)
public class TesteAdmController {

    @Autowired
    private MockMvc mockMvc;
    private AdminService adminService;

    @Test
    public void testRegistrarAdminSucesso() throws Exception {
        // Simula sucesso no serviço (retorna um Admin)
        when(adminService.criarAdm(anyString(), anyString(), anyString(), anyString()))
            .thenReturn(new Admin());

        mockMvc.perform(post("/admin/registrar")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nome\":\"Teste\",\"cpf\":\"123\",\"email\":\"teste@teste.com\",\"senha\":\"123\"}"))
               .andExpect(status().isOk())
               .andExpect(content().string("Administrador criado com sucesso!"));
    }

    @Test
    public void testRegistrarAdminFalha() throws Exception {
        // Simula falha (exceção no serviço)
        when(adminService.criarAdm(anyString(), anyString(), anyString(), anyString()))
            .thenThrow(new IllegalArgumentException("Email já existe"));

        mockMvc.perform(post("/admin/registrar")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nome\":\"Teste\",\"cpf\":\"123\",\"email\":\"teste@teste.com\",\"senha\":\"123\"}"))
               .andExpect(status().isBadRequest())
               .andExpect(content().string("Email já existe"));
    }

    @Test
    public void testLogarAdminSucesso() throws Exception {
        // Simula login bem-sucedido
        when(adminService.Autenticar("teste@teste.com", "123")).thenReturn(true);

        mockMvc.perform(post("/admin/logar")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"email\":\"teste@teste.com\",\"senha\":\"123\"}"))
               .andExpect(status().isOk())
               .andExpect(content().string("Login realizado com sucesso!!"));
    }

    @Test
    public void testLogarAdminFalha() throws Exception {
        // Simula falha no login
        when(adminService.Autenticar("teste@teste.com", "123")).thenReturn(false);

        mockMvc.perform(post("/admin/logar")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"email\":\"teste@teste.com\",\"senha\":\"123\"}"))
               .andExpect(status().isUnauthorized())
               .andExpect(content().string("Email ou senha incorretos!"));
    }
}