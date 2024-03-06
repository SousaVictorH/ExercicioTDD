package faturas;

import tarefas.RepositorioTarefas;
import tarefas.Tarefa;
import utilidade.Utils;
import java.util.HashMap;
import java.util.Map;

public class ControllerFaturas {
    private Map<String, Fatura> mapDeFaturas = new HashMap<>();

    public Fatura criaFatura(String nome, String endereco, String tipoServico, Double valor) {
        Utils.validaString(nome, "Campo nome nao pode ser nulo ou vazio.");
        Utils.validaString(endereco, "Campo endereco nao pode ser nulo ou vazio.");
        Utils.validaString(tipoServico, "Campo vencimento nao pode ser nulo ou vazio.");
        Utils.validaDouble(valor, "Campo valor nao pode ser nulo ou vazio.");

        Fatura fatura = new Fatura(nome, endereco, tipoServico, valor);
        addFaturaToMap(fatura);

        return fatura;
    }

    public String addFaturaToMap(Fatura fatura){
        mapDeFaturas.put(fatura.getId(), fatura);

        return fatura.getId();
    }

    public String getFatura(String id){
        Fatura fatura = mapDeFaturas.get(id);
        return fatura.getId();
    }


}
