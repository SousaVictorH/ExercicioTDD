package testes;

import notas.ControllerNotaFiscal;
import notas.Nota;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import faturas.ControllerFaturas;
import faturas.Fatura;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControllerNotaFiscalTest {

    private ControllerNotaFiscal controllerNotaFiscal;
    private ControllerFaturas controllerFaturas;

    @BeforeEach
    void criaControllerNotaFiscal() {

        controllerNotaFiscal = new ControllerNotaFiscal();
        controllerFaturas = new ControllerFaturas();
    }

    @Test
    void testCriaNotaFiscal() {
        Fatura fatura = controllerFaturas.criaFatura("Nome", "Endereco", "TipoServico", 3.0);
        Nota nota = controllerNotaFiscal.criaNotaFiscal("Nome", "Endereco", "TipoServico", 3.0);
        assertEquals("Nome-3.0", nota.toString());
    }

    @Test
    void testAddFatura() {
        Fatura fatura = controllerFaturas.criaFatura("Nome", "Endereco", "TipoServico", 3.0);

        assertEquals(fatura.getId(), controllerFaturas.addFaturaToMap(fatura));
    }

    @Test
    void testGetFatura() {
        Fatura fatura = controllerFaturas.criaFatura("Nome", "Endereco", "TipoServico", 3.0);
        controllerFaturas.addFaturaToMap(fatura);

        assertEquals(fatura.getId(), controllerFaturas.getFatura(fatura.getId()));
    }
}
