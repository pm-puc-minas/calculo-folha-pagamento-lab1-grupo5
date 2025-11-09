package com.calculo_folha_pagamento_lab1_grupo5.backend.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.calculo_folha_pagamento_lab1_grupo5.backend.DTO.FuncDTO;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.Funcionario;
import com.calculo_folha_pagamento_lab1_grupo5.backend.repository.FuncionarioRepository;
import java.io.File;

@RestController
@RequestMapping("/funcJson")
public class FuncJsonController { 

    private static final String CAMINHO = "funcionario.json";
    private final FuncionarioRepository funcRepor;

    public FuncJsonController(FuncionarioRepository funcRepor) {
        this.funcRepor = funcRepor;
    }

    @GetMapping("/salvar/{id}")
    public String salvarFuncionario(@PathVariable Long id) {
        try {
            Funcionario funcionario = funcRepor.findById(id).orElse(null);

            if (funcionario == null) {
                return "Funcionário não encontrado.";
            }
            
            FuncDTO dto = new FuncDTO();
            dto.setIdFuncionario(funcionario.getIdFuncionario());
            dto.setNome(funcionario.getNome());
            dto.setCargo(funcionario.getCargo());
            dto.setDataAdmissao(funcionario.getDataAdmissao());

            ObjectMapper mapper = new ObjectMapper();
            mapper.findAndRegisterModules(); // 
            mapper.writeValue(new File(CAMINHO), dto);

            return "Funcionário salvo com sucesso!";
        } catch (Exception e) {
            return "Erro ao salvar: " + e.getMessage();
        }
    }
    
    @GetMapping("/carregar")
    public FuncDTO carregarFuncionario() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.findAndRegisterModules(); 
            return mapper.readValue(new File(CAMINHO), FuncDTO.class);
        } catch (Exception e) {
            return null;
        }
    }
}

