<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Produits</title>
    <jsp:include page="../includes/head.jsp" />

</head>
<body>
<jsp:include page="../includes/header.jsp"/>
<div class="container mt-4">
    <center>
        <h2>Liste des patients </h2>
    </center>
    <div class="m-4">
        <a href="new" class="btn btn-success text-start">Add patient </a>
    </div>


    <center>
        <table border="1" cellpadding="5" class="table table-dark text-center" >
            <caption><h2>List of Patients</h2></caption>
            <tr>
                <th>Id</th>
                <th>Image</th>
                <th>Firstname</th>
                <th>Lastname</th>
                <th>Date of Birth</th>
                <th >Actions</th>
            </tr>
            <c:choose>
                <c:when test="${patients != null}">
                    <c:forEach items="${patients}" var="patient">
                        <tr>
                            <td>${patient.getId()}</td>
                            <td> <img src="${pageContext.request.contextPath}/imageServlet?id=${patient.getId()}" class="img-thumbnail" style="width: 50px;height: 50px;" alt="Photo du patient"></td>
                            <td>${patient.getFirstName()}</td>
                            <td>${patient.getLastName()}</td>
                            <td>${patient.getDateOfBirth()}</td>
                            <td>
                                <a href="delete?id=${produit.getId()}" class="btn btn-danger">Delete</a>
                                <a href="details?id=${produit.getId()}" class="btn btn-primary">Detail</a>
                            </td>
                        </tr>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <tr><td colspan="6">Aucun patient disponible.</td></tr>
                </c:otherwise>
            </c:choose>

        </table>
    </center>
</div>


</body>
</html>
