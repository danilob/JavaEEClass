<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="index-head.html" />
<body>
	<c:import url="index-top.html" />

	<jsp:useBean id="dao" class="br.com.flf.jdbc.FilmeDAO" />
	<div class="row">
		<div class="twelve columns">
			<div class="row">
				<div class="eight columns">

					<c:forEach var="filme" items="${dao.getFilmes()}">
						${filme.titulo}<br>
					</c:forEach>
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