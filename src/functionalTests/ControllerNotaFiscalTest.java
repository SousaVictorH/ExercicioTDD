package functionalTests;
import faturas.ControllerFaturas;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params;
import notas.ControllerNotaFiscal;
import faturas.Fatura;
import notas.Nota;



class ControllerNotaFiscalTest {


    private ControllerNotaFiscal controller;

    @BeforeEach
    void criaControllerNotaFiscal() {
        controller = new ControllerNotaFiscal();
    }


    @ParameterizedTest
    void testCalculoImpostoConsultoria1000() {
        Fatura fatura = new Fatura("Cliente A", "Endereço A", "CONSULTORIA", 1000.0);
        Nota nota = controller.criaNotaFiscal("Cliente A", "Endereço A","CONSULTORIA", 1000.0);
        assertEquals(250, nota.getValorImposto());
    }



    @Test
    void testCalculoImpostoTreinamento1000() {
        Fatura fatura = new Fatura("Cliente B", "Endereço B", "TREINAMENTO", 1000.0);
        Nota nota = controller.criaNotaFiscal("Cliente B", "Endereço B", "TREINAMENTO", 1000.0);
        assertEquals(150, nota.getValorImposto());
    }

    @Test
    void testCalculoImpostoOutros1000() {
        Fatura fatura = new Fatura("Cliente C", "Endereço C", "OUTROS", 1000.0);
        Nota nota = controller.criaNotaFiscal("Cliente C", "Endereço C", "OUTROS", 1000.0);
        assertEquals(60, nota.getValorImposto());
    }

    @Test
    void testCalculoImpostoConsultoriaValorLimiteInferior() {
        Fatura fatura = new Fatura("Cliente D", "Endereço D", "CONSULTORIA", 0.01);
        Nota nota = controller.criaNotaFiscal("Cliente D", "Endereço D", "CONSULTORIA", 0.01);
        assertEquals(0.0025, nota.getValorImposto(), 0.0001);
    }

    @Test
    void testCalculoImpostoTreinamentoValorLimiteSuperior() {
        Fatura fatura = new Fatura("Cliente E", "Endereço E", "TREINAMENTO", 9999.99);
        Nota nota = controller.criaNotaFiscal("Cliente E", "Endereço E", "TREINAMENTO", 9999.99);
        assertEquals(1499.9985, nota.getValorImposto(), 0.0001);
    }

    @Test
    void testCalculoImpostoOutrosValorPequeno() {
        Fatura fatura = new Fatura("Cliente F", "Endereço F", "OUTROS", 1.0);
        Nota nota = controller.criaNotaFiscal("Cliente F", "Endereço F", "OUTROS", 1.0);
        assertEquals(0.06, nota.getValorImposto());
    }

    @Test
    void testCalculoImpostoValoresAltos() {
        Fatura faturaConsultoriaAlta = new Fatura("Cliente G", "Endereço G", "CONSULTORIA", 10000.0);
        Nota notaConsultoria = controller.criaNotaFiscal("Cliente G", "Endereço G", "CONSULTORIA", 10000.0);
        assertEquals(2500, notaConsultoria.getValorImposto());

        Fatura faturaTreinamentoAlto = new Fatura("Cliente H", "Endereço H", "TREINAMENTO", 10000.0);
        Nota notaTreinamento = controller.criaNotaFiscal("Cliente H", "Endereço H", "TREINAMENTO", 10000.0);
        assertEquals(1500, notaTreinamento.getValorImposto());

        Fatura faturaOutrosAlto = new Fatura("Cliente I", "Endereço I", "OUTROS", 10000.0);
        Nota notaOutros = controller.criaNotaFiscal("Cliente I", "Endereço I", "OUTROS", 10000.0);
        assertEquals(600, notaOutros.getValorImposto());
    }

    @Test
    void testCalculoImpostoComValorNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            Fatura fatura = new Fatura("Cliente J", "Endereço J","CONSULTORIA", -100.0);
            controller.criaNotaFiscal("Cliente J", "Endereço J","CONSULTORIA", -100.0);
        });
    }
}


