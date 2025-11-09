package com.calculo_folha_pagamento_lab1_grupo5.backend;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.Funcionario;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.EGrauInsalubridade;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoSalarioService.calcularSalarioLiquido;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoSalarioService.salarioBrutoTotal;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoDescontosService.calculoINSS;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoDescontosService.calculoIRRF;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoSalarioService.calcularSalarioBase;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoDescontosService.calculoValeTransporte;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TesteCalculoSalarioLiquido {
    @Test
    void apenasSalarioBruto(){
        salarioBrutoTotal totalSalarioBruto = new salarioBrutoTotal();
        calcularSalarioBase calcularSalarioBase = new calcularSalarioBase(totalSalarioBruto, new calculoINSS(totalSalarioBruto));
        calculoINSS calculoINSS = new calculoINSS(totalSalarioBruto);
        calculoIRRF calcularIRRF = new calculoIRRF(calcularSalarioBase);
        calculoValeTransporte calcularValeTransporte = new calculoValeTransporte(totalSalarioBruto);
        calcularSalarioLiquido calcLiquido = new calcularSalarioLiquido(totalSalarioBruto, calculoINSS, calcularIRRF, calcularValeTransporte);

        Funcionario f = new Funcionario();

        f.setSalarioBruto(2000.0);
        f.setReceberValeAlimentacao(false);
        f.setReceberValeTransporte(false);
        f.setPericulosidade(false);  // Sem periculosidade
        f.setInsalubridade(EGrauInsalubridade.NENHUM);  // Sem insalubridade
        f.setDependentes(0);
        assertEquals(1839.53,calcLiquido.calcularLiquido(f));
    }

    @Test
    void salarioAlteracoes(){
        salarioBrutoTotal totalSalarioBruto = new salarioBrutoTotal();
        calculoINSS calculoINSS = new calculoINSS(totalSalarioBruto);
        calculoIRRF calcularIRRF = new calculoIRRF(new calcularSalarioBase(totalSalarioBruto, calculoINSS));
        calculoValeTransporte calcularValeTransporte = new calculoValeTransporte(totalSalarioBruto);
        calcularSalarioLiquido calcLiquido = new calcularSalarioLiquido(totalSalarioBruto, calculoINSS, calcularIRRF, calcularValeTransporte);

        Funcionario f = new Funcionario();
        f.setSalarioBruto(2000.0);
        f.setInsalubridade(EGrauInsalubridade.NENHUM);
        f.setPericulosidade(false);
        f.setReceberValeAlimentacao(true);
        f.setCustoDiarioAlimentacao(50.0);
        f.setDiasTrabalhados(20);
        f.setReceberValeTransporte(true);
        f.setCustoValeTransporte(80.0);
        //2000-160.47-0-80 = 1759.53
        assertEquals(1759.53,calcLiquido.calcularLiquido(f));
    }
}
