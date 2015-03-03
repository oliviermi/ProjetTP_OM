<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>

<body>
	<h2>Spring's form tags example</h2>

	<form:form method="POST" commandName="customer">

		<form:errors path="*" cssClass="errorblock" element="div" />

		<table>
			<tr>
				<td>Nom :</td>
				<td><form:input path="userName" /></td>
				<td><form:errors path="userName" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Prénom :</td>
				<td><form:textarea path="address" /></td>
				<td><form:errors path="address" cssClass="error" /></td>
			</tr>

			<%-- <form:hidden path="secretValue" /> --%>

			<tr>
				<td colspan="3"><input type="submit" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>