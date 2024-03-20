package functionalTests;

import faturas.Fatura;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class FaturaTest {

    private static final double DELTA = 0.01;



    @Test
    public void testConsultoriaLowValue() {
        assertEquals(125.0, calculateTax("CONSULTORIA", 500), DELTA);
    }

    @Test
    public void testTreinamentoLowValue() {
        assertEquals(75.0, calculateTax("TREINAMENTO", 500), DELTA);
    }

    @Test
    public void testOutrosLowValue() {
        assertEquals(30.0, calculateTax("OUTROS", 500), DELTA);
    }

    @Test
    public void testConsultoriaHighValue() {
        assertEquals(2500.0, calculateTax("CONSULTORIA", 10000), DELTA);
    }

    @Test
    public void testTreinamentoHighValue() {
        assertEquals(1500.0, calculateTax("TREINAMENTO", 10000), DELTA);
    }

    @Test
    public void testOutrosHighValue() {
        assertEquals(600.0, calculateTax("OUTROS", 10000), DELTA);
    }

    @Test
    public void testConsultoriaNegativeValue() {
        calculateTax("CONSULTORIA", -1);
    }

    @Test
    public void testTreinamentoNegativeValue() {
        calculateTax("TREINAMENTO", -100);
    }

    @Test
    public void testOutrosZeroValue() {
        assertEquals(0.0, calculateTax("OUTROS", 0), DELTA);
    }

    @Test
    public void testOutrosMinimalValue() {
        assertEquals(0.06, calculateTax("OUTROS", 1), DELTA);
    }

    private double calculateTax(String serviceType, double invoiceValue) {
        Fatura fatura = new Fatura("Felipe","rua rua rua", serviceType, invoiceValue);
        return fatura.getValor();
    }
}
