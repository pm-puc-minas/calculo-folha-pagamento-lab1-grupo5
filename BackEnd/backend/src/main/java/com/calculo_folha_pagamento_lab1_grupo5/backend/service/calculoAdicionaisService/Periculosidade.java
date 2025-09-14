package com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoAdicionaisService;
import org.springframework.stereotype.Service;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.CalculoAdicionais;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.Funcionario;

@Service
public class Periculosidade implements CalculoAdicionais{

    public double calcular_adicionais(Funcionario x){
        return 0;
    }
}
