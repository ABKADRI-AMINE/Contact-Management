<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Contact List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        h1 {
            background-color: #333;
            color: #fff;
            text-align: center;
            padding: 20px;
        }

        a.button {
            text-decoration: none;
            background-color: #007bff;
            color: #fff;
            padding: 5px 10px;
            border-radius: 5px;
        }

        a.button:hover {
            background-color: #0056b3;
        }

        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #007bff;
            color: #fff;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        td a {
            text-decoration: none;
            margin-right: 10px;
        }

        td a:hover {
            color: #007bff;
        }

        .center-button {
            text-align: center;
        }
    </style>
</head>
<body>
    <h1>Contact List</h1>
    <div class="center-button">
        <a href="add-contact.jsp" class="button">Add New Contact</a>
    </div>

    <table>
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Prénom</th>
            <th>Numéro de Téléphone</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${contacts}" var="contact">
            <tr>
                <td>${contact.id}</td>
                <td>${contact.nom}</td>
                <td>${contact.prenom}</td>
                <td>${contact.numeroTelephone}</td>
                <td>
                    <a href="update-contact.jsp?id=${contact.id}" class="button">Update</a>
                    <a href="DeleteContactServlet?id=${contact.id}" class="button">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
