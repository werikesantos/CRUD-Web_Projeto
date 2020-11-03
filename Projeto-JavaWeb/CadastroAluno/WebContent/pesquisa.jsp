<%@page import="br.com.cadastroalunos.model.Aluno"%>
<%@page import="java.util.List"%>
<%@page import="br.com.cadastroalunos.dao.AlunoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta charset="UTF-8"/>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
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
	
	<h1 class="badge badge-pill badge-dark">BASE DE DADOS</h1>
	<form action="pesquisa.jsp"  method="get">
	
	<label class="badge badge-pill badge-dark">Pesquisar: </label>
	<input name="Pesquisa" type="text" >
	
	</form>
	
	<form action="" method="get">	
		<label class="badge badge-pill badge-dark">Deletar: </label>
		<input name="Deletar" type="text" >
	</form>
	
	<%AlunoDao alunoDeletar = new AlunoDao();
	alunoDeletar.delete(request.getParameter("Deletar"));
	%>
	
	<table class="table" style="width: 50%">
	<thead class="thead-dark">
		<tr>
			<th scope="col">Nome</th>
			<th scope="col">Endereço</th>
			<th scope="col">E-mail</th>
			<th scope="col">Telefone</th>
			<th scope="col">Data de Nascimento</th>
		</tr>
	<thead>
	
		<%
			AlunoDao dao = new AlunoDao();
			String nome = request.getParameter("Pesquisa");
			List<Aluno> listaAlunos = dao.findByName(nome);
			for (Aluno aluno : listaAlunos) {
		%>
		
		<tbody>
		<tr>
			<td><%=aluno.getNome()%></td>
			<td><%=aluno.getEndereco()%></td>
			<td><%=aluno.getEmail()%></td>
			<td><%=aluno.getTelefone()%></td>
			<td><%=aluno.getDataNascimento()%></td>
		</tr>
		<tbody>
		
		<%
			}
		%>
	</table>
	
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    
</body>
</html>