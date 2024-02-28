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
	
	@Test
	void testGetSetTarefa() {
		Tarefa tarefa = new Tarefa("Titulo", "Descricao", "20/08/2025", 3);
		
		tarefa.setTitulo("Titulo 2");
		assertEquals("Titulo 2", tarefa.getTitulo());
		
		tarefa.setDescricao("Descricao 2");
		assertEquals("Descricao 2", tarefa.getDescricao());
		
		tarefa.setVencimento("21/08/2025");
		assertEquals("21/08/2025", tarefa.getVencimento());
		
		tarefa.setPrioridade(2);
		assertEquals(2, tarefa.getPrioridade());
	}
	
	@Test
	void testToString() {
		Tarefa tarefa = new Tarefa("Titulo", "Descricao", "20/08/2025", 3);
		
		assertEquals("Titulo - Descricao - 20/08/2025 - 3", tarefa.toString());
	}
}
