package com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoDescontosService;
import org.springframework.stereotype.Service;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.CalculoDescontos;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.Funcionario;

@Service
public class IRRF implements CalculoDescontos {

    public double calcular_descontos(Funcionario x){
        return 0;
    }
}
