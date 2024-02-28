package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tarefas.ControllerTarefas;
import tarefas.RepositorioTarefas;
import tarefas.Tarefa;

class ControllerTarefasTest {

	private ControllerTarefas controllerTarefas;
	private RepositorioTarefas repositorioTarefas;
	
	@BeforeEach
	void criaControllerTarefas() {
		controllerTarefas = new ControllerTarefas();
		repositorioTarefas = new RepositorioTarefas();
	}
	
	@Test
	void testCriaTarefa() {
		assertEquals(0, controllerTarefas.getNumeroTarefas(repositorioTarefas));
		
		controllerTarefas.criaTarefa(repositorioTarefas, "Titulo", "Descricao", "20/08/2025", 3);
		
		assertEquals(1, controllerTarefas.getNumeroTarefas(repositorioTarefas));
	}
	
	@Test
	void testCriaTarefaNull() {
		assertThrows(NullPointerException.class, () -> {
			controllerTarefas.criaTarefa(repositorioTarefas, null, "Descricao", "20/08/2025", 3);
		});
		
		assertThrows(NullPointerException.class, () -> {
			controllerTarefas.criaTarefa(repositorioTarefas, "Titulo", null, "20/08/2025", 3);
		});
		
		assertThrows(NullPointerException.class, () -> {
			controllerTarefas.criaTarefa(repositorioTarefas, "Titulo", "Descricao", null, 3);
		});
		
		assertThrows(NullPointerException.class, () -> {
			controllerTarefas.criaTarefa(repositorioTarefas, "Titulo", "Descricao", "20/08/2025", null);
		});
	}
	
	@Test
	void testCriaTarefaInvalida() {
		assertThrows(IllegalArgumentException.class, () -> {
			controllerTarefas.criaTarefa(repositorioTarefas, "", "Descricao", "20/08/2025", 3);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			controllerTarefas.criaTarefa(repositorioTarefas, "Titulo", "", "20/08/2025", 3);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			controllerTarefas.criaTarefa(repositorioTarefas, "Titulo", "Descricao", "", 3);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			controllerTarefas.criaTarefa(repositorioTarefas, "Titulo", "Descricao", "20/08/2025", 0);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			controllerTarefas.criaTarefa(repositorioTarefas, "Titulo", "Descricao", "20/08/2025", 4);
		});
	}
	
	@Test
	void testAtualizaTarefa() {
		String code = controllerTarefas.criaTarefa(repositorioTarefas, "Titulo", "Descricao", "20/08/2025", 3);
		
		controllerTarefas.atualizaTarefa(repositorioTarefas, code, "Titulo 2", "Descricao 2", "25/08/2025", 2);
		
		Tarefa tarefa = controllerTarefas.getTarefa(repositorioTarefas, code);
		
		assertEquals("Titulo 2", tarefa.getTitulo());
		assertEquals("Descricao 2", tarefa.getDescricao());
		assertEquals("25/08/2025", tarefa.getVencimento());
		assertEquals(2, tarefa.getPrioridade());
	}
	
}