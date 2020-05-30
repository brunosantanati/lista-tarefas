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

	List<Tarefa> tarefas;
	Tarefa tarefa;
	
	public GerenciadorTarefasBean() {
		tarefas = new ArrayList<>();
		
		//adicionando algumas tarefas para teste
		tarefas.add(new Tarefa(1, "Titulo 1", "Descricao 1", "Baixa", new Date()));
		tarefas.add(new Tarefa(2, "Titulo 2", "Descricao 2", "Alta", new Date()));
		
		tarefa = new Tarefa((tarefas.size() + 1), "", "", "Média", new Date());
	}
	
	public void novaTarefa() {
		tarefa = new Tarefa((tarefas.size() + 1), "", "", "Média", new Date());
	}
	
	public void salvarTarefa() {
		tarefas.add(tarefa);
		novaTarefa();
		addMessage("Tarefa salva!");
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
