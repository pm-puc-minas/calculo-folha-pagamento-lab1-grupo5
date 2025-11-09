package com.calculo_folha_pagamento_lab1_grupo5.backend.controller;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.calculo_folha_pagamento_lab1_grupo5.backend.DTO.FuncDTO;
import com.calculo_folha_pagamento_lab1_grupo5.backend.event.CadastroFuncEvent;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.Funcionario;
import com.calculo_folha_pagamento_lab1_grupo5.backend.repository.FuncionarioRepository;

@RestController
@RequestMapping("/funcionarios")
@CrossOrigin(origins = "*")

public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionario;
    @Autowired
    private ApplicationEventPublisher aviso;

    @PostMapping
    public Funcionario cadastrarFuncionario(@RequestBody Funcionario f){
        Funcionario salvo= funcionario.save(f);
        aviso.publishEvent(new CadastroFuncEvent(salvo));
        return salvo;
    }

    @GetMapping("/listarFuncionarios")
    public List<Funcionario> listarFuncionarios(){
        return funcionario.findAll();
    }

    @GetMapping("/mostrarDadosFuncionario")
    public List<FuncDTO> listarDados(){
        return funcionario.findAll()
            .stream()
            .map(f-> new FuncDTO(f.getIdFuncionario(), f.getNome(), f.getCargo(), f.getDataAdmissao()))
            .collect(Collectors.toList());
    }
}
