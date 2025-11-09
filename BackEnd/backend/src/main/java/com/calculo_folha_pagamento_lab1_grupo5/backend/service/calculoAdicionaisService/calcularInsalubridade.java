package com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoAdicionaisService;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.Funcionario;
import org.springframework.stereotype.Service;

@Service
public class calcularInsalubridade implements com.calculo_folha_pagamento_lab1_grupo5.backend.model.ICalculosAdicionais {

    @Override
    public double calcularAdicionais(Funcionario f) {
        return switch (f.getInsalubridade()) {
            case MAXIMA -> (f.getSalarioBruto() * 0.40);
            case MEDIA -> (f.getSalarioBruto() * 0.20);
            case MINIMA -> (f.getSalarioBruto() * 0.10);
            default -> 0.0;
        };
    }   
}