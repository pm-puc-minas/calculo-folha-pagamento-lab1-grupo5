package com.calculo_folha_pagamento_lab1_grupo5.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.FolhaPagamento;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.Funcionario;
import java.util.Optional;

public interface FolhaPagRepository extends JpaRepository<FolhaPagamento, Long> {
    Optional<FolhaPagamento> findByFuncionario(Funcionario funcionario);
}

