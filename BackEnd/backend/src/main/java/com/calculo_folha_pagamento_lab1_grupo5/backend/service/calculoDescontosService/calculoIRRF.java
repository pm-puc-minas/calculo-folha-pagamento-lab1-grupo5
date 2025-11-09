package com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoDescontosService;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.ICalculosDescontos;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.Funcionario;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoSalarioService.calcularSalarioBase;
import org.springframework.stereotype.Service;

@Service
public class calculoIRRF implements ICalculosDescontos {

    private final calcularSalarioBase salarioBase;

    public calculoIRRF(calcularSalarioBase salarioBase) {
        this.salarioBase = salarioBase;
    }

    @Override
    public double calcularDescontos(Funcionario f) {

        double baseSalario = salarioBase.calcularSalarioBase(f);
        double deducaoDependente = 189.59;
        double totalDeducaoDependentes = f.getDependentes() * deducaoDependente;
        double salarioInicial = baseSalario - totalDeducaoDependentes;
        double aliquota;
        double deducao;
        if (salarioInicial <= 1903.98) {
            aliquota = 0.0;
            deducao = 0.0;
        } else if (salarioInicial <= 2826.65) {
            aliquota = 0.075;
            deducao = 158.40;
        } else if (salarioInicial <= 3751.05) {
            aliquota = 0.15;
            deducao = 370.40;
        } else if (salarioInicial <= 4664.68) {
            aliquota = 0.225;
            deducao = 651.73;
        } else {
            aliquota = 0.275;
            deducao = 884.96;
        }
        double irrf = (salarioInicial * aliquota) - deducao;
        return irrf;
    }
}

