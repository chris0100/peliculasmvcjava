<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>CineSite | Bienvenido</title>

    <spring:url value="/resources" var="urlPublic"></spring:url>
    <spring:url value="/" var="urlRoot"></spring:url>

    <link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">

</head>

<body>

<%--se incluye la barra de navegacion en la etqueta para ser llamada--%>
<jsp:include page="includes/menu.jsp"></jsp:include>


<div class="container theme-showcase" role="main">

    <!-- Carousel
  ================================================== -->
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <c:forEach items="${banner}" var="banner" varStatus="loop">
                <c:choose>
                    <c:when test="${loop.index==0}">
                        <li data-target="#myCarousel" data-slide-to="${loop.index}" class="active"></li>
                    </c:when>
                    <c:otherwise>
                        <li data-target="#myCarousel" data-slide-to="${loop.index}"></li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </ol>


        <!-- Image Size 1140 x 250 -->
        <div class="carousel-inner" role="listbox">
            <c:forEach items="${banners}" var="banner" varStatus="loop">
                <c:choose>
                    <c:when test="${loop.index==0}">
                        <div class="item active">
                            <img src="${urlPublic}/images/${banner.archivo}" alt="${banner.titulo}"
                                 title="${banner.titulo}">
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="item">
                            <img src="${urlPublic}/images/${banner.archivo}" alt="${banner.titulo}"
                                 title="${banner.titulo}">
                        </div>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>


        <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div><!-- /.carousel -->


    <div class="row page-header">
        <div class="col-lg-12">
            <h2 class="text text-center"><span class="label label-success">EN CARTELERA</span></h2>
            <form class="form-inline" action="${urlRoot}search" method="post">
                <div class="form-group">
                    <label for="fecha">Fecha: </label>
                    <select id="fecha" name="fecha" class="form-control">
                        <c:forEach items="${listaFechas}" var="fecha">
                            <c:choose>
                                <c:when test="${fecha == fechaBusqueda}">
                                    <option value="${fecha}" selected>${fechaBusqueda}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${fecha}">${fecha}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary">Filtrar</button>
            </form>
        </div>
    </div>


    <!-- Marketing messaging -->
    <div class="container marketing">

        <div class="row">

            <c:forEach items="${peliculas}" var="pelicula">

                <div class="col-xs-12 col-sm-6 col-md-3">
                    <img class="img-rounded" src="${urlPublic}/images/${pelicula.imagen}"
                         alt="Generic placeholder image"
                         width="150" height="200">
                    <h4>${pelicula.titulo}</h4>
                    <h4>
                        <span class="label label-default">${pelicula.clasificacion}</span>
                        <span class="label label-default">${pelicula.duracion}</span>
                        <span class="label label-default">${pelicula.genero}</span>
                    </h4>

                        <%--<p><a class="btn btn-sm btn-primary" href="/detail?idMovie=${pelicula.id}&fecha=${fechaBusqueda}" role="button">Consulta Horarios &raquo;</a></p>--%>
                    <p><a class="btn btn-sm btn-primary" href="/detail/${pelicula.id}/${fechaBusqueda}" role="button">Consulta
                        Horarios &raquo;</a></p>

                </div>

            </c:forEach>

        </div>


        <div class="page-header">
            <h2 class="text text-center"><span class="label label-success">Noticias y novedades</span></h2>
        </div>

        <c:forEach items="${noticias}" var="noticia">
            <div class="row">

                <div class="col-sm-12 blog-main">

                    <div class="blog-post">
                        <h3 class="blog-post-title">${noticia.titulo}</h3>

                        <p class="blog-post-meta"><span class="label label-danger">Publicado: ${noticia.fecha}</span>
                        </p>
                        <p>${noticia.detalle}</p>

                        <hr class="featurette-divider">
                    </div>

                </div>
            </div>
        </c:forEach>


    </div>

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
