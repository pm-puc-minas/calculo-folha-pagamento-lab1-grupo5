package com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoDescontosService;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.iCalculoDescontos;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.Funcionario;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoSalarioService.salarioBrutoTotal;
import org.springframework.stereotype.Service;

@Service
public class calculoValeTransporte implements iCalculoDescontos {

    private final salarioBrutoTotal totalSalarioBruto;

    public calculoValeTransporte(salarioBrutoTotal totalSalarioBruto) {
        this.totalSalarioBruto = totalSalarioBruto;
    }

    @Override
    public double calcularDescontos(Funcionario f) {

        if (f.getReceberValeTransporte() == false) {
            return 0.0;
        }

        double teto = totalSalarioBruto.calcularSalarioBrutoTotal(f) * 0.06;
        double custoTotalTransporte = f.getCustoValeTransporte();
        return Math.min(teto, custoTotalTransporte);
    }
}
