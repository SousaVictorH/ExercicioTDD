package unitTests5;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import static org.junit.jupiter.api.Assertions.*;
import notas.ControllerNotaFiscal;
import faturas.Fatura;
import notas.Nota;

import javax.management.ConstructorParameters;


class ControllerNotaFiscalTest {


    private ControllerNotaFiscal controller;

    @BeforeEach
    void criaControllerNotaFiscal() {
        controller = new ControllerNotaFiscal();
    }

    @Tag("fast")
    @Test
    void testCalculoImpostoConsultoria1000() {
        Fatura fatura = new Fatura("Cliente A", "Endereço A", "CONSULTORIA", 1000.0);
        Nota nota = controller.criaNotaFiscal(fatura);
        assertEquals(250, nota.getValorImposto());
    }



    @ParameterizedTest
    @ValueSource(strings = {"CONSULTORIA","TREINAMENTO","OUTROS"})
    void testCalculoImposto(String tipoServico) {
        Fatura fatura = new Fatura("Cliente B", "Endereço B", tipoServico, 1000.0);
        Nota nota = controller.criaNotaFiscal(fatura);

        if (tipoServico.equals("CONSULTORIA")){
            assertEquals(250, nota.getValorImposto());
        } else if (tipoServico.equals("TREINAMENTO")){
            assertEquals(150, nota.getValorImposto());
        } else if (tipoServico.equals("OUTROS")){
            assertEquals(60, nota.getValorImposto());
        }

    }

    @ParameterizedTest
    @ValueSource(doubles = {1000.0,120.0,10.0,5000.0})
    void testCalculoImpostoValor(Double valor) {
        Fatura fatura = new Fatura("Cliente C", "Endereço C", "OUTROS", valor);
        Nota nota = controller.criaNotaFiscal(fatura);
        assertEquals(0.06*valor, nota.getValorImposto());
    }


    @Test
    @Order(1)
    void testCalculoImpostoConsultoriaValorLimiteInferior() {
        Fatura fatura = new Fatura("Cliente D", "Endereço D", "CONSULTORIA", 0.01);
        Nota nota = controller.criaNotaFiscal(fatura);
        assertEquals(0.0025, nota.getValorImposto());
    }


    @Test
    @Order(2)
    void testCalculoImpostoTreinamentoValorLimiteSuperior() {
        Fatura fatura = new Fatura("Cliente E", "Endereço E", "TREINAMENTO", 9999.99);
        Nota nota = controller.criaNotaFiscal(fatura);
        assertEquals(1499.9985, nota.getValorImposto(), 0.0001);
    }

    @Tag("fast")
    @Test
    void testCalculoImpostoOutrosValorPequeno() {
        Fatura fatura = new Fatura("Cliente F", "Endereço F", "OUTROS", 1.0);
        Nota nota = controller.criaNotaFiscal(fatura);
        assertEquals(0.06, nota.getValorImposto());
    }

    @ParameterizedTest
    @ValueSource(strings = {"CONSULTORIA","TREINAMENTO","OUTROS"})
    void testCalculoImpostoValoresAltos(String tipoServico) {
        Fatura fatura = new Fatura("Cliente G", "Endereço G", tipoServico, 10000.0);
        Nota nota = controller.criaNotaFiscal(fatura);

        if (tipoServico.equals("CONSULTORIA")){
            assertEquals(2500, nota.getValorImposto());
        } else if (tipoServico.equals("TREINAMENTO")){
            assertEquals(1500, nota.getValorImposto());
        } else if (tipoServico.equals("OUTROS")){
            assertEquals(600, nota.getValorImposto());
        }
    }

    @Tag("fast")
    @Test
    void testCalculoImpostoComValorNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            Fatura fatura = new Fatura("Cliente J", "Endereço J","CONSULTORIA", -100.0);
            controller.criaNotaFiscal(fatura);
        });
    }
}



