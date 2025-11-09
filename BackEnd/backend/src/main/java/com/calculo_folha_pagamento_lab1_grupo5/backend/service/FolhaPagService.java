package com.calculo_folha_pagamento_lab1_grupo5.backend.service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.calculo_folha_pagamento_lab1_grupo5.backend.event.FolhaPagEvent;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.*;
import com.calculo_folha_pagamento_lab1_grupo5.backend.repository.FuncionarioRepository;
import com.calculo_folha_pagamento_lab1_grupo5.backend.repository.FolhaPagRepository;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoAdicionaisService.calcularInsalubridade;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoAdicionaisService.calcularPericulosidade;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoDescontosService.calculoINSS;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoDescontosService.calculoIRRF;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoDescontosService.calculoValeAlimentacao;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoDescontosService.calculoValeTransporte;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoDescontosService.calculoFGTS;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoSalarioService.calcularSalarioBase;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoSalarioService.calculoSalarioHora;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoSalarioService.calcularSalarioLiquido;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoSalarioService.salarioBrutoTotal;

@Service
public class FolhaPagService {

    private final calcularInsalubridade insalubridade;
    private final calcularPericulosidade periculosidade;
    private final calculoFGTS fgts;
    private final calculoSalarioHora salarioHora;
    private final salarioBrutoTotal salarioBruto;
    private final calcularSalarioBase salarioBase;
    private final calcularSalarioLiquido salarioLiquido;
    private final calculoINSS inss;
    private final calculoIRRF irrf;
    private final calculoValeAlimentacao VA;
    private final calculoValeTransporte VT;
    private final FuncionarioRepository funcionarioRepo;
    private final FolhaPagRepository folhaRepo;
    private final ApplicationEventPublisher aviso;

    public FolhaPagService(
        calcularInsalubridade insalubridade,
        calcularPericulosidade periculosidade,
        calculoFGTS fgts,
        calculoSalarioHora salarioHora,
        salarioBrutoTotal salarioBruto,
        calcularSalarioLiquido salarioLiquido,
        calcularSalarioBase salarioBase,
        calculoINSS inss,
        calculoIRRF irrf,
        calculoValeAlimentacao VA,
        calculoValeTransporte VT,
        FuncionarioRepository funcionarioRepo,
        FolhaPagRepository folhaRepository,
        ApplicationEventPublisher aviso
    ) {
        this.insalubridade = insalubridade;
        this.periculosidade = periculosidade;
        this.fgts = fgts;
        this.salarioHora = salarioHora;
        this.salarioBruto = salarioBruto;
        this.salarioLiquido = salarioLiquido;
        this.salarioBase = salarioBase;
        this.inss = inss;
        this.irrf = irrf;
        this.VA = VA;
        this.VT = VT;
        this.funcionarioRepo = funcionarioRepo;
        this.folhaRepo = folhaRepository;
        this.aviso=aviso;
    }

    @Transactional
    public FolhaPagamento gerarFolhaPagamentoPorFuncionario(Long idFuncionario) {
        Funcionario f = funcionarioRepo.findById(idFuncionario).orElseThrow(() -> new RuntimeException("Funcionário não encontrado com ID: " + idFuncionario));
        FolhaPagamento folha = new FolhaPagamento(f);
        folha.setSalarioBruto(salarioBruto.calcularSalarioBrutoTotal(f));
        folha.setInsalubridade(insalubridade.calcularAdicionais(f));
        folha.setPericulosidade(periculosidade.calcularAdicionais(f));
        folha.setFgts(fgts.calcularAdicionais(f));
        folha.setValorHora(salarioHora.calcularAdicionais(f));
        folha.setInss(inss.calcularDescontos(f));
        folha.setIrrf(irrf.calcularDescontos(f));
        folha.setVA(VA.calcularDescontos(f));    
        folha.setVT(VT.calcularDescontos(f));
        folha.setSalarioLiquido(salarioLiquido.calcularLiquido(f));
        folha.setSalarioBase(salarioBase.calcularSalarioBase(f));
        FolhaPagamento FolhaGerada= folhaRepo.save(folha);
        aviso.publishEvent(new FolhaPagEvent(FolhaGerada));
        return FolhaGerada;
    }

    @Transactional
    public List<FolhaPagamento> gerarFolhaTodos() {
        List<Funcionario> funcionarios = funcionarioRepo.findAll();

        List<FolhaPagamento> folhas = funcionarios.stream()
            .map(f -> gerarFolhaPagamentoPorFuncionario(f.getIdFuncionario()))
            .collect(Collectors.toList());
        return folhaRepo.saveAll(folhas);
    }

    public List<FolhaPagamento> getAllFolhas() {
        return folhaRepo.findAll();
    }

    public Optional<FolhaPagamento> buscarFuncionarioPorId(Long idFuncionario) {
        return funcionarioRepo.findById(idFuncionario)
                .flatMap(folhaRepo::findByFuncionario);
    }

    @Transactional
    public boolean removerFolhaFuncionario(Long idFuncionario) {
        Optional<FolhaPagamento> folhaOpt = buscarFuncionarioPorId(idFuncionario);
        if (folhaOpt.isPresent()) {
            folhaRepo.delete(folhaOpt.get());
            return true;
        }
        return false;
    }

    public Double FolhaGeradaGeral(){
        List<FolhaPagamento> folhas= folhaRepo.findAll();
        return folhas.stream().mapToDouble(FolhaPagamento::getSalarioLiquido).average().orElse(0.0);
    }
}   






