package com.calculo_folha_pagamento_lab1_grupo5.backend;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.Funcionario;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoAdicionaisService.calcularPericulosidade;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestePericulosidade {
    @Test
    void retornaZero(){
        Funcionario f= new Funcionario();
        f.setSalarioBruto(1000.00);
        f.setPericulosidade(false);
        calcularPericulosidade periculosidade= new calcularPericulosidade();
        assertEquals(0, periculosidade.calcularAdicionais(f));
    }

    @Test
    void retornaValorPericulosidade(){
        Funcionario f= new Funcionario();
        f.setSalarioBruto(2000.00);
        f.setPericulosidade(true);
        calcularPericulosidade periculosidade= new calcularPericulosidade();
        assertEquals(600.00, periculosidade.calcularAdicionais(f));
    }
}
