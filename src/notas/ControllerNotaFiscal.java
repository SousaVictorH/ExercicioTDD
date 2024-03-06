package notas;

import utilidade.Utils;
import faturas.Fatura;

import java.util.HashMap;
import java.util.Map;
import bancosDeDados.NotaFiscalDao;


public class ControllerNotaFiscal {
    private Map<String, Nota> mapDeNotas = new HashMap<>();

    public Nota criaNotaFiscal(String nomeCliente, String enderecoCliente, String tipoServico, Double valor){
        Fatura fatura = new Fatura(nomeCliente, enderecoCliente, tipoServico, valor);
        Nota nota = new Nota(fatura);
        salva(nota);
        envia(nota);
        enviaEmail(nota);

        return nota;
    }

    public void salva(Nota nf) {
        System.out.println("salvando no banco");
    }

    public void envia(Nota nf) {
        System.out.println("enviando pro sap");
    }

    public void enviaEmail(Nota nf) {
        System.out.println("enviando por email");
    }



}
