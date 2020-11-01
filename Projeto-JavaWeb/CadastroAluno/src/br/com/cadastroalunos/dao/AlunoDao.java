package br.com.cadastroalunos.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cadastroalunos.connection.ConnectionFactory;
import br.com.cadastroalunos.model.Aluno;
import br.com.cadastroalunos.utils.AlunoUtil;

public class AlunoDao {
	
	Connection connection = null;
	PreparedStatement stmt = null;
	ResultSet resultSet = null;
	
	public void create(Aluno aluno) throws SQLException {

		String insert = "INSERT INTO aluno(nome, dataNascimento, endereco, email, telefone) VALUES (?,?,?,?,?)";
		try {
			stmt = ConnectionFactory.getConnection().prepareStatement(insert);
			stmt.setString(1, aluno.getNome());
			stmt.setDate(2, AlunoUtil.convert(aluno.getDataNascimento())); //ESTA CONVERTENDO O DATE DO JAVA PARA DATE DO MYSQL
			stmt.setString(3, aluno.getEndereco());
			stmt.setString(4, aluno.getEmail());
			stmt.setString(5, aluno.getTelefone());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			stmt.close();
		}
	}
	
	public void update(Aluno aluno) {
		String update = "UPDATE aluno set(nome = ?, dataNascimento = ?, endereco = ?, email = ?, telefone = ?) WHERE nome = ?";
		
		try {
			stmt = ConnectionFactory.getConnection().prepareStatement(update);
			stmt.setString(1, aluno.getNome());
			stmt.setDate(2, (Date) aluno.getDataNascimento()); 
			stmt.setString(3, aluno.getEndereco());
			stmt.setString(4, aluno.getEmail());
			stmt.setString(5, aluno.getTelefone());
			stmt.setString(6, aluno.getNome());//BUSCANDO ATRAVES DO NOME EM OUTRO CAMPO
			stmt.execute();
		} catch (SQLException e) {		
			e.printStackTrace();
		}
	}
	
	public void delete(Aluno aluno) {
		String delete = "DELETE FROM aluno WHERE nome = ?";
		
		try {
			stmt = ConnectionFactory.getConnection().prepareStatement(delete);
			stmt.setString(1, aluno.getNome());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Aluno> findByName(String nome) {
		
		List<Aluno> listaAluno = new ArrayList();
		
		String select = "Select nome, dataNascimento, endereco, email, telefone FROM aluno WHERE nome = ?";
		
		try {
			stmt = ConnectionFactory.getConnection().prepareStatement(select);
			stmt.setString(1, nome);//
			resultSet = stmt.executeQuery();
			
			while(resultSet.next()) {
				Aluno aluno = new Aluno();
				
				aluno.setNome(resultSet.getString("nome"));
				aluno.setDataNascimento(resultSet.getDate("dataNascimento")); //TIPO DATE
				aluno.setEndereco(resultSet.getString("endereco"));
				aluno.setEmail(resultSet.getString("email"));
				aluno.setTelefone(resultSet.getString("telefone"));
				listaAluno.add(aluno);
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaAluno;
	}	
}
