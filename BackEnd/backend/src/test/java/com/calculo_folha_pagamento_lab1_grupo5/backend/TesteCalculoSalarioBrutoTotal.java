package com.calculo_folha_pagamento_lab1_grupo5.backend;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.Funcionario;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoSalarioService.salarioBrutoTotal;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.EGrauInsalubridade;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TesteCalculoSalarioBrutoTotal {
    @Test
    void retornaZero() {
        Funcionario f = new Funcionario();
        f.setSalarioBruto(0.0);
        f.setInsalubridade(EGrauInsalubridade.NENHUM);
        f.setPericulosidade(false);

        salarioBrutoTotal total = new salarioBrutoTotal();
        double resultado = total.calcularSalarioBrutoTotal(f);
        assertEquals(0.0, resultado);
    }

    @Test
    void salarioPericulosidade() {
        Funcionario f = new Funcionario();
        f.setSalarioBruto(2000.0);
        f.setInsalubridade(EGrauInsalubridade.NENHUM);
        f.setPericulosidade(true);

        salarioBrutoTotal total = new salarioBrutoTotal();
        double resultado = total.calcularSalarioBrutoTotal(f);
        assertEquals(2600.0, resultado);
    }

    @Test
    void salarioInsalubridade() {
        Funcionario f = new Funcionario();
        f.setSalarioBruto(2000.0);
        f.setInsalubridade(EGrauInsalubridade.MEDIA);
        f.setPericulosidade(false);

        salarioBrutoTotal total = new salarioBrutoTotal();
        double resultado = total.calcularSalarioBrutoTotal(f);
        assertEquals(2400.0, resultado);
    }
}
