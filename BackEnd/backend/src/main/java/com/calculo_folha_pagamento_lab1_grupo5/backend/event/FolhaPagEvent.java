package com.calculo_folha_pagamento_lab1_grupo5.backend.event;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.FolhaPagamento;

public class FolhaPagEvent {

    private final FolhaPagamento folha;

    public FolhaPagEvent(FolhaPagamento folha) {
        this.folha = folha;
    }

    public FolhaPagamento getFolha() {
        return folha;
    }

}
