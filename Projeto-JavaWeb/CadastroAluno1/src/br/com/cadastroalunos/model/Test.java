package br.com.cadastroalunos.model;

import java.sql.SQLException;
import java.util.Date;

//import br.com.cadastroalunos.connection.ConnectionFactory;
import br.com.cadastroalunos.dao.AlunoDao;

public class Test {

	public static void main(String[] args) throws SQLException {
		
		
		AlunoDao alunoDao = new AlunoDao();
		
		System.out.println(alunoDao.findByName("werike"));
		
		
		
		
		
		
		
		
		
		
		
		/*
		Aluno aluno = new Aluno();
		
		aluno.setNome("Werike");
		aluno.setDataNascimento(new Date());
		aluno.setEndereco("Werike02");
		aluno.setEmail("Werike03");
		aluno.setTelefone("Werike04");
		
		AlunoDao alunoDao = new AlunoDao();*/

		
		/*
		try {
			// instrucao sql
			String sql = "select * from aluno";
			// prepara sua instru��o para ser utilizada
			PreparedStatement statement = cFactory.getConnection().prepareStatement(sql);
			// Result os resultados
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				System.out.println(resultSet.getString("nome"));
			}
		} catch (SQLException e) {
			System.out.println("" + e.getMessage());
			e.printStackTrace();
		}*/
	}
}
