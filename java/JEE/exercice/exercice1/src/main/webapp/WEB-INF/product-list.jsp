<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
  <title>Détails du Produit</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body class="container">
<h1>Détails du Produit</h1>

<c:if test="${not empty product}">
  <table class="table table-hover rounded border-1">
    <thead>
    <tr class="table-dark">
      <th scope="col">Id Product</th>
      <th scope="col">Marque</th>
      <th scope="col">Reference</th>
      <th scope="col">Date</th>
      <th scope="col">Prix</th>
      <th scope="col">Stock</th>
    </tr>
    </thead>
    <tbody>
    <tr>
      <td>${product.getIdProduct()}</td>
      <td>${product.getBrand()}</td>
      <td>${product.getReference()}</td>
      <td>${product.getDatePurchase()}</td>
      <td>${product.getPrice()}</td>
      <td>${product.getStock()}</td>
    </tr>
    </tbody>
  </table>
</c:if>

<a href="product-list.jsp" class="btn btn-primary">Retour à la liste des produits</a>
</body>
</html>
