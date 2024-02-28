package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TarefaTest {
	
	private Tarefa tarefa;

	@Test
	void testCriaTarefa() {
		String titulo = "Titulo";
		String descricao = "Titulo";
		String vencimento = "25/10/2024";
		Integer prioridade = 3;
		
		tarefa = new Tarefa(titulo, descricao, vencimento, prioridade);
		
		assertEquals(titulo, tarefa.getTitulo());
	}

}
