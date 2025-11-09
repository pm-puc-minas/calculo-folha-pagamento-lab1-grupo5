package com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoDescontosService;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.ICalculosDescontos;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.Funcionario;
import org.springframework.stereotype.Service;

@Service
public class calculoValeAlimentacao implements ICalculosDescontos{

    @Override
    public double calcularDescontos(Funcionario f){

        if(f.getReceberValeAlimentacao()== false){
            return 0.0;
        }
        if (f.getdiasTrabalhados() <= 0) {
            return 0.0;
        }
        double valeAlimentacao= f.getdiasTrabalhados() * f.getCustoDiarioAlimentacao();

        return valeAlimentacao;
    }
}

