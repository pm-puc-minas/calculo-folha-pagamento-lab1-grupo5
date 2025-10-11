package com.calculo_folha_pagamento_lab1_grupo5.backend;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.Funcionario;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.EGrauInsalubridade;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoSalarioService.salarioBrutoTotal;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoDescontosService.calculoINSS;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoSalarioService.calcularSalarioBase;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TesteCalculoSalarioBase {
    @Test
    void testeSalarioBase(){
        salarioBrutoTotal totalSalarioBruto = new salarioBrutoTotal();
        calculoINSS calculoINSS = new calculoINSS(totalSalarioBruto);
        calcularSalarioBase calcularSalarioBase = new calcularSalarioBase(totalSalarioBruto, calculoINSS);
        Funcionario f = new Funcionario();
        f.setPericulosidade(false);
        f.setInsalubridade(EGrauInsalubridade.NENHUM);

        f.setSalarioBruto(3000.0);
        assertEquals(2736.67, calcularSalarioBase.calcularSalarioBase(f), 0.01);

        f.setSalarioBruto(2000.0);
        assertEquals(1839.53, calcularSalarioBase.calcularSalarioBase(f), 0.01);

        f.setSalarioBruto(1000.0);
        assertEquals(925.00, calcularSalarioBase.calcularSalarioBase(f), 0.01);
    }
}
