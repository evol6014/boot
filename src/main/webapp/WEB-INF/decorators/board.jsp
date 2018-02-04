<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sitemesh" tagdir="/WEB-INF/tags/sitemesh"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><sitemesh:write property="title"/></title>

<link rel="stylesheet" href="/webjars/bootstrap/3.3.7/css/bootstrap.css">
<link rel="stylesheet" href="/webjars/bootstrap/3.3.7/css/bootstrap-theme.css">
<link rel="stylesheet" href="/webjars/animate.css/3.5.2/animate.css">
<script type="text/javascript" src="/webjars/jquery/1.11.1/jquery.js"></script>	
<script type="text/javascript" src="/webjars/bootstrap/3.3.7/js/bootstrap.js"></script>
<script type="text/javascript" src="/webjars/chartjs/2.6.0/Chart.bundle.js"></script>

<sitemesh:write property="head"/>

<c:if test="${false}">
<link rel="stylesheet" href="../css/bootstrap.css">
<link rel="stylesheet" href="../css/bootstrap-theme.css">
</c:if>

</head>
<body class="container">
<header class="page-header">
	<nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="#">WebSiteName</a>
	    </div>
	    <ul class="nav navbar-nav">
	      <li class="active"><a href="#">Home</a></li>
	      <li><a href="http://localhost:8080/depts/list">Depts list</a></li>
	      <li><a href="http://localhost:8080/emps/list">Emps list</a></li>
	      <li><a href="http://localhost:8080/boards/list">Boards list</a></li>
	      <li><a href="http://localhost:8080/bootstrap/list">Bootstrap list</a></li>
	      <li><a href="http://localhost:8080/board/list">Board list</a></li>
	    </ul>
	  </div>
	</nav>
</header>

	<div class="page-header animated bounce jumbotron">
		<h1>
			Boot Project <small>Web Board</small>
		</h1>
	</div>

<section class="panel panel-primary">
		<sitemesh:write property="body"/>
</section>

<footer>Footer</footer>







</body>
</html>