<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>View Book List</title>
</head>
<body>
<center>




    ${booksForm}

    <table>
        <c:forEach items="${booksForm}" var="bookD"  >
            <tr>

                <tb>  ${bookD.isbn}</tb>
                <tb>  ${bookD.title} </tb>
                <tb>  ${bookD.author} </tb>
                <tb> ${bookD.genre} </tb>

            </tr>
        </c:forEach>
    </table>



</center>


    </body>
</html>
