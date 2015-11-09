<%@ page autoFlush="true" %>


<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
    <title>
        Add Book Details
    </title>
</head>


<body>
<h3 align="center"> ${message}</h3>
<form:form action="/addBook" method="post" modelAttribute="book">

    <table border="0" align="center">
        <tr>
            <td colspan="2" align="center"><h2>Add Book Details</h2></td>
        </tr>
        <tr>
            <td>ISBN Number:</td>
            <td><form:input path="isbn"/></td>
        </tr>
        <tr>
            <td>Title:</td>
            <td><form:input path="title"/></td>
        </tr>
        <tr>
            <td>Author:</td>
            <td><form:input path="author"/></td>
        </tr>

        <tr>
            <td>Genre:</td>
            <td><form:input path="genre"/></td>
        </tr>


        <tr>
            <td colspan="2" align="center"><input type="submit" name="add" value="Add Book"/></td>
        </tr>
    </table>


</form:form>


</body>
</html>