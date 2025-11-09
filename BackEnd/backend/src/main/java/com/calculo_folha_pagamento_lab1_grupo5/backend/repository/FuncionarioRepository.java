package com.calculo_folha_pagamento_lab1_grupo5.backend.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    Optional<Funcionario> findByCpf(String cpf);

}
