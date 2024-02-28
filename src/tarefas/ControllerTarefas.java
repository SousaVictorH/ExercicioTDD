package tarefas;

import utilidade.Utils;

public class ControllerTarefas {
	
	private String geraCodigo(RepositorioTarefas repositorioTarefas) {
		return "T" + Integer.toString(repositorioTarefas.geraCodigo());
	}
	
	public String criaTarefa(RepositorioTarefas repositorioTarefas, String titulo, String descricao, String vencimento, Integer prioridade) {
		Utils.validaString(titulo, "Campo titulo nao pode ser nulo ou vazio.");
		Utils.validaString(descricao, "Campo descricao nao pode ser nulo ou vazio.");
		Utils.validaString(vencimento, "Campo vencimento nao pode ser nulo ou vazio.");
		Utils.validaInteiro(prioridade, "Campo prioridade nao pode ser nulo ou vazio.");
		Utils.validaPrioridade(prioridade, "Campo prioridade deve estar entre 1 e 3");
		
		String codigo = geraCodigo(repositorioTarefas);
		
		Tarefa tarefa = new Tarefa(titulo, descricao, vencimento, prioridade);
				
		repositorioTarefas.adicionaTarefa(codigo, tarefa);
		
		return codigo;
	}
	
	public Integer getNumeroTarefas(RepositorioTarefas repositorioTarefas) {
		return repositorioTarefas.getNumeroTarefas();
	}
	
	public void atualizaTarefa(RepositorioTarefas repositorioTarefas, String codigo, String titulo, String descricao, String vencimento, Integer prioridade) {
		Tarefa tarefa = this.getTarefa(repositorioTarefas, codigo);
		
		tarefa.setTitulo(titulo);
		tarefa.setDescricao(descricao);
		tarefa.setVencimento(vencimento);
		tarefa.setPrioridade(prioridade);
	}
	
	public Tarefa getTarefa(RepositorioTarefas repositorioTarefas, String codigo) {
		return repositorioTarefas.getTarefa(codigo);
	}
}
