package com.calculo_folha_pagamento_lab1_grupo5.backend.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.Admin;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdmController {

    private final AdminService adm;

    public AdmController(AdminService adm) {
        this.adm = adm;
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody Admin novoAdm) {
        try {
            adm.criarAdm(novoAdm.getNome(), novoAdm.getCpf(), novoAdm.getEmail(), novoAdm.getSenha());
            return ResponseEntity.ok("Administrador criado com sucesso!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // logar via JSON
    @PostMapping("/logar")
    public ResponseEntity<?> login(@RequestBody Admin dadosLogin) {
        boolean autenticadoSucesso = adm.Autenticar(dadosLogin.getEmail(), dadosLogin.getSenha());

        if (autenticadoSucesso) {
            return ResponseEntity.ok("Login realizado com sucesso!!");
        } else {
            return ResponseEntity.status(401).body("Email ou senha incorretos!");
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(adm.listarTodosAdmin());
    }
}    