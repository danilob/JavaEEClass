<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="br.com.flf.models.Filme" %>
<%@ page import="java.util.List" %>
<c:import url="index-head.html" />
<body>
	<c:import url="index-top.html" />

	<jsp:useBean id="dao" class="br.com.flf.jdbc.FilmeDAO" />
	<div class="row">
		<div class="twelve columns">
			<div class="row">
				<div class="eight columns">

					<form action="pesquisaFilme">
Chave de pesquisa: <input type="text" name="key" />
<button type="submit" value="Submit">Search</button> 
</form>
<%
if(request.getAttribute("lista_req")!=null){
	
	List<Filme> filmes = (List) request.getAttribute("lista_req");
	for (Filme filme : filmes ) {
		out.println("<li> id:"+filme.getId()+" - "+filme.getTitulo()+"</li>");
	}
}
%>

				</div>
			</div>
		</div>
	</div>
	<br>
	<!-- 
Com datas<br>


<c:forEach var="filme" items="${dao.getFilmes()}">
${filme.titulo} - 
<fmt:formatDate value="${filme.lancamento.time}" pattern="dd/MM/yyyy" />
<br>
</c:forEach>
 -->
</body>
</html>