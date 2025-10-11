package com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoSalarioService;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.Funcionario;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoDescontosService.calculoINSS;
import org.springframework.stereotype.Service;

@Service
public class calcularSalarioBase {

    private final salarioBrutoTotal salarioBrutoTotal;
    private final calculoINSS calculoINSS;

    public calcularSalarioBase(salarioBrutoTotal salarioBruto, calculoINSS calculoINSS){
        this.salarioBrutoTotal = salarioBruto;
        this.calculoINSS = calculoINSS;
    }
    
    public double calcularSalarioBase (Funcionario f) {
        double salarioBruto = salarioBrutoTotal.calcularSalarioBrutoTotal(f);
        double descontoINSS = calculoINSS.calcularDescontos(f);
        double salarioBase = salarioBruto - descontoINSS;
        return salarioBase;
    }
}