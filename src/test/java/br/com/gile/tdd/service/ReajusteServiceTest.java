package br.com.gile.tdd.service;

import br.com.gile.tdd.modelo.Desempenho;
import br.com.gile.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    @Test
    public void reajusteDeveriaSerDeTresPorCentoQuandoDesempenhoForADesejar(){
        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("Gile", LocalDate.now(), new BigDecimal("1000").setScale(2, RoundingMode.HALF_UP));
        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);

        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeQuinzePorCentoQuandoDesempenhoForBom(){
        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("Gile", LocalDate.now(), new BigDecimal("1000").setScale(2, RoundingMode.HALF_UP));
        service.concederReajuste(funcionario, Desempenho.BOM);

        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeVintePorCentoQuandoDesempenhoForOtimo(){
        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("Gile", LocalDate.now(), new BigDecimal("1000").setScale(2, RoundingMode.HALF_UP));
        service.concederReajuste(funcionario, Desempenho.OTIMO);

        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}
