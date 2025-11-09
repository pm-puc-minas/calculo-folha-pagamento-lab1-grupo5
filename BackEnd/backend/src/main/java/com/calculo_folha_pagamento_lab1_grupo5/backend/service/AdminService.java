package com.calculo_folha_pagamento_lab1_grupo5.backend.service;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.List;
import java.util.Optional;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.Admin;
import com.calculo_folha_pagamento_lab1_grupo5.backend.repository.AdminRepository;

@Service
public class AdminService {

    private final AdminRepository admRepor;
    private final BCryptPasswordEncoder senhaEncriptada = new BCryptPasswordEncoder();

    public AdminService(AdminRepository admRepor) {
        this.admRepor = admRepor;
    }

    public Admin criarAdm(String nome, String cpf, String email, String senha) {

        if (admRepor.existsByEmail(email)) {
            throw new IllegalArgumentException("Administrador com esse email já cadastrado!");
        }
        Admin novoAdm = new Admin();
        novoAdm.setNome(nome);
        novoAdm.setCpf(cpf);
        novoAdm.setEmail(email);
        novoAdm.setSenha(senhaEncriptada.encode(senha));
        return admRepor.save(novoAdm);
    }

    public boolean Autenticar(String email, String senha) {
        Optional<Admin> opt = admRepor.findByEmail(email);
        if (opt.isEmpty()) {
            return false;
        }
        Admin admin = opt.get();
        return senhaEncriptada.matches(senha, admin.getSenha());
    }

    public List<Admin> listarTodosAdmin() {
        return admRepor.findAll();
    }

}

