package com.calculo_folha_pagamento_lab1_grupo5.backend;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.Funcionario;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.EGrauInsalubridade;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoDescontosService.calculoFGTS;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoSalarioService.salarioBrutoTotal;

public class TesteCalculoFGTS {
    @Test
    void Teste(){
        salarioBrutoTotal totalSalarioBruto = new salarioBrutoTotal();
        calculoFGTS FGTS = new calculoFGTS(totalSalarioBruto);
        Funcionario f = new Funcionario();
        f.setPericulosidade(false);
        f.setInsalubridade(EGrauInsalubridade.NENHUM);
        f.setSalarioBruto(2500.0);
        assertEquals(200.00, FGTS.calcularAdicionais(f));
    }

    @Test
    void retornaZero(){
        salarioBrutoTotal totalSalarioBruto = new salarioBrutoTotal();
        calculoFGTS FGTS = new calculoFGTS(totalSalarioBruto);
        Funcionario f = new Funcionario();
        f.setPericulosidade(false);
        f.setInsalubridade(EGrauInsalubridade.NENHUM);
        // 8%
        f.setSalarioBruto(0.0);
        assertEquals(0.0, FGTS.calcularAdicionais(f));
    }
}
