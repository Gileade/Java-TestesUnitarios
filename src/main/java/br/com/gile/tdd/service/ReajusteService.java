package br.com.gile.tdd.service;

import br.com.gile.tdd.modelo.Desempenho;
import br.com.gile.tdd.modelo.Funcionario;

import java.math.BigDecimal;

public class ReajusteService {

    public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
        if(desempenho.equals(Desempenho.A_DESEJAR)){
            BigDecimal reajuste = funcionario.getSalario().multiply(new BigDecimal("0.03"));
            funcionario.reajustarSalario(reajuste);
        }else if(desempenho.equals(Desempenho.BOM)){
            BigDecimal reajuste = funcionario.getSalario().multiply(new BigDecimal("0.15"));
            funcionario.reajustarSalario(reajuste);
        }else {
            BigDecimal reajuste = funcionario.getSalario().multiply(new BigDecimal("0.20"));
            funcionario.reajustarSalario(reajuste);
        }

    }
}
