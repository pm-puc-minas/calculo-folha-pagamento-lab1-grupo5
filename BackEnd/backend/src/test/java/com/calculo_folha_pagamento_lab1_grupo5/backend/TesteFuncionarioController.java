package com.calculo_folha_pagamento_lab1_grupo5.backend;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.calculo_folha_pagamento_lab1_grupo5.backend.controller.FuncionarioController;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.Funcionario;
import com.calculo_folha_pagamento_lab1_grupo5.backend.repository.FuncionarioRepository;

@WebMvcTest(FuncionarioController.class)
public class TesteFuncionarioController {

    @Autowired
    private MockMvc mockMvc;
    private FuncionarioRepository funcionarioRepository;

    @Test
    public void testCadastrarFuncionario() throws Exception {
        Funcionario func = new Funcionario();
        func.setNome("João");
        when(funcionarioRepository.save(any(Funcionario.class))).thenReturn(func);

        mockMvc.perform(post("/funcionarios")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nome\":\"João\",\"cargo\":\"Dev\"}"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.nome").value("João"));
    }

    @Test
    public void testListarFuncionarios() throws Exception {
        List<Funcionario> funcs = Arrays.asList(new Funcionario());
        when(funcionarioRepository.findAll()).thenReturn(funcs);

        mockMvc.perform(get("/funcionarios"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$").isArray());
    }
}