<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Bienvenido!!</title>

    <spring:url value="/resources" var="urlPublic"></spring:url>
    <spring:url value="/" var="urlRoot"></spring:url>

    <link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">

</head>

<body>

<%--se incluye la barra de navegacion en la etqueta para ser llamada--%>
<jsp:include page="includes/menu.jsp"></jsp:include>

<div class="container theme-showcase" role="main">

    <div class="jumbotron">
        <h3>Administracion del Sistema</h3>
        <p>Bienvenido(a) <sec:authentication property="principal.username"/> </p>
    </div>



</div> <!-- /container -->

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>
<script>
    function goBack() {
        window.history.back();
    }
</script>
</body>
</html>
