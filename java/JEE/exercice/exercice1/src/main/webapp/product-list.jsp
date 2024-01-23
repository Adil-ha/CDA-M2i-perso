<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link  href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">>
</head>
<body class="container">
<h1>La liste des produits</h1>
<table class="table table-hover rounded border-1">

    <thead >
    <tr class="table-dark">
        <th scope="col">Id Product</th>
        <th scope="col">Marque</th>
        <th scope="col">Reference</th>
        <th scope="col">Date</th>
        <th scope="col">Prix</th>
        <th scope="col">Stock</th>
        <th scope="col">Choix</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.getIdProduct()}</td>
            <td>${product.getBrand()}</td>
            <td>${product.getReference()}</td>
            <td>${product.getDatePurchase()}</td>
            <td>${product.getPrice()}</td>
            <td>${product.getStock()}</td>
            <td>
                <a href="deleteProduct?id=${product.getIdProduct()}" class="btn btn-danger">Supprimer</a>
                <a href="productDetails?id=${product.getIdProduct()}" class="btn btn-primary">Details</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

