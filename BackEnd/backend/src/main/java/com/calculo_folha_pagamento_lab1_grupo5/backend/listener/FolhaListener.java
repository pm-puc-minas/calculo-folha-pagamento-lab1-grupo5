package com.calculo_folha_pagamento_lab1_grupo5.backend.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.calculo_folha_pagamento_lab1_grupo5.backend.event.FolhaPagEvent;

@Component
public class FolhaListener {

    @EventListener
    public void dispararAviso(FolhaPagEvent aviso){
        System.out.println("Folha gerada para o funcionário: " 
            + aviso.getFolha().getFuncionario().getNome());
    }
    
}
