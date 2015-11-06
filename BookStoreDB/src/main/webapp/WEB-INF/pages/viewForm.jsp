<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>View Book List</title>
</head>

<body>
<h1> All the Books in the Books Store</h1>

<br>

<table align="center" border="2" width="60%">
    <tr align="center">

        <td> ISBN Number</td>
        <td> Title</td>
        <td> Author</td>
        <td> Genre</td>
    </tr>


    <c:forEach items="${booksForm}" var="bookD">
        <tr>

            <td> ${bookD.isbn}</td>
            <td> ${bookD.title} </td>
            <td> ${bookD.author} </td>
            <td> ${bookD.genre} </td>
        </tr>

    </c:forEach>

</table>
<p align="center">
    <a href="/">Home</a>

</p>

</body>
</html>
