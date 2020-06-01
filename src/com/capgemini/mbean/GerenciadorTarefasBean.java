package com.capgemini.mbean;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.capgemini.dao.TarefaDao;
import com.capgemini.model.Tarefa;

@ManagedBean
@SessionScoped
public class GerenciadorTarefasBean {

	private List<Tarefa> tarefas;
	private Tarefa tarefa;
	
	public GerenciadorTarefasBean() {
		tarefas = TarefaDao.getTarefas();		
		tarefa = new Tarefa(null, "", "", "Média", new Date());
	}
	
	public void novaTarefa() {
		tarefa = new Tarefa(null, "", "", "Média", new Date());
	}
	
	public void salvarTarefa() {
		
		if(tarefa.getId() == null) {			
			TarefaDao.salvar(tarefa);
			addMessage("Tarefa salva!");
		}else {
			TarefaDao.atualizar(tarefa);
			addMessage("Tarefa atualizada!");
		}
		
		tarefas = TarefaDao.getTarefas();
		
		novaTarefa();
	}
	
	public void editarTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}
	
	public void apagarTarefa(Tarefa tarefa) {
		TarefaDao.apagar(tarefa.getId());
		tarefas = TarefaDao.getTarefas();
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
