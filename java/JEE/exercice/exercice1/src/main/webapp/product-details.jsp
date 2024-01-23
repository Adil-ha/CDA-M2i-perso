<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Détails du Produit</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body class="container">
<h1>Détails du Produit</h1>

<div class="card">
    <div class="card-body">
        <h5 class="card-title">Marque: ${product.getBrand()}</h5>
        <p class="card-text">Référence: ${product.getReference()}</p>
        <p class="card-text">Date d'achat: ${product.getDatePurchase()}</p>
        <p class="card-text">Prix: ${product.getPrice()}</p>
        <p class="card-text">Stock: ${product.getStock()}</p>
    </div>
</div>

<div class="mt-3">
    <a href="deleteProduct?id=${product.getIdProduct()}" class="btn btn-danger">Supprimer</a>
    <a href="/exercice1/product" class="btn btn-primary">Retour à la liste des produits</a>
</div>
</body>
</html>

