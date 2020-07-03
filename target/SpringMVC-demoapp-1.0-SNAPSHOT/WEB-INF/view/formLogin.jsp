<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Login</title>

    <spring:url value="/resources" var="urlPublic"></spring:url>
    <spring:url value="/" var="urlRoot"></spring:url>

    <link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
    <link href="${urlPublic}/bootstrap/css/signin.css" rel="stylesheet">

</head>

<body>

<%--se incluye la barra de navegacion en la etqueta para ser llamada--%>
<jsp:include page="includes/menu.jsp"></jsp:include>





<div class="container theme-showcase" role="main">
    <hr class="featurette-divider">
    <img src="${urlPublic}/images/login.png" width="136" height="136" class="center">

    <form class="form-signin" action="${urlRoot}login" method="post">

        <c:if test="${param.error!= null}">
            <div class="text-center">
                <img src="${urlPublic}/images/error.png" width="48" height="48" class="center">
                <h4 class="form-signin-heading text-center" style="color: red;">Acceso Denegado</h4>
            </div>

        </c:if>

        <h3 class="form-signin-heading">CineSite | Administracion</h3>
        <label for="username" class="sr-only">Usuario</label>
        <input type="text" id="username" name="username" class="form-control" placeholder="Usuario" required autofocus>
        <label for="password" class="sr-only">Contraseña</label>
        <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
    </form>

</div> <!-- /container -->
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="${urlPublic}/bootstrap/js/bootstrap.min.js" ></script>
</body>
</html>
