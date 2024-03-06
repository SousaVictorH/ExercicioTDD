package testes;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import faturas.ControllerFaturas;
import faturas.Fatura;


public class ControllerFaturaTest {
    private ControllerFaturas controllerFaturas;

    @BeforeEach
    void criaControllerFaturas() {
        controllerFaturas = new ControllerFaturas();
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

