<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
</head>
<body>
<h2>login page</h2>
<c:if test="${param.ERROR != null}">
<c:out value="${param.ERROR }"></c:out>
</c:if>
<form action="login.html" method="post">
<label>UserID:</label>
<input type="text" name="userId"/>
<label>Password:</label>
<input type="password" name="pwd"/>
<input type="submit" value="login"/>

</form>
</body>
</html>