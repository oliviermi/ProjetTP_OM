<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<title>All Persons</title>  
</head>  
<body>  
<h1>List Persons</h1>  
<h3><a href="add.html">Add More Persons</a></h3>  
  
<c:if test="${!empty persons}">  
 <table align="left" border="1">  
  <tr>  
   <th>Person ID</th>  
   <th>Person nom</th>  
   <th>Person prenom</th>  
   <th>Person birthdateperson</th>  
  </tr>  
  
  <c:forEach items="${persons}" var="personn">  
   <tr>  
    <td><c:out value="${personn.id}"/></td>  
    <td><c:out value="${personn.nomPerson}"/></td>  
    <td><c:out value="${personn.prenomPerson}"/></td>  
    <td><c:out value="${personn.birthDatePerson}"/></td>  
   </tr>  
  </c:forEach>  
 </table>  
</c:if>  
</body>  
</html> 