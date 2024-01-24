<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Formulaire de création/modification d'un produit</title>
    <link  href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<jsp:include page="./header.jsp"/>
<main class="container">
    <h2>Formulaire de création/modification d'un produit</h2>
    <form action="${productToUpdate.idProduct != null ? "": "product"}" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id" value="${productToUpdate.idProduct}">

        <div class="form-group">
            <label for="brand">Marque</label>
            <input type="text" class="form-control" id="brand" name="brand" value="${productToUpdate.brand}">
        </div>

        <div class="form-group">
            <label for="reference">Référence</label>
            <input type="text" class="form-control" id="reference" name="reference" value="${productToUpdate.reference}">
        </div>

        <div class="form-group">
            <label for="date">Date</label>
            <input type="date" class="form-control" id="date" name="date" value="${productToUpdate.datePurchase}">
        </div>

        <div class="form-group">
            <label for="price">Prix</label>
            <input type="number" class="form-control" id="price" name="price" value="${productToUpdate.price}">
        </div>

        <div class="form-group">
            <label for="stock">Stock</label>
            <input type="number" class="form-control" id="stock" name="stock" value="${productToUpdate.stock}">
        </div>

        <div class="form-group">
            <label for="image">Image</label>
            <input type="file" class="form-control" id="image" name="image">


            <c:if test="${not empty productToUpdate.imagePath}">
                <img src="${productToUpdate.imagePath}" alt="Product Image" style="max-width: 50px; max-height: 50px;">
            </c:if>
        </div>


        <button type="submit" class="btn btn-primary">${productToUpdate.idProduct != null ? 'Mettre à jour' : 'Créer'}</button>
    </form>
</main>
</body>
</html>

