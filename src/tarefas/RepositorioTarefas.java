package tarefas;

import java.util.ArrayList;

public class RepositorioTarefas {
	
	private ArrayList<Tarefa> tarefas;
	
	public RepositorioTarefas() {
		this.tarefas = new ArrayList<Tarefa>();
	}

	public void adicionaTarefa(Tarefa tarefa) {
		tarefas.add(tarefa);
	}
	
	public Integer getNumeroTarefas() {
		return tarefas.size();
	}
}
