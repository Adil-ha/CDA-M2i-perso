
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <link  href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">>
</head>
<body>
<div class="container">
    <h2>Formulaire de creation d'un produit</h2>
    <form action="product" method="post">
        <div class="form-group">
            <label for="brand">Marque</label>
            <input type="text" class="form-control" id="brand" name="brand" >
        </div>
        <div class="form-group">
            <label for="reference">Reference</label>
            <input type="text" class="form-control" id="reference" name="reference" >
        </div>
        <div class="form-group">
            <label for="reference">Date</label>
            <input type="date" class="form-control" id="date" name="date" >
        </div>

        <div class="form-group">
            <label for="price">Prix</label>
            <input type="number" class="form-control" id="price" name="price">
        </div>

        <div class="form-group">
            <label for="stock">Stock</label>
            <input type="number" class="form-control" id="stock" name="stock">
        </div>

        <div class="form-group">
            <button type="submit" class="btn btn-primary">Creer</button>
        </div>
    </form>
</div>

</body>
</html>
