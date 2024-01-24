<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <title></title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light shadow-lg">
    <a class="navbar-brand" href="#">Mes produits</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="product">Home <span class="sr-only">(current)</span></a>
            </li>
            <% if (request.getAttribute("isAuthenticated") != null && (Boolean) request.getAttribute("isAuthenticated")) { %>
            <li class="nav-item">
                <a class="nav-link" href="product-form.jsp">Add</a>
            </li>
            <% } %>
            <li class="nav-item">
                <a class="nav-link" href="#">Amazon</a>
            </li>
        </ul>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item mr-3">
                <a class="nav-link btn-info rounded" href="logging.jsp">Connexion</a>
            </li>
            <li class="nav-item">
                <a class="nav-link btn-danger rounded" href="product?action=logout">Déconnexion</a>
            </li>
        </ul>
    </div>
</nav>
</body>
</html>
