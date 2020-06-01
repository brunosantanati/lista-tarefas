package com.capgemini.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.factory.ConexaoFactory;
import com.capgemini.model.Tarefa;

public class TarefaDao {
	
	public static void salvar(Tarefa tarefa) {
			
		Connection conexao;
		PreparedStatement statement;
		try { //substituir por try with resources
			conexao = ConexaoFactory.getConnection();
			
			String sql = "INSERT INTO tarefa (titulo, descricao, prioridade, data_limite) VALUES (?, ?, ?, ?)";
		 
			statement = conexao.prepareStatement(sql);
			statement.setString(1, tarefa.getTitulo());
			statement.setString(2, tarefa.getDescricao());
			statement.setString(3, tarefa.getPrioridade());
			statement.setDate(4, new Date(tarefa.getDataLimite().getTime()));
			 
			int linhasInseridas = statement.executeUpdate();
			if (linhasInseridas > 0) {
			    System.out.println("tarefa inserida no BD!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Tarefa> getTarefas(){
		
		try {
		
			Connection conexao = ConexaoFactory.getConnection();
			
			String sql = "SELECT * FROM tarefa";
			 
			Statement statement = conexao.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			List<Tarefa> tarefas = new ArrayList<>();
			 
			while (result.next()){
				int id = result.getInt(1);
			    String titulo = result.getString(2);
			    String descricao = result.getString(3);
			    String prioridade = result.getString(4);
			    java.util.Date dataLimite = new java.util.Date(result.getDate(5).getTime());
			    tarefas.add(new Tarefa(id, titulo, descricao, prioridade, dataLimite));
			}
			
			return tarefas;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void apagar(Integer id) {
		try {
		
			Connection conexao = ConexaoFactory.getConnection();
			
			String sql = "DELETE FROM tarefa WHERE id=?";
			 
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setInt(1, id.intValue());
			 
			int linhasApagadas = statement.executeUpdate();
			if (linhasApagadas > 0) {
			    System.out.println("tarefa apagada do BD!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void atualizar(Tarefa tarefa) {
		
		try {
		
			Connection conexao = ConexaoFactory.getConnection();	
				
			String sql = "UPDATE tarefa SET titulo=?, descricao=?, prioridade=?, data_limite=? WHERE id=?";
			 
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setString(1, tarefa.getTitulo());
			statement.setString(2, tarefa.getDescricao());
			statement.setString(3, tarefa.getPrioridade());
			statement.setDate(4, new Date(tarefa.getDataLimite().getTime()));
			statement.setInt(5, tarefa.getId().intValue());
			 
			int linhasAtualizadas = statement.executeUpdate();
			if (linhasAtualizadas > 0) {
			    System.out.println("tarefa atualizada no BD!");
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
