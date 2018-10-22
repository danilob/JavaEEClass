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

Com datas<br>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:forEach var="filme" items="${dao.getFilmes()}">
${filme.titulo} - 
<fmt:formatDate pattern = "yyyy-MM-dd" value="${filme.lancamento.time}" />
<br>
</c:forEach>


</body>
</html>