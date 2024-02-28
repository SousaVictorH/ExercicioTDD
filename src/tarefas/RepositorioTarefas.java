package tarefas;

import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class RepositorioTarefas {
	
	static int id;
	
	private HashMap<String, Tarefa> tarefas;
	
	public RepositorioTarefas() {
		this.tarefas = new HashMap<String, Tarefa>();
	}
	
	public int geraCodigo() {
		id++;
		return id;
	}

	public void adicionaTarefa(String codigo, Tarefa tarefa) {
		tarefas.put(codigo, tarefa);
	}
	
	public Integer getNumeroTarefas() {
		return tarefas.size();
	}
	
	public boolean existeTarefa(String codigo) {
		return tarefas.containsKey(codigo);
	}
	
	public Tarefa getTarefa(String codigo) {
		return tarefas.get(codigo);
	}
	
	public void removeTarefa(String codigo) {
		tarefas.remove(codigo);
	}
	
	public String ordenarPorVencimento() {
		String str = "";
		
        List<Tarefa> listaTarefas = new ArrayList<>(tarefas.values());

        Collections.sort(listaTarefas, new Comparator<Tarefa>() {
        	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        	
            @Override
            public int compare(Tarefa tarefa1, Tarefa tarefa2) {
                try {
                	Date data1 = simpleDateFormat.parse(tarefa1.getVencimento());
                    Date data2 = simpleDateFormat.parse(tarefa2.getVencimento());
                    
                    return data1.compareTo(data2);
                } catch (ParseException excpt) {
                	return 0;
                }
            }
        });
		
	    for (Tarefa tarefa : listaTarefas) {
	        str += tarefa.toString() + "\n";
	    }
				
		return str;
	}
	
	public String ordenarPorPrioridade() {
		String str = "";
		
        List<Tarefa> listaTarefas = new ArrayList<>(tarefas.values());

        Collections.sort(listaTarefas, new Comparator<Tarefa>() {
            @Override
            public int compare(Tarefa tarefa1, Tarefa tarefa2) {
                return tarefa1.getVencimento().compareTo(tarefa2.getVencimento());
            }
        });
		
	    for (Tarefa tarefa : listaTarefas) {
	        str += tarefa.toString() + "\n";
	    }
				
		return str;
	}
}
