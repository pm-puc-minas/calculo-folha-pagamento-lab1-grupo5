package com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoSalarioService;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.iCalculoAdicionais;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.Funcionario;
import org.springframework.stereotype.Service;

@Service
public class calculoSalarioHora implements iCalculoAdicionais {

    private final salarioBrutoTotal salarioBruto;
    public calculoSalarioHora(salarioBrutoTotal salarioBruto){
        this.salarioBruto=salarioBruto;
    }

    @Override
    public double calcularAdicionais(Funcionario f){
        double jornadaSemanal= f.getCargaHorariaDiaria() *f.getDiasTrabalhadasSemana();

        // verificar a carga a horaria diaria
        if(f.getCargaHorariaDiaria() > 8 ){
            throw new IllegalArgumentException("Carga Horária excedida pelo CLT");
        }
        if(jornadaSemanal>44){
            throw new IllegalArgumentException("Carga Horária semanal excedida pelo CLT");
        }

        double jornadaMensal= jornadaSemanal * 4.5;
        return salarioBruto.calcularSalarioBrutoTotal(f) / jornadaMensal;
    } 

}