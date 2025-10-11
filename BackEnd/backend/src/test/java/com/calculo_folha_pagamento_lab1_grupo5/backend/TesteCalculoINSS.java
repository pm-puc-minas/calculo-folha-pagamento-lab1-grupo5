package com.calculo_folha_pagamento_lab1_grupo5.backend;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.Funcionario;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.EGrauInsalubridade;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoSalarioService.salarioBrutoTotal;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoDescontosService.calculoINSS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TesteCalculoINSS {
    @Test
    void testeFaixaProgressiva(){
        salarioBrutoTotal totalSalarioBruto = new salarioBrutoTotal();
        calculoINSS calculoINSS = new calculoINSS(totalSalarioBruto);
        Funcionario f = new Funcionario();
        f.setPericulosidade(false);
        f.setInsalubridade(EGrauInsalubridade.NENHUM);

        f.setSalarioBruto(1000.00);
        assertEquals(75.00, calculoINSS.calcularDescontos(f));

        f.setSalarioBruto(2000.00);
        assertEquals(160.47, calculoINSS.calcularDescontos(f));

        f.setSalarioBruto(3000.00);
        assertEquals(263.33, calculoINSS.calcularDescontos(f), 0.01);

        f.setSalarioBruto(4000.00);
        assertEquals(386.19, calculoINSS.calcularDescontos(f), 0.01);

        f.setSalarioBruto(7507.49);
        assertEquals(877.24, calculoINSS.calcularDescontos(f), 0.01);

        f.setSalarioBruto(10000.00);
        assertEquals(877.24, calculoINSS.calcularDescontos(f), 0.01);
    }
}