package com.calculo_folha_pagamento_lab1_grupo5.backend;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.Funcionario;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoDescontosService.calculoValeAlimentacao;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TesteValeAlimentacao {
    @Test
    void retornaZero(){
        Funcionario f= new Funcionario();
        f.setReceberValeAlimentacao(false);
        f.setDiasTrabalhados(20);
        f.setCustoDiarioAlimentacao(30.00);
        calculoValeAlimentacao alimentacao = new calculoValeAlimentacao();
        assertEquals(0.0, alimentacao.calcularDescontos(f));
    }

    @Test
    void retornaValorVA(){
        Funcionario f= new Funcionario();
        f.setReceberValeAlimentacao(true);
        f.setDiasTrabalhados(20);
        f.setCustoDiarioAlimentacao(30.00);
        calculoValeAlimentacao alimentacao = new calculoValeAlimentacao();
        assertEquals(600.00, alimentacao.calcularDescontos(f));
    }
}
