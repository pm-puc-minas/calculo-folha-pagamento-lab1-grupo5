package com.calculo_folha_pagamento_lab1_grupo5.backend.service;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.Funcionario;

@Service
public class GestaoService {

    private ArrayList<Funcionario> funcionarios = new ArrayList<>();
    public void adicionar_funcionario(Funcionario x){
        funcionarios.add(x);
    }

    public String gerar_folha_pagamento(Funcionario x){return "Folha Pagamento"; }
}
