package br.com.gile.tdd.service;

import br.com.gile.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class BonusServiceTest {

    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoalto(){
        BonusService service = new BonusService();
        
        assertThrows(IllegalArgumentException.class,
                () -> service.calcularBonus(new Funcionario("Gile", LocalDate.now(), new BigDecimal("25000"))));
        /**
         * Pra checar a mensagem da exception, pode ser usado o módo abaixo
         */
        try {
            service.calcularBonus(new Funcionario("Gile", LocalDate.now(), new BigDecimal("25000")));
            fail("Não deu a exception!");
        }catch (Exception e){
            assertEquals("Funcionário com salário maior que R$ 10.000, não pode receber o bônus.", e.getMessage());
        }
    }

    @Test
    void bonusDeveriaSer10PorCentoDoSalario(){
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Gile", LocalDate.now(), new BigDecimal("2500")));

        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    void bonusDeveriaSer10PorCentoParaSalarioExatamenteDe10000(){
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Gile", LocalDate.now(), new BigDecimal("10000")));

        assertEquals(new BigDecimal("1000.00"), bonus);
    }


}
