<%--
  Created by IntelliJ IDEA.
  User: Laura
  Date: 01/02/2024
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Productos</title>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
    <h1>Lista de productos</h1>
    <div class="container" id="main-container">
        <h2>Productos:</h2>
        <ul>
            <c:forEach var="item" items="${storeProducts}">
                <tr>
                    <li>${item.name} - ${item.price} € </li>
                </tr>

            </c:forEach>
        </ul>
    </div>
</body>
</html>
