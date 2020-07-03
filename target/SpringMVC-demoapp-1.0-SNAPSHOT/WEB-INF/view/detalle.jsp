<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>Detalles de la pelicula</title>

	<spring:url value="/resources" var="urlPublic"></spring:url>
	<spring:url value="/" var="urlRoot"></spring:url>

	<link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">

</head>

<body>

<%--se incluye la barra de navegacion en la etqueta para ser llamada--%>
<jsp:include page="includes/menu.jsp"></jsp:include>

<div class="container theme-showcase" role="main">

	<!-- Marketing messaging -->
	<div class="container marketing">

		<div class="page-header">
			<h2>${pelicula.titulo}</h2>
		</div>
		<div class="row">
			<div class="col-sm-3">
				<p class="text-center">
					<img class="img-rounded" src="${urlPublic}/images/${pelicula.imagen}" alt="Generic placeholder image" width="155" height="220">
				</p>
			</div>
			<div class="col-sm-9">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">DETALLES</h3>
					</div>
					<div class="panel-body">
						<p>
							Titulo Original : ${pelicula.titulo} <br>
							Actores : ${pelicula.detalle.actores}  <br>
							Director:  ${pelicula.detalle.director}<br>
							Clasificacion: ${pelicula.clasificacion} <br>
							Duracion: ${pelicula.duracion} <br>
							Genero: ${pelicula.genero} <br>
							Fecha Estreno: <span><fmt:formatDate pattern="dd-MM-yyyy" value="${pelicula.fechaEstreno}"/></span>

						</p>

					</div>
				</div>
			</div>
		</div>

		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title"><span class="label label-success">${fechaBusqueda}</span></h3>
			</div>
			<div class="panel-body">
				<table class="table table-striped">
					<thead>
					<tr>
						<th>Hora</th>
						<th>Sala</th>
						<th>Precio</th>
					</tr>
					</thead>
					<tbody>
					<c:forEach items="${horarios}" var="horario">
						<tr>
							<td>${horario.hora}</td>
							<td>${horario.sala}</td>
							<td>${horario.precio}</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>


		<div class="row">
			<div class="col-sm-7">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Trailer</h3>
					</div>
					<div class="panel-body">
						<iframe width="100%" height="315"
								src="${pelicula.detalle.trailer}">
						</iframe>
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">SINOPSIS</h3>
					</div>
					<div class="panel-body">
						<p>${pelicula.detalle.sinopsis}</p>
					</div>
				</div>
			</div>
		</div>

	</div><!-- /.container -->

	<hr class="featurette-divider">

	<!--footer-->
	<jsp:include page="includes/footer.jsp"></jsp:include>

</div> <!-- /container -->

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>
