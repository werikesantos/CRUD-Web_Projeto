package br.com.cadastroalunos.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cadastroalunos.dao.AlunoDao;
import br.com.cadastroalunos.model.Aluno;
import br.com.cadastroalunos.utils.AlunoUtil;

@WebServlet(urlPatterns = "/AlunoCreateServlet")
public class AlunoCreateServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req = recebendo 
		//resp = resposta que será enviada
		super.doPost(req, resp);
		
		Aluno aluno = new Aluno();
		
		aluno.setNome(req.getParameter("nome"));
		aluno.setEndereco(req.getParameter("endereco"));
		aluno.setDataNascimento(AlunoUtil.convertToStringToDate(req.getParameter("dataNascimento")));
		aluno.setEmail(req.getParameter("email"));
		aluno.setTelefone(req.getParameter("telefone"));
		
		AlunoDao alunodao = new AlunoDao();
		
		try {
			alunodao.create(aluno);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}