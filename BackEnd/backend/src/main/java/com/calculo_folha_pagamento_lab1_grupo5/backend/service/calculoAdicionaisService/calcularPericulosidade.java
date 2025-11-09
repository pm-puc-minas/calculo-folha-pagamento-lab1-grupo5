package com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoAdicionaisService;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.Funcionario;
import org.springframework.stereotype.Service;

@Service
public class calcularPericulosidade implements com.calculo_folha_pagamento_lab1_grupo5.backend.model.ICalculosAdicionais {

    @Override
    public double calcularAdicionais(Funcionario f) {
        if(f.getPericulosidade() == true){
            return f.getSalarioBruto() * 0.30;
        } else {
            return 0.0; // se não tiver risco, retorna sem adicional
        }
    }
}

