<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%  String mensagem = "Bem vindo ao JSP!"; %>
<% out.println(mensagem); %>
<br />
<%  String desenvolvido = "Desenvolvido por Danilo Borges"; %>
<%= desenvolvido %>
<br />
<% System.out.println("Tudo foi executado!"); %>

</body>
</html>