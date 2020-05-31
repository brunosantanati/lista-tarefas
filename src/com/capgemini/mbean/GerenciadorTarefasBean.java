package com.capgemini.mbean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.capgemini.model.Tarefa;

@ManagedBean
@SessionScoped
public class GerenciadorTarefasBean {

	private List<Tarefa> tarefas;
	private Tarefa tarefa;
	private static int contador;
	
	public GerenciadorTarefasBean() {

		tarefas = new ArrayList<>();
		
		//adicionando algumas tarefas para teste
		tarefas.add(new Tarefa(1, "Titulo 1", "Descricao 1", "Baixa", new Date()));
		tarefas.add(new Tarefa(2, "Titulo 2", "Descricao 2", "Alta", new Date()));
		
		contador = tarefas.size();
		
		tarefa = new Tarefa(++contador, "", "", "Média", new Date());
	}
	
	public void novaTarefa() {
		tarefa = new Tarefa(++contador, "", "", "Média", new Date());
	}
	
	public void salvarTarefa() {
		tarefas.add(tarefa);
		novaTarefa();
		addMessage("Tarefa salva!");
	}
	
	public void apagarTarefa(Tarefa tarefa) {
		tarefas.remove(tarefa);
		addMessage("Tarefa apagada!");
	}
	
	public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}
	
}
