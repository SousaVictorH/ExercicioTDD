package unit5Tests;

import faturas.ControllerFaturas;
import faturas.Fatura;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ControllerFaturaTest {
    private ControllerFaturas controllerFaturas;

    @BeforeEach
    void criaControllerFaturas() {
        controllerFaturas = new ControllerFaturas();
    }

    @Test
    @Tag("fast")
    void testCriaFatura() {
        Fatura fatura = controllerFaturas.criaFatura("Nome", "Endereco", "TipoServico", 3.0);
        assertEquals("Nome-Endereco-TipoServico-3.0", fatura.toString());
    }

    @Test
    @Order(1)
    void testCriaFaturaCamposNulos() {
        assertThrows(NullPointerException.class, () -> {
            Fatura fatura = controllerFaturas.criaFatura(null, "Endereco", "TipoServico", 3.0);
        });

        assertThrows(NullPointerException.class, () -> {
            Fatura fatura = controllerFaturas.criaFatura("H", null, "TipoServico", 3.0);
        });

        assertThrows(NullPointerException.class, () -> {
            Fatura fatura = controllerFaturas.criaFatura("B", "Endereco", null, 3.0);
        });

        assertThrows(NullPointerException.class, () -> {
            Fatura fatura = controllerFaturas.criaFatura("J", "Endereco", "TipoServico", null);
        });
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