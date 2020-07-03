<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sprin" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Listado de Usuarios</title>


    <spring:url value="/resources" var="urlPublic"></spring:url>
    <spring:url value="/" var="urlRoot"></spring:url>
    <spring:url value="/usuarios/create" var="urlCreate"></spring:url>
    <spring:url value="/usuarios/edit" var="urlEdit"></spring:url>
    <spring:url value="/usuarios/delete" var="urlDelete"></spring:url>

    <link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">

</head>

<body>

<%--se incluye la barra de navegacion en la etqueta para ser llamada--%>
<jsp:include page="../includes/menu.jsp"></jsp:include>

<div class="container theme-showcase" role="main">

    <h3>Listado de Usuarios</h3>


    <%--    MENSAJE DE CREACION EXITOSA DE PELICULA--%>
    <c:if test="${mensaje != null}">
        <div class="alert alert-success" role="alert ">${mensaje}</div>
    </c:if>



    <a href="${urlCreate}" class="btn btn-success" role="button" title="Nueva Pelicula" >Nueva</a><br><br>

    <div class="table-responsive">
        <table class="table table-hover table-striped table-bordered">
            <tr>
                <th>Cuenta</th>
                <th>password</th>
                <th>Activo</th>
                <th>Email</th>
                <th>telefono</th>
                <th>Perfil</th>
                <th>Opciones</th>
            </tr>

            <c:forEach items="${usuarios}" var="usuario">
                <tr>
                    <td>${usuario.cuenta}</td>
                    <td><span style="display:block;text-overflow: ellipsis;width: 200px;overflow: hidden; white-space: nowrap;">${usuario.pwd}</span></td>

                    <c:choose>
                        <c:when test="${usuario.activo == 1 }">
                            <td>Activa</td>
                        </c:when>
                        <c:otherwise>
                            <td>Inactiva</td>
                        </c:otherwise>
                    </c:choose>

                    <td>${usuario.email}</td>
                    <td>${usuario.telefono}</td>
                    <td>${usuario.perfil}</td>

                    <td>
                        <a href="${urlEdit}/${usuario.id}" class="btn btn-success btn-sm" role="button" title="Edit" ><span class="glyphicon glyphicon-pencil"></span></a>
                        <a href="${urlDelete}/${usuario.id}" onclick='return confirm("¿Esta seguro?")' class="btn btn-danger btn-sm" role="button" title="Eliminar" ><span class="glyphicon glyphicon-trash"></span></a>
                    </td>
                </tr>
            </c:forEach>

        </table>
    </div>

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
