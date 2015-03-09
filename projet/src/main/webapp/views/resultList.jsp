<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
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
					<td><c:out value="${personn.id}" /></td>
					<td><c:out value="${personn.nomPerson}" /></td>
					<td><c:out value="${personn.prenomPerson}" /></td>
					<td><c:out value="${personn.birthDatePerson}" /></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<h3>Has been ${action}</h3>
</body>
</html>