package tarefas;

import java.util.Collection;
import java.util.HashMap;

public class RepositorioTarefas {
	
	static int id;
	
	private HashMap<String, Tarefa> tarefas;
	
	public RepositorioTarefas() {
		this.tarefas = new HashMap<String, Tarefa>();
	}
	
	public int geraCodigo() {
		id++;
		return id;
	}

	public void adicionaTarefa(String codigo, Tarefa tarefa) {
		tarefas.put(codigo, tarefa);
	}
	
	public Integer getNumeroTarefas() {
		return tarefas.size();
	}
	
	public boolean existeTarefa(String codigo) {
		return tarefas.containsKey(codigo);
	}
	
	public Tarefa getTarefa(String codigo) {
		return tarefas.get(codigo);
	}
	
	public void removeTarefa(String codigo) {
		tarefas.remove(codigo);
	}
	
	public String ordenarPorVencimento() {
		String str = "";
		
		Collection<Tarefa> listaTarefas = tarefas.values();
		
	    for (Tarefa tarefa : listaTarefas) {
	        str += tarefa.toString();
	    }
				
		return str;
	}
	
	public String ordenarPorPrioridade() {
		String str = "";
		
		Collection<Tarefa> listaTarefas = tarefas.values();
		
	    for (Tarefa tarefa : listaTarefas) {
	        str += tarefa.toString();
	    }
				
		return str;
	}
}
