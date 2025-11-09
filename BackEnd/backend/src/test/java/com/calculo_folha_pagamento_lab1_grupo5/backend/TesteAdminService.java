package com.calculo_folha_pagamento_lab1_grupo5.backend;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.calculo_folha_pagamento_lab1_grupo5.backend.model.Admin;
import com.calculo_folha_pagamento_lab1_grupo5.backend.repository.AdminRepository;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.AdminService;

@ExtendWith(MockitoExtension.class)
public class TesteAdminService {

    @Mock
    private AdminRepository adminRepository;

    @InjectMocks
    private AdminService adminService;

    @Test
    public void testCriarAdmSucesso() {
        // Simula que o email não existe e salva com sucesso
        when(adminRepository.existsByEmail("teste@teste.com")).thenReturn(false);
        when(adminRepository.save(any(Admin.class))).thenReturn(new Admin());

        Admin result = adminService.criarAdm("Nome", "123", "teste@teste.com", "senha");
        assertNotNull(result);
        verify(adminRepository).save(any(Admin.class));
    }

    @Test
    public void testCriarAdmFalhaEmailExistente() {
        when(adminRepository.existsByEmail("teste@teste.com")).thenReturn(true);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            adminService.criarAdm("Nome", "123", "teste@teste.com", "senha");
        });
        assertNotNull(exception);
    }

    @Test
    public void testAutenticarSucesso() {
        // Simula admin encontrado e senha correta
        Admin admin = new Admin();
        admin.setEmail("teste@teste.com");
        admin.setSenha("$2a$10$mockedHash"); // Hash mockado (use BCrypt para real)
        when(adminRepository.findByEmail("teste@teste.com")).thenReturn(Optional.of(admin));

        boolean result = adminService.Autenticar("teste@teste.com", "senha");
        assertTrue(result);
    }

    @Test
    public void testAutenticarFalhaEmailInexistente() {
        // Simula email não encontrado
        when(adminRepository.findByEmail("teste@teste.com")).thenReturn(Optional.empty());

        boolean result = adminService.Autenticar("teste@teste.com", "senha");
        assertFalse(result);
    }
}