package testes;

import faturas.Fatura;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import notas.Nota;

public class NotaFiscalTest {
    private String nomeCliente;
    private Double valorNota;
    private Double valorImposto;

    @Test
    void testCriaNotaFiscal() {
        Nota nota = new Nota("Nome", 10.0, "idFatura");


    }
}
