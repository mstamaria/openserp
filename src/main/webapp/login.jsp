<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>

<html>
<head>
<title>Login</title>
</head>

<body>
	<h1>Login</h1>

	<c:if test="${not empty param.error}">
		<font color="red"> Your login attempt was not successful, try
			again.<br />
		<br /> Reason: <c:out
				value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />.
		</font>
	</c:if>

	<form name="f" action="<c:url value='j_spring_security_check'/>"
		method="POST">
		<table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='j_username' /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='j_password'></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value='Login'></td>
			</tr>
		</table>
	</form>
</body>
</html>