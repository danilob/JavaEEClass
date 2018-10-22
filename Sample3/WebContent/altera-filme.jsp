<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- paulirish.com/2008/conditional-stylesheets-vs-css-hacks-answer-neither/ -->
<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]>    <html class="no-js lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]>    <html class="no-js lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang="en"> <!--<![endif]-->
<head>
  <meta charset="utf-8" />

  <!-- Set the viewport width to device width for mobile -->
  <meta name="viewport" content="width=device-width" />

  <title>Welcome to Foundation</title>

  <!-- Included CSS Files -->
  <link rel="stylesheet" href="stylesheets/foundation.css">
  <link rel="stylesheet" href="stylesheets/app.css">

  <!--[if lt IE 9]>
    <link rel="stylesheet" href="stylesheets/ie.css">
  <![endif]-->

  <script src="javascripts/modernizr.foundation.js"></script>

  <!-- IE Fix for HTML5 Tags -->
  <!--[if lt IE 9]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
  <![endif]-->

</head>

<body>
	<div class="row">
		<div class="twelve columns">
		<p align="center"><h2>Java para Web!</h2></p>
		</div>
	</div>
	
	<div class="row">
		<div class="twelve columns">
			<ul class="nav-bar">
 		 		<li class="active"><a href="/Sample3">Home</a></li>
  				<li><a href="adiciona-filme.html">Adicionar Filme</a></li>
  				<li><a href="listar-filme.jsp">Listar Filmes</a></li>
  				<li><a href="pesquisa-filme.jsp">Pesquisar Filmes</a></li>
  				<!--li><a href="#">Contact Us</a></li-->
			</ul>
			
		</div>
	</div>
		
	<div class="row">
		<div class="twelve columns">
			<div class="row">
				<div class="eight columns">
					<jsp:useBean id="dao" class="br.com.flf.jdbc.FilmeDAO" />
				    ${dao.getFilme(param.id).titulo}
				<h4>Alteração de Filme</h4>
				<form action="alteraFilme">
				<!-- hide data form action="adicionaFilme" method="post" -->
				        <input type="hidden" name="id" value="${dao.getFilme(param.id).id}"/>
				
        Título: <input type="text" name="titulo" value="${dao.getFilme(param.id).titulo}"/>
        Gênero: <input type="text" name="genero" value="${dao.getFilme(param.id).genero}"/>
        Duração (min): <input type="number" name="duracao" value="${dao.getFilme(param.id).duracao}"/>
        IMDb: <input type="number" step="any" name="imdb" value="${dao.getFilme(param.id).IMDb}"/>
        Lançamento: <input type="text" name="lancamento" value="${dao.getFilme(param.id).getLancamentoDate()}"/>
        <input type="submit" value="Gravar" />
    </form>				
				</div>
		
				<div class="four columns">
					
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="twelve columns">
		<hr />
		
		</div>
	</div>
</body>
</html>
