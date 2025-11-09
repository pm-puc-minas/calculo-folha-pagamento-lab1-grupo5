package com.calculo_folha_pagamento_lab1_grupo5.backend.listener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import com.calculo_folha_pagamento_lab1_grupo5.backend.event.CadastroFuncEvent;

@Component
public class FuncionarioListener {
    @EventListener
    public void avisoFuncionarioCadastrado(CadastroFuncEvent aviso){
        System.out.println("Funcionário Cadastrado: " +aviso.getFuncionario().getNome());
    } 
}
