<%--
  Created by IntelliJ IDEA.
  User: anhph
  Date: 9/6/2023
  Time: 11:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>edit</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h2>Edit student</h2>
<form method="post">
    Name<br>
    <input type="text" name="name" placeholder="Enter name" value="${name}"><br>
    <small style="color:red;">${messageErrorName}</small><br>
    Email<br>
    <input type="text" name="email" placeholder="Enter email" value="${email}"><br>
    <small style="color:red;">${messageErrorEmail}</small><br>
    DateOfBirth<br>
    <input type="date" name="DOB" placeholder="Enter date of birth" value="${DOB}"><br>
    <small style="color:red;">${messageErrorEmail}</small><br>
    Address<br>
    <input type="text" name="address" placeholder="Enter address" value="${address}"><br>
    <small style="color:red;">${messageErrorAddress}</small><br>
    PhoneNumber<br>
    <input type="text" name="phone" placeholder="Enter phone number" value="${phone}"><br>
    <small style="color:red;">${messageErrorPhone}</small><br>
    Classroom<br>
    <select name="classroom">
        <c:forEach items="${groupList}" var="p">
            <option value="${p.getId()}">${p.getName()}</option>
        </c:forEach>
    </select><br>
    <input class="btn btn-primary" type="submit" value="Submit">
</form>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>
