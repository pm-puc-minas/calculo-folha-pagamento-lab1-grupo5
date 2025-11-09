package com.calculo_folha_pagamento_lab1_grupo5.backend.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.calculo_folha_pagamento_lab1_grupo5.backend.DTO.FolhaPagDTO;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.FolhaPagamento;
import com.calculo_folha_pagamento_lab1_grupo5.backend.repository.FolhaPagRepository;
import java.io.File;

@RestController
@RequestMapping("/FolhaPagJson")
public class FolhaPagJsonController {

    private static final String CAMINHO = "folha_pagamento.json";
    private final FolhaPagRepository folhaRepository;

    public FolhaPagJsonController(FolhaPagRepository folhaRepository) {
        this.folhaRepository = folhaRepository;
    }

    @GetMapping("/salvar/{id}")
    public String salvarFolhaPag(@PathVariable Long id) {
        try {
            FolhaPagamento folha = folhaRepository.findById(id).orElse(null);

            if (folha == null) {
                return "Folha de pagamento não encontrada.";
            }
            FolhaPagDTO dto = new FolhaPagDTO();
            dto.setIdFolhaPagamento(folha.getIdFolhaPagamento());
            dto.setDataGeracao(folha.getGeracaoData());
            dto.setSalarioLiquido(folha.getSalarioLiquido());
            ObjectMapper mapper = new ObjectMapper();
            mapper.findAndRegisterModules();
            mapper.writeValue(new File(CAMINHO), dto);
            return "Folha de pagamento salva.";
        } catch (Exception e) {
            return "Erro ao salvar: " + e.getMessage();
        }
    }

    @GetMapping("/carregar")
    public FolhaPagDTO carregarFolhaPag() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.findAndRegisterModules();
            return mapper.readValue(new File(CAMINHO), FolhaPagDTO.class);
        } catch (Exception e) {
            return null;
        }
    }
}

