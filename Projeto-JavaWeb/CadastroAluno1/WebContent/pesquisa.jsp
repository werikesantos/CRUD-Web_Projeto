<%@page import="br.com.cadastroalunos.model.Aluno"%>
<%@page import="java.util.List"%>
<%@page import="br.com.cadastroalunos.dao.AlunoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Pesquisar Cadastros</title>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	padding: 5px;
	text-align: left;
}
</style>
</head>
<body>
	
	<h2>BASE DE DADOS</h2>
	<form action="pesquisa.jsp"  method="get">
	
	<label>Pesquisar: </label>
	<input name="Pesquisa" type="text" >
	
	</form>
	
	<form action="" method="get">	
		<label>Deletar: </label>
		<input name="Deletar" type="text" >
	</form>
	
	<%AlunoDao alunoDeletar = new AlunoDao();
	alunoDeletar.delete(request.getParameter("Deletar"));
	%>
	
	<table style="width: 100%">
		<tr>
			<th>Nome</th>
			<th>Endereço</th>
			<th>E-mail</th>
			<th>Telefone</th>
			<th>Data de Nascimento</th>
		</tr>
		<%
			AlunoDao dao = new AlunoDao();
			String nome = request.getParameter("Pesquisa");
			List<Aluno> listaAlunos = dao.findByName(nome);
			for (Aluno aluno : listaAlunos) {
		%>
		<tr>
			<td><%=aluno.getNome()%></td>
			<td><%=aluno.getEndereco()%></td>
			<td><%=aluno.getEmail()%></td>
			<td><%=aluno.getTelefone()%></td>
			<td><%=aluno.getDataNascimento()%></td>
		</tr>
		<%
			}
		%>
	</table>

</body>
</html>