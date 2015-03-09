<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring MVC Form Handling</title>
</head>
<body>

	<h2>Add Person Data</h2>
	<form:form method="POST" action="/save.html">

		<fmt:formatDate value="${person.birthDatePerson}" type="date"
			pattern="dd/MM/yyyy" var="theFormattedDate" />

		<table>
			<tr>
				<td><form:label path="id">Person ID:</form:label></td>
				<td><form:input path="id" value="${person.id}" readonly="true" /></td>

			</tr>
			<tr>
				<td><form:label path="nomPerson">Person Name:</form:label></td>
				<td><form:input path="nomPerson" value="${person.nomPerson}" /></td>
				<td>${errors['nomPerson']}</td>

			</tr>
			<tr>
				<td><form:label path="prenomPerson">Person prenom:</form:label></td>
				<td><form:input path="prenomPerson"
						value="${person.prenomPerson}" /></td>
				<td><span class="errors"> ${errors['prenomPerson']}</span></td>
			</tr>
			<tr>
				<td><form:label path="birthDatePerson">birthdatePerson:</form:label></td>
				<td><form:input path="birthDatePerson"
						value="${theFormattedDate}" /></td>
				<td><span class="errors">${errors['birthDatePerson']}</span></td>
			</tr>
			<%-- <tr>
				<td><form:label path="listFriend">listFriend:</form:label></td>
				<td><form:input path="listFriend" value="${listFriend}" /></td>
				<td><span class="errors">${errors['listFriend']}</span></td>
			</tr> --%>
			<tr>
				<td colspan="3"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>

	<c:if test="${!empty persons}">
		<h2>List Person</h2>
		<table align="left" border="1">
			<tr>
				<th>Person ID</th>
				<th>Person nom</th>
				<th>Person prenom</th>
				<!-- <th>Person Friends</th> -->
				<th>Person birthdate</th>
				<th>Actions on Row</th>
			</tr>

			<c:forEach items="${persons}" var="personn">
			
			<fmt:formatDate value="${personn.birthDatePerson}" type="date"
			pattern="dd/MM/yyyy" var="theFormattedDate2Thereturnoftheexpected" />
			
				<tr>
					<td><c:out value="${personn.id}" /></td>
					<td><c:out value="${personn.nomPerson}" /></td>
					<td><c:out value="${personn.prenomPerson}" /></td>
					<%-- <td><c:out value="${personn.listFriend}" /></td> --%>
					<td><c:out value="${theFormattedDate2Thereturnoftheexpected}" /></td>
					<td align="center"><a href="edit.html?id=${personn.id}">Edit</a>
						| <a href="delete.html?id=${personn.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>
