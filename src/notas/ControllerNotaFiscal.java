package notas;

import utilidade.Utils;
import faturas.Fatura;


public class ControllerNotaFiscal {

    public Nota criaNotaFiscal(String nomeCliente, String enderecoCliente, String tipoServico, Double valor){
        Fatura fatura = new Fatura(nomeCliente, enderecoCliente, tipoServico, valor);
        Nota nota = new Nota(fatura);

        return nota;
    }



}
