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
		String titulo = "Titulo";
		String descricao = "Titulo";
		String vencimento = "25/10/2024";
		Integer prioridade = 3;
		
		assertEquals(0, controllerTarefas.getNumeroTarefas(repositorioTarefas));
		
		controllerTarefas.criaTarefa(repositorioTarefas, titulo, descricao, vencimento, prioridade);
		
		assertEquals(1, controllerTarefas.getNumeroTarefas(repositorioTarefas));
	}
}