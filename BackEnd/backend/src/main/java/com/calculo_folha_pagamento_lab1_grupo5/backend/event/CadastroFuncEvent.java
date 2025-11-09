package com.calculo_folha_pagamento_lab1_grupo5.backend.event;

import com.calculo_folha_pagamento_lab1_grupo5.backend.model.Funcionario;
public class CadastroFuncEvent { // essa classe sera uma classe de evento para implementar uns logs de evento
    private final Funcionario funcionario;


    public CadastroFuncEvent(Funcionario funcionario){
        this.funcionario=funcionario;
    }


    public Funcionario getFuncionario() {
        return funcionario;
    }

    
}
