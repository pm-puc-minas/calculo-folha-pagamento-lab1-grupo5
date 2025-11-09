package com.calculo_folha_pagamento_lab1_grupo5.backend;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import com.calculo_folha_pagamento_lab1_grupo5.backend.event.CadastroFuncEvent;
import com.calculo_folha_pagamento_lab1_grupo5.backend.listener.FuncionarioListener;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.Funcionario;

@ExtendWith(MockitoExtension.class)
public class TesteFuncionarioListener {

    @InjectMocks
    private FuncionarioListener listener;

    @Test
    public void testAvisoFuncionarioCadastrado() {
        Funcionario func = new Funcionario();
        func.setNome("João");
        CadastroFuncEvent event = new CadastroFuncEvent(func);

        listener.avisoFuncionarioCadastrado(event);
    }
}