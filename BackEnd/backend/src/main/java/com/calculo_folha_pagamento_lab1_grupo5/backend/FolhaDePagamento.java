package com.calculo_folha_pagamento_lab1_grupo5.backend;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.Funcionario;
import com.calculo_folha_pagamento_lab1_grupo5.backend.model.EGrauInsalubridade;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoDescontosService.calculoFGTS;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoSalarioService.calcularSalarioBase;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoSalarioService.calculoSalarioHora;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoSalarioService.calcularSalarioLiquido;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoSalarioService.salarioBrutoTotal;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoAdicionaisService.calcularInsalubridade;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoAdicionaisService.calcularPericulosidade;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoDescontosService.calculoINSS;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoDescontosService.calculoIRRF;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoDescontosService.calculoValeAlimentacao;
import com.calculo_folha_pagamento_lab1_grupo5.backend.service.calculoDescontosService.calculoValeTransporte;

import java.time.LocalDate;

public class FolhaDePagamento {

    public static void main(String[] args) {
        System.out.println("Folha de Pagamento - Exemplo funcional");
        Funcionario f = new Funcionario();
		salarioBrutoTotal salarioBruto = new salarioBrutoTotal();
		calcularInsalubridade insalubridade= new calcularInsalubridade();
		calcularPericulosidade periculosidade = new calcularPericulosidade();
		calculoINSS inss= new calculoINSS(salarioBruto);
		calcularSalarioBase SalarioBase= new calcularSalarioBase(salarioBruto, inss);
		calculoIRRF irrf= new calculoIRRF(SalarioBase);
		calculoValeAlimentacao valeAlimentacao= new calculoValeAlimentacao();
		calculoValeTransporte valeTransporte= new calculoValeTransporte(salarioBruto);
		calculoFGTS fgts= new calculoFGTS(salarioBruto);
		calculoSalarioHora salarioHora= new calculoSalarioHora(salarioBruto);
		calcularSalarioLiquido salarioLiquido= new calcularSalarioLiquido(salarioBruto, inss, irrf, valeTransporte);
		f.setNome("Pedro Silva");
		f.setCargo("Professor");
		f.setSalarioBruto(3000.0);
		f.setCargaHorariaDiaria(8.0);
		f.setHorasTrabalhadas(160);
		f.setDiasTrabalhadasSemana(5);
		f.setDiasTrabalhados(22);
		f.setDataAdmissao(LocalDate.of(2025, 1, 10));
		f.setReceberValeTransporte(true);
		f.setReceberValeAlimentacao(true);
		f.setCustoValeTransporte(400.0);
		f.setCustoDiarioAlimentacao(25.0);
		f.setPericulosidade(false);
		f.setInsalubridade(EGrauInsalubridade.NENHUM);
		f.setDependentes(2);

		System.out.println("*** FOLHA DE PAGAMENTO - RETRÔ ***");
		System.out.println("==================================");
		System.out.println("Dados do Funcionário:");
		System.out.printf("- Nome:", f.getNome());
		System.out.printf("- Cargo:", f.getCargo());
		System.out.printf("- Salário Base:", f.getSalarioBruto());
		System.out.printf("- Dependentes:", f.getDependentes());
		System.out.println("----------------------------------");
		// Adicionais
		System.out.println("Adicionais:");
		System.out.printf("- Adicional de Periculosidade:", periculosidade.calcularAdicionais(f));
		System.out.printf("- Adicional de Insalubridade:", insalubridade.calcularAdicionais(f));
		System.out.printf("- FGTS:", fgts.calcularAdicionais(f));
		System.out.printf("- Salário Hora:", salarioHora.calcularAdicionais(f));
		System.out.println("----------------------------------");
		// Descontos
		System.out.println("Descontos:");
		System.out.printf("- Desconto INSS:", inss.calcularDescontos(f));
		System.out.printf("- Desconto IRRF:", irrf.calcularDescontos(f));
		System.out.printf("- Vale Alimentação:", valeAlimentacao.calcularDescontos(f));
		System.out.printf("- Vale Transporte:", valeTransporte.calcularDescontos(f));
		System.out.println("----------------------------------");
		// Totais
		System.out.println("Totais:");
		System.out.printf("- Salário Bruto:", salarioBruto.calcularSalarioBrutoTotal(f));
		System.out.printf("- Salário Líquido:", salarioLiquido.calcularLiquido(f));
		System.out.println("==================================");
		System.out.println("Fim do Relatório");



    }
}
