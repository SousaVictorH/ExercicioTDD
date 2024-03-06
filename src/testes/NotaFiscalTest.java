package testes;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import notas.Nota;

import faturas.Fatura;

public class NotaFiscalTest {


    @Test
    void testCriaNotaFiscal() {
        Fatura fatura = new Fatura("Nome","Endereco", "CONSULTORIA",2.0);
        Nota nota = new Nota(fatura);

        assertEquals("Nome", nota.getNomeCliente());
        assertEquals(2.0, nota.getValorNota());
        assertEquals(0.25, nota.getValorImposto());

    }
}
