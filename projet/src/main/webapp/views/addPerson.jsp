<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>  
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
 <head>  
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
  <title>Spring MVC Form Handling</title>  
 </head>  
 <body>  
  <h2>Add Person Data</h2>  
  <form:form method="POST" action="/save.html">  
      <table>  
       <tr>  
           <td><form:label path="id">Person ID:</form:label></td>  
           <td><form:input path="id" value="${person.idperson}" readonly="true"/></td>  
       </tr>  
       <tr>  
           <td><form:label path="nomPerson">Person Name:</form:label></td>  
           <td><form:input path="nomPerson" value="${person.nom}"/></td>  
       </tr>  
       <tr>  
           <td><form:label path="prenomPerson">Person prenom:</form:label></td>  
           <td><form:input path="prenomPerson" value="${person.prenom}"/></td>  
       </tr>  
       <tr>  
           <td><form:label path="birthDatePerson">birthdatePerson:</form:label></td>  
           <td><form:input path="birthDatePerson" value="${person.birthdateperson}"/></td>  
       </tr>  
          <tr>  
         <td colspan="2"><input type="submit" value="Submit"/></td>  
        </tr>  
   </table>    
  </form:form>  
     
  <c:if test="${!empty persons}">  
  <h2>List Person</h2>  
 <table align="left" border="1">  
  <tr>  
   <th>Person ID</th>  
   <th>Person Name</th>  
   <th>Person Age</th>  
   <th>Person Salary</th>  
   <th>Person Address</th>    
           <th>Actions on Row</th>  
  </tr>  
  
  <c:forEach items="${persons}" var="employee">  
   <tr>  
    <td><c:out value="${person.id}"/></td>  
    <td><c:out value="${person.name}"/></td>  
    <td><c:out value="${person.age}"/></td>  
    <td><c:out value="${person.salary}"/></td>  
    <td><c:out value="${person.address}"/></td>  
    <td align="center"><a href="edit.html?id=${person.id}">Edit</a> | <a href="delete.html?id=${person.id}">Delete</a></td>  
   </tr>  
  </c:forEach>  
 </table>  
</c:if>  
 </body>  
</html>  