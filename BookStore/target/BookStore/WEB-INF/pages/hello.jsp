<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
	<h1>${message}</h1>

	<form:form  action="Books" method="post" commandName="booksForm">
		<input type="submit" name="add" value="Add Books"   />
		<input type="submit" name="view" value="View Books" />
	</form:form>


</body>
</html>