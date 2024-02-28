package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import tarefas.Tarefa;

class TarefaTest {
	
	@Test
	void testCriaTarefa() {
		String titulo = "Titulo";
		String descricao = "Titulo";
		String vencimento = "25/10/2024";
		Integer prioridade = 3;
		
		Tarefa tarefa = new Tarefa(titulo, descricao, vencimento, prioridade);
		
		assertEquals(titulo, tarefa.getTitulo());
	}

}
