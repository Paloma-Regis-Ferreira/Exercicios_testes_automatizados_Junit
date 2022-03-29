package br.com.alura.tdd.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.alura.tdd.modelo.Funcionario;

public class BonusService {

	public BigDecimal calcularBonus(Funcionario funcionario) throws IllegalAccessException {
		BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));

		if (valor.compareTo(new BigDecimal("1000")) > 0) {
				throw new IllegalAccessException("Funcionário cujo bonus ultrapasse R$1000,00 não recebem bonus");

		}

		return valor.setScale(2, RoundingMode.HALF_UP);
	}

}
