<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="index-head.html" />
<body>
	<c:import url="index-top.html" />

	<jsp:useBean id="dao" class="br.com.flf.jdbc.FilmeDAO" />
	<div class="row">
		<div class="twelve columns">
			<div class="row">
				<div class="ten columns">
					<table width="100%">
					<thead>
							<tr>
								<th>Título</th>
								<th>Gênero</th>
								<th>Duração</th>
								<th>Lançamento</th>
								<th>iMDB</th>
								<th>Opções</th>
							</tr>
						</thead>
						<tbody>
					<c:forEach var="filme" items="${dao.getFilmes()}">
						<tr>
							<td>${filme.titulo}</td>
							<td>${filme.genero}</td>
							<td>${filme.duracao}</td>
							<td><fmt:formatDate pattern = "dd/MM/yyyy" value="${filme.lancamento.time}" /></td>
							<td>${filme.IMDb}</td>
							<td><a href="altera-filme.jsp?id=${filme.id}" target="blank">Alterar</a> - <a href="removeFilme?id=${filme.id}" target="blank">Excluir</a></td>
						</tr>
					</c:forEach>
					</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<br>
	<!-- 
Com datas<br>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:forEach var="filme" items="${dao.getFilmes()}">
${filme.titulo} - 
<fmt:formatDate value="${filme.lancamento.time}" pattern="dd/MM/yyyy" />
<br>
</c:forEach>
 -->
</body>
</html>