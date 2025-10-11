package com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoSalarioService;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.Funcionario;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoDescontosService.calculoINSS;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoDescontosService.calculoIRRF;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoDescontosService.calculoValeTransporte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class calcularSalarioLiquido {

    private final salarioBrutoTotal salarioBruto;
    private final calculoINSS calculoINSS;
    private final calculoIRRF calculoIRRF;
    private final calculoValeTransporte calculoValeTransporte;

    @Autowired
    public calcularSalarioLiquido(salarioBrutoTotal salarioBruto,calculoINSS calculoINSS,calculoIRRF calculoIRRF,calculoValeTransporte calculoValeTransporte) {
        this.salarioBruto = salarioBruto;
        this.calculoINSS = calculoINSS;
        this.calculoIRRF = calculoIRRF;
        this.calculoValeTransporte= calculoValeTransporte;
    }

    public double calcularLiquido(Funcionario f) {
        double valorSalarioBruto = this.salarioBruto.calcularSalarioBrutoTotal(f);
        double descontoINSS = calculoINSS.calcularDescontos(f);
        double descontoIRRF = calculoIRRF.calcularDescontos(f);
        double descontoTransporte = calculoValeTransporte.calcularDescontos(f);
        double totalDeducoes = descontoINSS + descontoIRRF + descontoTransporte;
        double salarioLiquido = valorSalarioBruto - totalDeducoes;
        return salarioLiquido;
    }
}