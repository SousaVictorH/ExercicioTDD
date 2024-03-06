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
        controllerFaturas.criaFatura("Nome", "Endereco", "TipoServico", 3.0);
        
    }
}

