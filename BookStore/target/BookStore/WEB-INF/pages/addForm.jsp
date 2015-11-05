<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<h1>${message}</h1>

<form:form  action="/BookStore/addBook" method="post" commandName="booksForm">

    <table border="0">
        <tr>
            <td colspan="2" align="center"><h2>Spring MVC Form Demo - Registration</h2></td>
        </tr>
        <tr>
            <td>ISBN Number:</td>
            <td><form:input path="isbn" /></td>
        </tr>
        <tr>
            <td>Title:</td>
            <td><form:password path="title" /></td>
        </tr>
        <tr>
            <td>Author:</td>
            <td><form:input path="author" /></td>
        </tr>

        <tr>
            <td>Genre:</td>
            <td><form:select path="genre" items="${genreList}" /></td>
        </tr>


        <tr>
            <td colspan="2" align="center"><input type="submit" name="add" value="Add Book" /></td>
            <td colspan="2" align="center"><input type="submit" name="reset" value="Add Book" /></td>
        </tr>
    </table>


</form:form>




</body>
</html>