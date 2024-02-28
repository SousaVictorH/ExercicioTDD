package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tarefas.ControllerTarefas;
import tarefas.RepositorioTarefas;

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
	
}