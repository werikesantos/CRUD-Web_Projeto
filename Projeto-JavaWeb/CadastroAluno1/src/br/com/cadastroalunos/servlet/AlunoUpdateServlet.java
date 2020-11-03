package br.com.cadastroalunos.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cadastroalunos.model.Aluno;
import br.com.cadastroalunos.utils.AlunoUtil;

@WebServlet (urlPatterns = "/AlunoUpdateServelet")
public class AlunoUpdateServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		super.doPost(req, resp);
		
		Aluno aluno = new Aluno();
		
		aluno.setNome(req.getParameter("nome"));
		aluno.setDataNascimento(AlunoUtil.convertToStringToDateView(req.getParameter("dataNascimento")));
		aluno.setEmail(req.getParameter("email"));
		aluno.setTelefone(req.getParameter("telefone"));
		aluno.setEndereco(req.getParameter("endereco"));
		
	}
}
