package com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoSalarioService;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.Funcionario;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoAdicionaisService.calcularInsalubridade;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoAdicionaisService.calcularPericulosidade;
import org.springframework.stereotype.Service;

@Service
public class salarioBrutoTotal {

    public double calcularSalarioBrutoTotal(Funcionario f){
        calcularInsalubridade insalubridade= new calcularInsalubridade();
        calcularPericulosidade periculosidade = new calcularPericulosidade();

        //caso tenha insalubridade e periculosidade

        if(f.getInsalubridade() != null && f.getPericulosidade() == true){
            return f.getSalarioBruto() + periculosidade.calcularAdicionais(f);
        } else if(f.getInsalubridade() == null && f.getPericulosidade() == true){
            return f.getSalarioBruto() + periculosidade.calcularAdicionais(f);
        } else if(f.getInsalubridade() != null && f.getPericulosidade() == false){
            return f.getSalarioBruto() + insalubridade.calcularAdicionais(f);
        }

        //caso nao tenha insalubridade ou periculosidade
        
        return f.getSalarioBruto();
    }
}
