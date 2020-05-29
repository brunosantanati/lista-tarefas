package com.capgemini.mbean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.capgemini.model.Tarefa;

@ManagedBean
@RequestScoped
public class GerenciadorTarefasBean {

	List<Tarefa> tarefas;
	Tarefa tarefa;
	
	public GerenciadorTarefasBean() {
		tarefas = new ArrayList<>();
		
		//adicionando algumas tarefas para teste
		tarefas.add(new Tarefa(1, "Titulo 1", "Descricao 1", 1, new Date()));
		tarefas.add(new Tarefa(2, "Titulo 2", "Descricao 2", 1, new Date()));
		
		tarefa = new Tarefa(3, "", "", 1, new Date());
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
