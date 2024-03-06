package faturas;

import tarefas.RepositorioTarefas;
import tarefas.Tarefa;
import utilidade.Utils;

public class ControllerFaturas {
    public Fatura criaFatura(String nome, String endereco, String tipoServico, Double valor) {
        Utils.validaString(nome, "Campo nome nao pode ser nulo ou vazio.");
        Utils.validaString(endereco, "Campo endereco nao pode ser nulo ou vazio.");
        Utils.validaString(tipoServico, "Campo vencimento nao pode ser nulo ou vazio.");
        Utils.validaDouble(valor, "Campo valor nao pode ser nulo ou vazio.");

        Fatura fatura = new Fatura(nome, endereco, tipoServico, valor);

        return fatura;
    }
}
