<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="author" content="">
    <title>Creacion de Usuarios</title>

    <spring:url value="/resources" var="urlPublic"></spring:url>
    <spring:url value="/" var="urlRoot"></spring:url>
    <spring:url value="/usuarios/save" var="urlForm"></spring:url>

    <link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
</head>

<body>

<%--se incluye la barra de navegacion en la etqueta para ser llamada--%>
<jsp:include page="../includes/menu.jsp"></jsp:include>

<div class="container theme-showcase" role="main">

    <h3 class="blog-title"><span class="label label-success">Datos del Usuario</span></h3>

    <form:form action="${urlForm}" method="post" modelAttribute="usuario">

<%--        mantiene el id para usuario--%>
        <form:hidden path="id"/>

        <div class="row">
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="perfil" class="control-label">Perfil</label>
                    <select id="perfil" name="perfil" class="form-control">
                        <option value="EDITOR">EDITOR</option>
                        <option value="GERENTE">GERENTE</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="cuenta">Cuenta</label>

                    <c:choose>
                        <c:when test="${usuario.id == 0}">
                            <input type="text" class="form-control" name="cuenta" id="cuenta" required="required"/>
                        </c:when>
                        <c:otherwise>
                            <input type="text" class="form-control" name="cuenta1" id="cuenta" required="required"
                                   disabled placeholder="${usuario.cuenta}" />

                            <form:hidden path="cuenta"/>
                        </c:otherwise>
                    </c:choose>

                </div>
            </div>

            <div class="col-sm-3">
                <div class="form-group">
                    <label for="pwd">Password</label>
                    <form:input type="password" class="form-control" path="pwd" id="pwd" required="required"/>
                </div>
            </div>

            <div class="col-sm-3">
                <div class="form-group">
                    <label for="email">Email</label>
                    <form:input type="text" class="form-control" path="email" id="email" placeholder="Correo electrónico" required="required"/>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="telefono">Teléfono</label>
                    <form:input type="text" class="form-control" path="telefono" id="telefono" required="required"/>
                </div>
            </div>

        </div>

        <button type="submit" class="btn btn-danger" >Guardar</button>
    </form:form>

    <hr class="featurette-divider">

    <!-- FOOTER -->
    <jsp:include page="../includes/footer.jsp"></jsp:include>

</div> <!-- /container -->

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
