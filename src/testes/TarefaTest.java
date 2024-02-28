package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import tarefas.Tarefa;

class TarefaTest {
	
	@Test
	void testCriaTarefa() {
		Tarefa tarefa = new Tarefa("Titulo", "Descricao", "20/08/2025", 3);

		assertEquals("Titulo", tarefa.getTitulo());
		assertEquals("Descricao", tarefa.getDescricao());
		assertEquals("20/08/2025", tarefa.getVencimento());
		assertEquals(3, tarefa.getPrioridade());
	}
	
}
