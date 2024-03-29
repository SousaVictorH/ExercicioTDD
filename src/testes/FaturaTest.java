package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import faturas.Fatura;

public class FaturaTest {

    @Test
    void testCriaFatura() {
        Fatura fatura = new Fatura("Nome", "Endereco", "TipoServico", 3.0);

        assertEquals("Nome", fatura.getNome());
        assertEquals("Endereco", fatura.getEndereco());
        assertEquals("TipoServico", fatura.getServico());
        assertEquals(3, fatura.getValor());
    }

}
