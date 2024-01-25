
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Patient ${patient.getId()}</title>
    <jsp:include page="../includes/head.jsp" />
</head>
<body>
<jsp:include page="../includes/header.jsp" />
<div class="container d-flex flex-column justify-content-center h-100 w-50">
    <center>
        <div class="card" style="width: 18rem;">
            <img src="${pageContext.request.contextPath}/imageServlet?id=${patient.getId()}" class="card-img-top img-thumbnail" alt="Photo du patient">
            <div class="card-body">
                <h5 class="card-title">${patient.getFirstName()}</h5>
                <p class="card-text">${patient.getLastName()}</p>
            </div>
            <ul class="list-group list-group-flush">
                <li class="list-group-item">${patient.getDateOfBirth()}</li>
            </ul>
            <div class="card-body">
                <a href="list" class="btn btn-primary">Retour</a>
                <a href="delete?id=${patient.getId()}" class="btn btn-danger">Delete</a>
            </div>

        </div>
    </center>
</div>
</body>
</html>
