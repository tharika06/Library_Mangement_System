<%@ page import="com.wipro.book.bean.BookBean" %>

<%
    BookBean book =
        (BookBean) request.getAttribute("book");
       
%>

<html>
<body>

<h2>Book Details</h2>

<table border="1">

<tr>
    <th>Book Name</th>
    <th>Author Name</th>
</tr>

<tr>
     <td><%= book.getBookName() %></td>
    <td><%= book.getAuthor().getAuthorName() %></td>
</tr>

</table>

</body>
</html>