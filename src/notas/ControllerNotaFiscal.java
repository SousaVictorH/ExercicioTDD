package notas;

import utilidade.Utils;
import faturas.Fatura;

import java.util.HashMap;
import java.util.Map;
import bancosDeDados.NotaFiscalDao;


public class ControllerNotaFiscal {
    private Map<String, Nota> mapDeNotas = new HashMap<>();


    public Nota criaNotaFiscal(Fatura fatura){
        Utils.validaString(fatura.getNome(), "Campo nome nao pode ser nulo ou vazio.");
        Utils.validaString(fatura.getId(), "Campo id nao pode ser nulo ou vazio.");
        Utils.validaString(fatura.getServico(), "Campo tipoServico nao pode ser nulo ou vazio.");
        Utils.validaDoublePositivo(fatura.getValor(), "Campo prioridade nao pode ser nulo ou vazio.");

        Nota nota = new Nota(fatura);
        salva(nota);
        envia(nota);
        enviaEmail(nota);

        mapDeNotas.put(nota.getId(), nota);

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
