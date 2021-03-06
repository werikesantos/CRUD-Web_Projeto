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

@WebServlet(urlPatterns = "/alunocreateservlet")
public class AlunoCreateServlet extends HttpServlet{
	
	public AlunoCreateServlet() {
		super();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req = recebendo 
		//resp = resposta que ser� enviada
		super.doPost(req, resp);
		
		Aluno aluno = new Aluno();
		
		aluno.setNome(req.getParameter("nome"));
		aluno.setEndereco(req.getParameter("endereco"));
		aluno.setDataNascimento(AlunoUtil.convertToStringToDateView(req.getParameter("dataNascimento")));
		aluno.setEmail(req.getParameter("email"));
		aluno.setTelefone(req.getParameter("telefone"));
		System.out.println(aluno);
		AlunoDao alunodao = new AlunoDao();
		
		try {
			alunodao.create(aluno);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}