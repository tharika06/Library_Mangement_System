<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>view</title>
</head>
<body>
<form method="post" action="MainServlet">
Enter ISBN:<input type="text" name="isbn"><br><br>
<input type="hidden" name="operation" value="Search">
<button type="submit">Search Book</button>
</form>
</body>
</html>