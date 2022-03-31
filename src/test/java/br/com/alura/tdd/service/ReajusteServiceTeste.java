package br.com.alura.tdd.service;

import br.com.alura.tdd.enums.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTeste {

    private ReajusteService service;
    private Funcionario funcionario;

    @BeforeEach//chamado antes de cada teste
    public void inicializarAtributos(){
        System.out.println("começo");
        this.service = new ReajusteService();
        this.funcionario = new Funcionario("Paloma", LocalDate.now(), new BigDecimal("1000.00"));
    }

    @AfterEach//chamado depois de cada teste
    public void finalizar(){
        System.out.println("fim");
    }

    @BeforeAll
    public static void antesDeTudo(){//tem q ser statico
        System.out.println("começo de tudo");
    }

    @AfterAll
    public static void depoisDeTudo(){//tem q ser statico
        System.out.println("fim de tudo");
    }

    @Test
    public void ReajusteDeveriaSerDe3PorCentoQuandoDesempenhoForADesejar(){
        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void ReajusteDeveriaSerDe15PorCentoQuandoDesempenhoForBom(){
        service.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void ReajusteDeveriaSerDe20PorCentoQuandoDesempenhoForOtimo(){
        service.concederReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }

}
