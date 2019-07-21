<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to book list</h1>
	
	<table border="2" width = "70%" cellpadding="2">
		<thead>
			<tr>
				<th>ID</th>
				<th>TITLE</th>
				<th>AUTHOR</th>
				<th>PRICE</th>
			
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="book" items="${list}">
			  <tr>
			  <td>${book.id}</td>
			  <td>${book.title}</td>
			  <td>${book.author}</td>
			  <td>${book.price}</td>
			  </tr>
			  </c:forEach>	
		</tbody>
	
	</table>

</body>
</html>