# Casos de Teste Atualizado
## TesteCalculoFGTS
- Calcular se o valor do FGTS vai retornar 8% do valor do salário bruto definido para o funcionário.
- Calcular se o valor do salário for 0 retorna 0.

## TesteCalculoINSS
- Calcular se o valor do INSS vai retornar corretamente com base no cálculo progressivo para cada faixa salarial da tabela.
- Calcular se o valor do INSS vai retornar corretamente caso o salário seja igual ao teto (deve parar no limite).
- Calcular se o valor do INSS vai retornar corretamente caso o salário seja maior que o teto (deve considerar até o teto).

## TesteCalculoIRRF
- Calcular se o valor do IRRF vai retornar corretamente com base no salário bruto definido para o funcionário com nenhum dependente.
- Calcular se o valor do IRRF vai retornar corretamente com base no salário bruto definido para o funcionário com 2 dependentes.
- Calcular se o valor do IRRF vai retornar 0 caso o salário bruto definido para o funcionário for 0. (Verificar de retorna valor negativo)

## TesteCalculoSalarioBase
- Calcular se o valor do salário base retorna corretamente com base no salário bruto definido para o funcionário. (depende se o cálculo do INSS estiver correto)

## TesteCalculoSalarioBrutoTotal
- Calcular se o valor do salário bruto total for 0 caso o salário bruto definido para o funcionário for 0 mesmo se houver insalubridade considerada.
- Calcular se o valor do salário bruto total vai retornar corretamente com base no salário bruto definido para o funcionário com periculosidade inclusa.
- Calcular se o valor do salário bruto total vai retornar corretamente com base no salário bruto definido para o funcionário com insalubridade inclusa.

## TesteCalculoSalarioLiquido
- Calcular se o valor do salário líquido vai retornar corretamente com base no salário bruto definido para o funcionário sem nenhum tipo de adicionais e descontos (exceto os obrigatórios: INSS E IRRF).
- Calcular se o valor do salário líquido vai retornar corretamente com base no salário bruto definido para o funcionário com adicionais e descontos.

## TesteInsalubridade
- Calcular se o valor da insalubridade vai retornar 0 caso o nível seja NENHUM.
- Calcular se o valor da insalubridade vai retorar 40% do valor do salário bruto definido para o funcionário caso o nível seja MAXIMA.
- Calcular se o valor da insalubridade vai retorar 20% do valor do salário bruto definido para o funcionário caso o nível seja MEDIA.
- Calcular se o valor da insalubridade vai retorar 10% do valor do salário bruto definido para o funcionário caso o nível seja MINIMA.

## TestePericulosidade
- Calcular se o valor da periculosidade vai retornar 0 caso não tenha periculosidade.
- Calcular se o valor da periculosidade vai retornar 30% do valor do salário bruto definido para o funcionário caso tenha periculosidade.

## TesteValeAlimentacao
- Calcular se o valor do vale alimentação vai retornar 0 caso o funcionário não receba vale alimentação
- Calcular se o valor do vale alimentação vai retorar correto com base nos dias trabalhados e o custo diário de alimentação do funcionário que recebe vale alimentação.

## TesteValeTransporte
- Calcular se o valor do desconto vai retornar 0 caso o funcionário não receba vale transporte
- Calcular se o valor do desconto vai retornar o valor do vale transporte (caso seja menor que 6% do valor do salário bruto total) ou vai retornar 6% do valor do salário bruto total (caso seja menor que o valor do vale transporte) caso o funcionário receba vale transporte 

