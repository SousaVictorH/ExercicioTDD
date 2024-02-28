package tarefas;

public class ControllerTarefas {
	
	public void criaTarefa(RepositorioTarefas repositorioTarefas, String titulo, String descricao, String vencimento, Integer prioridade) {
		Tarefa tarefa = new Tarefa(titulo, descricao, vencimento, prioridade);
				
		repositorioTarefas.adicionaTarefa(tarefa);
	}
	
	public Integer getNumeroTarefas(RepositorioTarefas repositorioTarefas) {
		return repositorioTarefas.getNumeroTarefas();
	}
}
