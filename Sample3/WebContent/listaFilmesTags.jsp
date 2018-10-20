<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="dao" class="br.com.flf.jdbc.FilmeDAO"/>

<c:forEach var="filme" items="${dao.getFilmes()}">
${filme.titulo}<br>
</c:forEach>

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