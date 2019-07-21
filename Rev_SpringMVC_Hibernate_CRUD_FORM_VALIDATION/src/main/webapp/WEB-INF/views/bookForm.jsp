<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
	<style>
		.error{
		color: red
		}
	</style>

</head>

<body>

<form:form method="post" action="save" modelAttribute="book">
  
  <table>
  	<tr>
  		<td>Title: </td>
  		<td><form:input path="title"  />
  			<form:errors path="title"  cssClass="error"/>
  		 </td> <!--  -->
  	</tr>	
  	<tr>
  		<td>Author: </td>
  		<td><form:input path="author" /> </td>
  	</tr>
  	
  	<tr>
  		<td>Price: </td>
  		<td><form:input path="price" /> 
  			<form:errors path="price" cssClass="error"/>
  		</td>
  	</tr>
  	
  	<tr>
  		<td colspan="2"><input type="submit" value="Save" /> </td>
  	</tr>

  </table>
  
  
  </form:form>



</body>
</html>
