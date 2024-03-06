package tarefas;

public class Tarefa {
	private String titulo;
	private String descricao;
	private String vencimento;
	private Integer prioridade;
	
	public Tarefa(String titulo, String descricao, String vencimento, Integer prioridade) {
		this.setTitulo(titulo);
		this.setDescricao(descricao);
		this.setVencimento(vencimento);
		this.setPrioridade(prioridade);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getVencimento() {
		return vencimento;
	}

	public void setVencimento(String vencimento) {
		this.vencimento = vencimento;
	}

	public Integer getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Integer prioridade) {
		this.prioridade = prioridade;
	}
	
	public String toString() {
		return titulo + " - " + descricao + " - " + vencimento + " - " + prioridade;
	}


}
