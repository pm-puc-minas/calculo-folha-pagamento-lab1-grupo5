package com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoDescontosService;
import org.springframework.stereotype.Service;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.iCalculoDescontos;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.Funcionario;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoSalarioService.salarioBrutoTotal;

@Service
public class calculoINSS implements iCalculoDescontos {

    private final salarioBrutoTotal salarioBruto;

    public calculoINSS(salarioBrutoTotal salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    @Override
    public double calcularDescontos(Funcionario f) {
        double salarioInicial = salarioBruto.calcularSalarioBrutoTotal(f);

        double tetoINSS = 7507.49;
        if (salarioInicial > tetoINSS) {
            salarioInicial = tetoINSS;
        }

        double limiteFaixa1 = 1302.00;
        double limiteFaixa2 = 2571.29;
        double limiteFaixa3 = 3856.94;

        double descontoTotal = 0.0;

        if (salarioInicial > 0) {
            double valorNestaFaixa = Math.min(salarioInicial, limiteFaixa1);
            descontoTotal += valorNestaFaixa * 0.075;
        }
        if (salarioInicial > limiteFaixa1) {
            double valorNestaFaixa = Math.min(salarioInicial - limiteFaixa1, limiteFaixa2 - limiteFaixa1);
            descontoTotal += valorNestaFaixa * 0.09;
        }
        if (salarioInicial > limiteFaixa2) {
            double valorNestaFaixa = Math.min(salarioInicial - limiteFaixa2, limiteFaixa3 - limiteFaixa2);
            descontoTotal += valorNestaFaixa * 0.12;
        }
        if (salarioInicial > limiteFaixa3) {
            double valorNestaFaixa = salarioInicial - limiteFaixa3;
            descontoTotal += valorNestaFaixa * 0.14;
        }
        
        return descontoTotal;
    }
}
