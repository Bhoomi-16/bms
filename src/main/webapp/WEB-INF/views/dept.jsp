<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Department page</title>
</head>
<body>
    <h2>Department page</h2>
    <form:form action="dept.html" method="post">
        <form:input path="deptId"/>
        <br/>
        <form:input path="deptName"/>
         <br/>
        <input type="submit" value="create"/>
    </form:form>
    
    <hr/>

    <table border ="1">
        <thead>
            <tr>
                <td>Dept ID</td>
                <td>Dept Name</td>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${DEPT_LIST}" var="d">
                <tr>
                    <td> <c:out value="${d.deptId}"/> </td>
                    <td> <c:out value="${d.deptName}"/> </td>
                </tr>
            </c:forEach>
        </tbody>
    </table> 

    <%-- 
    <form action="dept.html" method="post">
        <input type="text" name="deptId"/> <br/>
        <input type="text" name="deptName"/> <br/>
        <input type="submit" value="create"/>
    </form> 
    --%>
</body>
</html>
