package com.calculo_folha_pagamento_lab1_grupo5.backend;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.Funcionario;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.EGrauInsalubridade;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoSalarioService.salarioBrutoTotal;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoDescontosService.calculoINSS;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoDescontosService.calculoIRRF;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoSalarioService.calcularSalarioBase;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TesteCalculoIRRF {
    @Test
    void testeIRRF(){
        salarioBrutoTotal totalSalarioBruto = new salarioBrutoTotal();
        calcularSalarioBase calcularSalarioBase = new calcularSalarioBase(totalSalarioBruto, new calculoINSS(totalSalarioBruto));
        calculoIRRF calcularIRRF = new calculoIRRF(calcularSalarioBase);
        Funcionario f = new Funcionario();
        f.setPericulosidade(false);
        f.setInsalubridade(EGrauInsalubridade.NENHUM);

        f.setSalarioBruto(3000.0);
        f.setDependentes(0);
        assertEquals(46.85, calcularIRRF.calcularDescontos(f),0.01);

        f.setSalarioBruto(3000.0);
        f.setDependentes(2);
        assertEquals(18.41, calcularIRRF.calcularDescontos(f), 0.01);
    }

    @Test
    void retornaZero(){
        salarioBrutoTotal totalSalarioBruto = new salarioBrutoTotal();
        calculoINSS calculoINSS = new calculoINSS(totalSalarioBruto);
        calculoIRRF calcularIRRF = new calculoIRRF(new calcularSalarioBase(totalSalarioBruto, calculoINSS));
        Funcionario f = new Funcionario();
        f.setPericulosidade(false);
        f.setInsalubridade(EGrauInsalubridade.NENHUM);

        f.setSalarioBruto(0.0);
        f.setDependentes(0);
        assertEquals(0.0, calcularIRRF.calcularDescontos(f));
    }
}
