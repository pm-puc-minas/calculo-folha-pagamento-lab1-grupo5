package com.calculo_folha_pagamento_lab1_grupo5.backend;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.Funcionario;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.EGrauInsalubridade;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoAdicionaisService.calcularInsalubridade;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TesteInsalubridade {
    @Test
    void retornaZero(){
        Funcionario f= new Funcionario();
        f.setInsalubridade(EGrauInsalubridade.NENHUM);
        calcularInsalubridade insalubridade = new calcularInsalubridade();
        assertEquals(0.0, insalubridade.calcularAdicionais(f));
    }

    @Test
    void retornaValorNivel(){

        Funcionario f= new Funcionario();
        f.setSalarioBruto(5000.00);
        f.setInsalubridade(EGrauInsalubridade.MAXIMA);
        calcularInsalubridade insalubridade = new calcularInsalubridade();
        assertEquals(2000.00, insalubridade.calcularAdicionais(f));

        f.setInsalubridade(EGrauInsalubridade.MEDIA);
        assertEquals(1000.00, insalubridade.calcularAdicionais(f));

        f.setInsalubridade(EGrauInsalubridade.MINIMA);
        assertEquals(500.00, insalubridade.calcularAdicionais(f));
    }
}