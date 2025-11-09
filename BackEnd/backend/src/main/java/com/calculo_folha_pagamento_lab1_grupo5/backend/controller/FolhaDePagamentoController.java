package com.calculo_folha_pagamento_lab1_grupo5.backend.controller;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.calculo_folha_pagamento_lab1_grupo5.backend.DTO.FolhaPagDTO;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.FolhaPagamento;
import com.calculo_folha_pagamento_lab1_grupo5.backend.repository.FolhaPagRepository;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.FolhaPagService;

@RestController
@RequestMapping("/folha-pagamento")
@CrossOrigin(origins = "*")
public class FolhaDePagamentoController {
    
    private final FolhaPagService folhaService;
    private final FolhaPagRepository folhaRepository;

    public FolhaDePagamentoController(FolhaPagService folhaService, FolhaPagRepository folhaRepository) {
        this.folhaService = folhaService;
        this.folhaRepository = folhaRepository;
    }

    @PostMapping("/gerar/{idFuncionario}")
    public ResponseEntity<FolhaPagamento> gerarFolha(@PathVariable Long idFuncionario) {
        try {
            FolhaPagamento folha = folhaService.gerarFolhaPagamentoPorFuncionario(idFuncionario);
            return ResponseEntity.ok(folha);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/gerar-todos")
    public ResponseEntity<List<FolhaPagamento>> gerarFolhaTodos() {
        List<FolhaPagamento> folhas = folhaService.gerarFolhaTodos();
        return ResponseEntity.ok(folhas);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<FolhaPagamento>> listarFolhas() {
        List<FolhaPagamento> folhas = folhaService.getAllFolhas();
        if (folhas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(folhas);
    }

    @GetMapping("/funcionario/{idFuncionario}")
    public ResponseEntity<FolhaPagamento> buscarFuncionario(@PathVariable Long idFuncionario) {
        Optional<FolhaPagamento> folha = folhaService.buscarFuncionarioPorId(idFuncionario);
        return folha.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/funcionario/{idFuncionario}")
    public ResponseEntity<String> removerFolha(@PathVariable Long idFuncionario) {
        boolean removido = folhaService.removerFolhaFuncionario(idFuncionario);
        if (removido) {
            return ResponseEntity.ok("Folha de pagamento removida.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public List<FolhaPagDTO> listarDados(){
        return folhaRepository.findAll()
            .stream()
            .map(f-> new FolhaPagDTO(f.getFuncionario().getNome(), f.getGeracaoData(), f.getSalarioLiquido()))
            .collect(Collectors.toList());
    }

    @GetMapping("/media")
    public ResponseEntity<Double> mediaSalarioLiquidos(){
        Double media= folhaService.FolhaGeradaGeral();
        return ResponseEntity.ok(media);
    }

}


