package com.calculo_folha_pagamento_lab1_grupo5.backend;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.FolhaPagamento;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.Funcionario;
import com.calculo_folha_pagamento_lab1_grupo5.backend.repository.FolhaPagRepository;
import com.calculo_folha_pagamento_lab1_grupo5.backend.repository.FuncionarioRepository;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.FolhaPagService;

@ExtendWith(MockitoExtension.class)
public class TesteFolhaPagService {

    @Mock
    private FuncionarioRepository funcionarioRepository;

    @Mock
    private FolhaPagRepository folhaRepository;

    @InjectMocks
    private FolhaPagService folhaPagService;

    @Test
    public void testGerarFolhaPagamentoPorFuncionario() {
        Funcionario func = new Funcionario();
        func.setIdFuncionario(1L);
        func.setNome("João");
        when(funcionarioRepository.findById(1L)).thenReturn(Optional.of(func));
        when(folhaRepository.save(any(FolhaPagamento.class))).thenReturn(new FolhaPagamento());

        FolhaPagamento result = folhaPagService.gerarFolhaPagamentoPorFuncionario(1L);
        assertNotNull(result);
    }

    @Test
    public void testFolhaGeradaGeral() {
        List<FolhaPagamento> folhas = Arrays.asList(
            createFolha(1000.0), createFolha(2000.0)
        );
        when(folhaRepository.findAll()).thenReturn(folhas);

        Double media = folhaPagService.FolhaGeradaGeral();
        assertEquals(1500.0, media);
    }

    private FolhaPagamento createFolha(double salario) {
        FolhaPagamento f = new FolhaPagamento();
        f.setSalarioLiquido(salario);
        return f;
    }
}