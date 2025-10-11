## Aplicação de Conceitos de Reuso e Organização de Software no Projeto de Cálculo de Folha de Pagamento
Os conceitos de herança, polimorfismo, interfaces e classes abstratas são aplicados para promover o reuso de código e a organização de software. Isso segue princípios como o SOLID e facilita a extensão futura, como adicionar novos tipos de descontos ou usuários.
## 1. Herança e Polimorfismo
** Herança **
Permite que classes herdem atributos e métodos de uma superclasse, reutilizando código comum e criando uma hierarquia lógica, assim organizando o software em níveis, reduzindo duplicação e facilitando manutenção.
** Polimorfismo **
Permite que objetos de diferentes subclasses sejam tratados de forma uniforme, executando comportamentos específicos em tempo de execução, promovendo flexibilidade e reuso.
** Herança em Classes de Usuários: **

A classe abstrata Usuario serve como superclasse para tipos de usuários comuns no sistema, como funcionarios e administradores. Ela define atributos reutilizáveis como nome, email, senha e métodos comuns como getNome() e setEmail().
** Reuso **
A classe Funcionario herda de Usuario, reutilizando os atributos e métodos comuns, mas adiciona específicos como salarioBase, numeroDependentes e grauInsalubridade.
** Polimorfismo em Uso: **

No serviço de gestão, você pode tratar objetos de Funcionario e Admin polimorficamente via referência de Usuario, chamando realizarAcao() — para Funcionario, calcula salário; para Admin, gera relatórios.
## Interfaces e Classes Abstratas
## Interfaces: Definem contratos, forçando classes a implementá-los de forma consistente. Isso organiza o software em módulos independentes, permitindo reuso via composição e facilitando testes e injeção de dependências.
## Classes Abstratas: Combinam herança com implementação parcial, fornecendo um esqueleto reutilizável que subclasses completam. Elas organizam código híbrido, evitando duplicação enquanto impõem estrutura.
## Interfaces para Cálculos Modulares:

ICalculoDescontos define o contrato para descontos, com o método double calcularDescontos(Funcionario f), permitindo que múltiplas classes implementem descontos diferentes, mas sejam usadas uniformemente.
## Reuso e Organização: Classes como calculoINSS, calculoIRRF, calculoValeTransporte e calculoValeAlimentacao implementam a interface, cada uma com lógica específica.
Classes Abstratas para Estrutura Híbrida:

Usuario é uma classe abstrata que fornece implementação parcial. Isso organiza o código: comum em Usuario, específico nas subclasses.
Reuso e Organização: Subclasses herdam e estendem sem reescrever o básico. Impede instâncias diretas de Usuario, garantindo que sempre haja uma implementação concreta.

