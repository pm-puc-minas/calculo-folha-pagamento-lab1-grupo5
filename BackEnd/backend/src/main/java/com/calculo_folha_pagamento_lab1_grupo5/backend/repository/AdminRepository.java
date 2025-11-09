package com.calculo_folha_pagamento_lab1_grupo5.backend.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.Admin;

public interface AdminRepository extends JpaRepository <Admin, Long> {
    Optional<Admin> findByEmail(String email);
    boolean existsByEmail(String email);
}
