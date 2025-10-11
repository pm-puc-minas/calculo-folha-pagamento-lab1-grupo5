package com.calculo_folha_pagamento_lab1_grupo5.backend;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.Funcionario;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.EGrauInsalubridade;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoSalarioService.salarioBrutoTotal;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoDescontosService.calculoValeTransporte;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TesteValeTransporte {
    @Test
    void retornaZero(){
        Funcionario f= new Funcionario();
        f.setReceberValeTransporte(false);
        f.setSalarioBruto(2000.00);

        salarioBrutoTotal salarioBruto= new salarioBrutoTotal();
        calculoValeTransporte transporte= new calculoValeTransporte(salarioBruto);

        assertEquals(0.0, transporte.calcularDescontos(f));
    }

    @Test
    void retornaValor(){
        Funcionario f= new Funcionario();
        f.setReceberValeTransporte(true);
        f.setSalarioBruto(3000.00);
        f.setCustoValeTransporte(80.00);
        f.setPericulosidade(false);
        f.setInsalubridade(EGrauInsalubridade.NENHUM);

        salarioBrutoTotal salarioBruto= new salarioBrutoTotal();
        calculoValeTransporte transporte= new calculoValeTransporte(salarioBruto);

        assertEquals(80.00, transporte.calcularDescontos(f));

        f.setCustoValeTransporte(200.00);
        assertEquals(180.00, transporte.calcularDescontos(f));

    }
}
