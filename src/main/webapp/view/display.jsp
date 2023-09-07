<%--
  Created by IntelliJ IDEA.
  User: anhph
  Date: 9/6/2023
  Time: 10:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>display</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<table>
    <tr>
        <th>#</th>
        <th>Name</th>
        <th>DateOfBirth</th>
        <th>Email</th>
        <th>Address</th>
        <th>PhoneNumber</th>
        <th>Classroom</th>
        <th colspan="2">Action</th>
    </tr>
    <c:forEach items="${listStudent}" var="e">
        <tr>
            <td>${e.getId()}</td>
            <td>${e.getName()}</td>
            <td>${e.getDOB()}</td>
            <td>${e.getEmail()}</td>
            <td>${e.getAddress()}</td>
            <td>${e.getPhone()}</td>
            <td>${e.getGroup().getName()}</td>
            <td><a href="/student?action=update&id=${e.getId()}">
                <button class="btn btn-warning">Edit</button>
            </a></td>
            <td><a href="/student?action=delete&id=${e.getId()}">
                <button class="btn btn-danger">Delete</button>
            </a></td>
        </tr>
    </c:forEach>
    <a href="/student?action=create">
        <button class="btn btn-primary">Create</button>
    </a>
</table>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>
