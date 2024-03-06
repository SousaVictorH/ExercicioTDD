package testes;

import notas.ControllerNotaFiscal;
import notas.Nota;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControllerNotaFiscalTest {

    private ControllerNotaFiscal controllerNotaFiscal;

    @BeforeEach
    void criaControllerNotaFiscal() {
        controllerNotaFiscal = new ControllerNotaFiscal();
    }

    @Test
    void testCriaFatura() {
        Fatura fatura = controllerFaturas.criaFatura("Nome", "Endereco", "TipoServico", 3.0);
        assertEquals("Nome-Endereco-TipoServico-3.0", fatura.toString());
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
