package com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoDescontosService;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.iCalculoAdicionais;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.Funcionario;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoSalarioService.salarioBrutoTotal;
import org.springframework.stereotype.Service;

@Service
public class calculoFGTS implements iCalculoAdicionais {
    private final salarioBrutoTotal salarioBruto;

    public calculoFGTS(salarioBrutoTotal salarioBruto){
        this.salarioBruto=salarioBruto;
    }

    @Override
    public double calcularAdicionais(Funcionario f){
        return salarioBruto.calcularSalarioBrutoTotal(f) * 0.08;
    }
}
