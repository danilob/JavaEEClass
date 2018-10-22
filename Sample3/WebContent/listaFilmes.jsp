<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Listagem de Filmes via JSP</h2><br>
<%@ page import="br.com.flf.jdbc.FilmeDAO" %>
<%@ page import="br.com.flf.models.Filme" %>
<%@ page import="java.util.List" %>
<%FilmeDAO dao = new FilmeDAO();
List<Filme> rows;
try {
	rows = dao.getFilmes();

try {
	out.println("Quantidade de Filmes cadastrados: " + rows.size());
	if (rows.size()>0)
	for (int i = 0; i < rows.size(); i++) {
		out.println("<li> id:"+rows.get(i).getId()+" - "+rows.get(i).getTitulo()+"</li>");
	}
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

} catch (Exception e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
} %>
</body>
</html>