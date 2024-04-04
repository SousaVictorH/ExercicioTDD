package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import tarefas.ControllerTarefas;
import tarefas.RepositorioTarefas;
import tarefas.Tarefa;

class ControllerTarefasTest2 {

	private ControllerTarefas controllerTarefas;
	private RepositorioTarefas repositorioTarefas;
	
	@BeforeEach
	void criaControllerTarefas() {
		controllerTarefas = new ControllerTarefas();
		repositorioTarefas = new RepositorioTarefas();
	}
	
	@Tag("fast")
	@Test
	void testCriaTarefa() {
		assertEquals(0, controllerTarefas.getNumeroTarefas(repositorioTarefas));
		
		controllerTarefas.criaTarefa(repositorioTarefas, "Titulo", "Descricao", "20/08/2025", 3);
		
		assertEquals(1, controllerTarefas.getNumeroTarefas(repositorioTarefas));
	}
	
	@Tag("fast")
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
	
	@Tag("fast")
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
	
	@Tag("fast")
	@Test
	void testAtualizaTarefa() {
		String codigo = controllerTarefas.criaTarefa(repositorioTarefas, "Titulo", "Descricao", "20/08/2025", 3);
		
		controllerTarefas.atualizaTarefa(repositorioTarefas, codigo, "Titulo 2", "Descricao 2", "25/08/2025", 2);
		
		Tarefa tarefa = controllerTarefas.getTarefa(repositorioTarefas, codigo);
		
		assertEquals("Titulo 2", tarefa.getTitulo());
		assertEquals("Descricao 2", tarefa.getDescricao());
		assertEquals("25/08/2025", tarefa.getVencimento());
		assertEquals(2, tarefa.getPrioridade());
	}
	
	@Tag("fast")
	@Test
	void testAtualizaTarefaNull() {
		String codigo = controllerTarefas.criaTarefa(repositorioTarefas, "Titulo", "Descricao", "20/08/2025", 3);

		assertThrows(NullPointerException.class, () -> {
			controllerTarefas.atualizaTarefa(repositorioTarefas, null, "Titulo 2", "Descricao 2", "25/08/2025", 2);
		});
		
		assertThrows(NullPointerException.class, () -> {
			controllerTarefas.atualizaTarefa(repositorioTarefas, codigo, null, "Descricao 2", "25/08/2025", 2);
		});
		
		assertThrows(NullPointerException.class, () -> {
			controllerTarefas.atualizaTarefa(repositorioTarefas, codigo, "Titulo 2", null, "25/08/2025", 2);
		});
		
		assertThrows(NullPointerException.class, () -> {
			controllerTarefas.atualizaTarefa(repositorioTarefas, codigo, "Titulo 2", "Descricao 2", null, 2);
		});
		
		assertThrows(NullPointerException.class, () -> {
			controllerTarefas.atualizaTarefa(repositorioTarefas, codigo, "Titulo 2", "Descricao 2", "25/08/2025", null);
		});
	}
	
	@Tag("fast")
	@Test
	void testAtualizaTarefaInvalida() {
		String codigo = controllerTarefas.criaTarefa(repositorioTarefas, "Titulo", "Descricao", "20/08/2025", 3);

		assertThrows(IllegalArgumentException.class, () -> {
			controllerTarefas.atualizaTarefa(repositorioTarefas, "", "Titulo 2", "Descricao 2", "25/08/2025", 2);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			controllerTarefas.atualizaTarefa(repositorioTarefas, "-1", "Titulo 2", "Descricao 2", "25/08/2025", 2);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			controllerTarefas.atualizaTarefa(repositorioTarefas, codigo, "", "Descricao 2", "25/08/2025", 2);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			controllerTarefas.atualizaTarefa(repositorioTarefas, codigo, "Titulo 2", "", "25/08/2025", 2);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			controllerTarefas.atualizaTarefa(repositorioTarefas, codigo, "Titulo 2", "Descricao 2", "", 2);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			controllerTarefas.atualizaTarefa(repositorioTarefas, codigo, "Titulo 2", "Descricao 2", "25/08/2025", 0);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			controllerTarefas.atualizaTarefa(repositorioTarefas, codigo, "Titulo 2", "Descricao 2", "25/08/2025", 4);
		});
	}
	
	@Test
	void testRemoveTarefa() {
		assertEquals(0, controllerTarefas.getNumeroTarefas(repositorioTarefas));
		
		String codigo = controllerTarefas.criaTarefa(repositorioTarefas, "Titulo", "Descricao", "20/08/2025", 3);
		
		assertEquals(1, controllerTarefas.getNumeroTarefas(repositorioTarefas));
		
		controllerTarefas.removeTarefa(repositorioTarefas, codigo);
		
		assertEquals(0, controllerTarefas.getNumeroTarefas(repositorioTarefas));
	}
	
	@Test
	void testRemoveTarefaNull() {
		assertEquals(0, controllerTarefas.getNumeroTarefas(repositorioTarefas));
		
		controllerTarefas.criaTarefa(repositorioTarefas, "Titulo", "Descricao", "20/08/2025", 3);
		
		assertEquals(1, controllerTarefas.getNumeroTarefas(repositorioTarefas));
		
		assertThrows(NullPointerException.class, () -> {
			controllerTarefas.removeTarefa(repositorioTarefas, null);
		});
		
		assertEquals(1, controllerTarefas.getNumeroTarefas(repositorioTarefas));
	}
	
	@Test
	void testRemoveTarefaInvalido() {
		assertEquals(0, controllerTarefas.getNumeroTarefas(repositorioTarefas));
		
		controllerTarefas.criaTarefa(repositorioTarefas, "Titulo", "Descricao", "20/08/2025", 3);
		
		assertEquals(1, controllerTarefas.getNumeroTarefas(repositorioTarefas));
		
		assertThrows(IllegalArgumentException.class, () -> {
			controllerTarefas.removeTarefa(repositorioTarefas, "");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			controllerTarefas.removeTarefa(repositorioTarefas, "-1");
		});
		
		assertEquals(1, controllerTarefas.getNumeroTarefas(repositorioTarefas));
	}
	
	@Test
	void testListaTarefas() {
		controllerTarefas.criaTarefa(repositorioTarefas, "Titulo", "Descricao", "20/08/2025", 3);
		
		assertEquals("Titulo - Descricao - 20/08/2025 - 3\n", controllerTarefas.listaTarefas(repositorioTarefas, true));
		
		assertEquals("Titulo - Descricao - 20/08/2025 - 3\n", controllerTarefas.listaTarefas(repositorioTarefas, false));
	}
	
	@Test
	void testOrdenarPorVencimento() {
		controllerTarefas.criaTarefa(repositorioTarefas, "Titulo", "Descricao", "20/08/2025", 3);
		
		assertEquals("Titulo - Descricao - 20/08/2025 - 3\n", controllerTarefas.listaTarefas(repositorioTarefas, true));
		
		controllerTarefas.criaTarefa(repositorioTarefas, "Titulo 2", "Descricao 2", "19/08/2025", 2);
		
		assertEquals("Titulo 2 - Descricao 2 - 19/08/2025 - 2\nTitulo - Descricao - 20/08/2025 - 3\n", controllerTarefas.listaTarefas(repositorioTarefas, true));
	}
	
	@Test
	void testOrdenarPorPrioridade() {
		controllerTarefas.criaTarefa(repositorioTarefas, "Titulo", "Descricao", "20/08/2025", 2);
		
		assertEquals("Titulo - Descricao - 20/08/2025 - 2\n", controllerTarefas.listaTarefas(repositorioTarefas, false));
		
		controllerTarefas.criaTarefa(repositorioTarefas, "Titulo 2", "Descricao 2", "19/08/2025", 3);
		
		assertEquals("Titulo 2 - Descricao 2 - 19/08/2025 - 3\nTitulo - Descricao - 20/08/2025 - 2\n", controllerTarefas.listaTarefas(repositorioTarefas, false));
	}
	
	@ParameterizedTest
	@ValueSource(ints = {1, 2})
	void testMarcaPrioridade(Integer prioridade) {
		String codigo = controllerTarefas.criaTarefa(repositorioTarefas, "Titulo", "Descricao", "20/08/2025", prioridade);
		
		Tarefa tarefa = controllerTarefas.getTarefa(repositorioTarefas, codigo);
		
		assertEquals(prioridade, tarefa.getPrioridade());
		
		tarefa.setPrioridade(prioridade + 1);
		
		Tarefa tarefa2 = controllerTarefas.getTarefa(repositorioTarefas, codigo);
		
		assertEquals(prioridade + 1, tarefa2.getPrioridade());
	}
	
	@Tag("fast")
	@Test
	void testTarefa() {
		String codigo = controllerTarefas.criaTarefa(repositorioTarefas, "Titulo", "Descricao", "20/08/2025", 2);
		
		Tarefa tarefa = controllerTarefas.getTarefa(repositorioTarefas, codigo);
		
		assertEquals("Titulo", tarefa.getTitulo());
		assertEquals("Descricao", tarefa.getDescricao());
		assertEquals("20/08/2025", tarefa.getVencimento());
		assertEquals(2, tarefa.getPrioridade());
	}
	
	@ParameterizedTest
	@NullSource
	void testTarefaTituloNull(String titulo) {
		assertThrows(NullPointerException.class, () -> {
			controllerTarefas.criaTarefa(repositorioTarefas, titulo, "Descricao", "20/08/2025", 2);
		});
	}
	
	@ParameterizedTest
	@EmptySource
	void testTarefaTituloInvalido(String titulo) {
		assertThrows(IllegalArgumentException.class, () -> {
			controllerTarefas.criaTarefa(repositorioTarefas, titulo, "Descricao", "20/08/2025", 2);
		});
	}
	
	@ParameterizedTest
	@NullSource
	void testTarefaDescricaoNull(String descricao) {
		assertThrows(NullPointerException.class, () -> {
			controllerTarefas.criaTarefa(repositorioTarefas, "Titulo", descricao, "20/08/2025", 2);
		});
	}
	
	@ParameterizedTest
	@EmptySource
	void testTarefaDescricaoInvalida(String descricao) {
		assertThrows(IllegalArgumentException.class, () -> {
			controllerTarefas.criaTarefa(repositorioTarefas, "Titulo", descricao, "20/08/2025", 2);
		});
	}
	
	@ParameterizedTest
	@NullSource
	void testTarefaVencimentoNull(String vencimento) {
		assertThrows(NullPointerException.class, () -> {
			controllerTarefas.criaTarefa(repositorioTarefas, "Titulo", "Descricao", vencimento, 2);
		});
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"", "20/08/1900"})
	void testTarefaVencimentoInvalido(String vencimento) {
		assertThrows(IllegalArgumentException.class, () -> {
			controllerTarefas.criaTarefa(repositorioTarefas, "Titulo", "Descricao", vencimento, 2);
		});
	}
	
	@ParameterizedTest
	@NullSource
	void testTarefaPrioridadeNull(Integer prioridade) {
		assertThrows(NullPointerException.class, () -> {
			controllerTarefas.criaTarefa(repositorioTarefas, "Titulo", "Descricao", "20/08/2025", prioridade);
		});
	}
	
	@ParameterizedTest
	@ValueSource(ints = {0, 4})
	void testTarefaPrioridadeInvalida(Integer prioridade) {
		assertThrows(IllegalArgumentException.class, () -> {
			controllerTarefas.criaTarefa(repositorioTarefas, "Titulo", "Descricao", "20/08/2025", prioridade);
		});
	}
}