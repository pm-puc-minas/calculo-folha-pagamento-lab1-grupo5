# Relatório Sprint 3 - Projeto de Cálculo de Folha de Pagamento

## Descrição Geral
Nesta sprint, avançei na implementação da aplicação de cálculo de folha de pagamento, ampliando funcionalidades, organizando melhor a arquitetura do código e garantindo boas práticas como tratamento de exceções, DTOs, persistência e salvamento/carregamento de dados em arquivo JSOn. O projeto utiliza Java com Spring Boot, PostgreSQL e testes unitários, focando em cálculos precisos de salários, benefícios e descontos trabalhistas brasileiros.

---

## Funcionalidades e Implementações Realizadas

### ✅ Coleções e Processamento de Dados
- Utilização de **List** como coleção principal para manipulação de dados de funcionários e folhas de pagamento.
- Uso de **Streams** para filtragem, mapeamento e cálculos em serviços como `FolhaPagService` e `FuncionarioController`.

### ✅ Endpoints
- Criação dos **endpoints REST** necessários para o funcionamento do sistema, incluindo cadastro de funcionários, geração de folhas e listagem de dados.
- Testes realizados através do **Postman**, validando requisições POST, GET e tratamento de erros (ex.: 400, 405, 500).

### ✅ Tratamento de Exceções
- Implementação de tratamento customizado de erros, com classes que **estendem `RuntimeException`** para validações (ex.: email duplicado em admin).
- Evita uso obrigatório de try/catch nos pontos de chamada, melhorando a legibilidade do código.

### ✅ Cálculos Implementados
- Cálculo da **média de salário líquido** via `FolhaPagService.FolhaGeradaGeral()`.
- Cálculo de **VT (Vale Transporte)** e **VA (Vale Alimentação)**, integrados aos salários.
- Outros métodos relacionados à folha de pagamento, incluindo INSS, IRRF, FGTS, insalubridade, periculosidade e arredondamentos.

### ✅ Persistência de Dados
- Utilização do **PostgreSQL**.
- Implementação de repositórios utilizando **Spring Data JPA**, com entidades como `Funcionario`, `FolhaPagamento` e `Admin`.

### ✅ DTOs (Data Transfer Objects)
- Implementação de **DTOs** para proteger campos sensíveis e melhorar a transferência de dados entre camadas, como `FuncDTO` e `FolhaPagDTO`.

### ✅ Preparação da Arquitetura para Futura Integração com o Frontend
- Implementação de APIs REST com `@RestController`, `@CrossOrigin` e DTOs otimizados para facilitar a integração com interfaces web ou mobile no futuro.

## ✅ Salvamento e Carregamento de Dados em Arquivo JSON
- Implementação no FolhaPagJsonController para salvar e carregar dados de folha de pagamento em formato JSON.
- Como foi feito no código:
  - **Salvamento**: Método que busca a folha de pagamento pelo ID no repositório (folhaPagRepository.findById(id)), converte o objeto FolhaPagamento em JSON usando ObjectMapper (do Jackson), e escreve em um arquivo local (ex.: folha_pagamento.json) com Files.write(). Retorna mensagem de sucesso ou erro se o ID não existir.
  - **Carregamento**: Método que lê o arquivo JSON (Files.readString()), converte de volta para um objeto FolhaPagDTO usando ObjectMapper, e retorna os dados. Trata exceções como arquivo não encontrado ou formato inválido.

### ✅ Logs de Evento
- Implementação de logs com:
  - **Listener** (ex.: `FuncionarioListener`, `FolhaListener`)
  - **Event** (ex.: `CadastroFuncEvent`, `FolhaPagEvent`)

### ✅ Correções de Escrita
- I Maiúsculo em ICalculoDescontos e ICalculoAdicionais

---

## Conclusão
O projeto atende a todos os requisitos do professor, incluindo coleções, streams, persistência, eventos, arquitetura para frontend e testes unitários. Todos os testes passaram, e os endpoints foram validados no Postman.

## **PENDENTE PARA A ENTREGA FINAL**
- Arredondamento dos valores calculados
