package com.capgemini.model;

import java.util.Date;

public class Tarefa {
	
	private Integer id;
	private String titulo;
	private String descricao;
	private String prioridade;
	private Date dataLimite;
	
	public Tarefa(Integer id, String titulo, String descricao, String prioridade, Date dataLimite) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.prioridade = prioridade;
		this.dataLimite = dataLimite;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}
	public Date getDataLimite() {
		return dataLimite;
	}
	public void setDataLimite(Date dataLimite) {
		this.dataLimite = dataLimite;
	}

	@Override
	public String toString() {
		return "Tarefa [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", prioridade=" + prioridade
				+ ", dataLimite=" + dataLimite + "]";
	}

}
