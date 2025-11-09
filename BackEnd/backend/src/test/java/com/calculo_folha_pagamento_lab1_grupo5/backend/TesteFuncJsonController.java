package com.calculo_folha_pagamento_lab1_grupo5.backend;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.calculo_folha_pagamento_lab1_grupo5.backend.controller.FuncJsonController;
import com.calculo_folha_pagamento_lab1_grupo5.backend.DTO.FuncDTO;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.Funcionario;
import com.calculo_folha_pagamento_lab1_grupo5.backend.repository.FuncionarioRepository;

@ExtendWith(MockitoExtension.class)
public class TesteFuncJsonController {

    @Mock
    private FuncionarioRepository funcRepository;

    @InjectMocks
    private FuncJsonController controller;

    @Test
    public void testSalvarFuncionarioSucesso() {
        Funcionario func = new Funcionario();
        func.setIdFuncionario(1L);
        func.setNome("João");
        func.setCargo("Dev");
        func.setDataAdmissao(java.time.LocalDate.now());
        when(funcRepository.findById(1L)).thenReturn(Optional.of(func));
        String result = controller.salvarFuncionario(1L);
        assertEquals("Funcionário salvo com sucesso!", result);
        assertTrue(Files.exists(Paths.get("funcionario.json")));
    }

    @Test
    public void testSalvarFuncionarioFalha() {
        when(funcRepository.findById(1L)).thenReturn(Optional.empty());

        String result = controller.salvarFuncionario(1L);
        assertEquals("Funcionário não encontrado.", result);
    }

    @Test
    public void testCarregarFuncionario() {
        FuncDTO DTO = controller.carregarFuncionario();
        assertNotNull(DTO);
    }
}