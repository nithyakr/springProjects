<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:useBean id="Book" class="com.springapp.mvc.Book" />

<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>View Book List</title>
</head>
<body>
<center>




    ${booksForm}

    <table>
        <c:forEach items="${booksForm}" var="${Book}"  >
            <tr>
                <%Book.getIsbn(); %>

                <tb>  ${bookD.isbn}</tb>
                <tb>  ${book.title} </tb>
                <tb>  ${book.author} </tb>
                <tb> ${book.genre} </tb>

            </tr>
        </c:forEach>
    </table>



</center>
</body>
</html>