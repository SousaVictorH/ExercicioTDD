package tarefas;

import utilidade.Utils;

public class ControllerTarefas {
	
	public void criaTarefa(RepositorioTarefas repositorioTarefas, String titulo, String descricao, String vencimento, Integer prioridade) {
		Utils.validaString(titulo, "Campo titulo nao pode ser nulo ou vazio.");
		Utils.validaString(descricao, "Campo descricao nao pode ser nulo ou vazio.");
		Utils.validaString(vencimento, "Campo vencimento nao pode ser nulo ou vazio.");
		Utils.validaInteiro(prioridade, "Campo prioridade nao pode ser nulo ou vazio.");
		
		Tarefa tarefa = new Tarefa(titulo, descricao, vencimento, prioridade);
				
		repositorioTarefas.adicionaTarefa(tarefa);
	}
	
	public Integer getNumeroTarefas(RepositorioTarefas repositorioTarefas) {
		return repositorioTarefas.getNumeroTarefas();
	}
}
