<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Author page</title>
<style>
    body {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
        background-color: #f5f5dc; 
    }
    
    .container {
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            padding: 20px;
        }
        a {
            display: inline-block;
            padding: 5px 10px;
            text-decoration: none;
            font-size: 18px;
            color: #fff;
            background-color: #28a745; 
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }
        a:hover {
            background-color: #218838; 
        }
        
        
        
        
    .form-container {
        text-align: center;
        border: 1px solid #ccc;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        background-color: #ffffff;
    }
    .form-container h2 {
        margin-bottom: 20px;
        color: #333;
    }
    .form-group {
        margin-bottom: 15px;
    }
    .form-group label {
        display: block;
        margin-bottom: 5px;
        color: #555; 
    }
    .form-group input {
        padding: 8px;
        border: 1px solid #ddd;
        border-radius: 4px;
        width: 100%; 
    }
    input[type="submit"] {
        background-color: #28a745; 
        color: #fff;
        border: none;
        padding: 10px 20px;
        border-radius: 4px;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: #218838; 
    }
    table {
        width: 100%;
        border-collapse: collapse;
        background-color: #ffffff; 
        border: 1px solid #ddd;
    }
    th, td {
        padding: 10px;
        text-align: left;
        border: 1px solid #ddd;
    }
    th {
        background-color: #f8f8f8; 
        color: #333; 
    }
    tr:nth-child(even) {
        background-color: #f9f9f9; 
    }
    tr:hover {
        background-color: #f1f1f1; 
    }
</style>
</head>
<body> 
    <div class="form-container">
        <h2>Author page</h2>
        <form:form action="author.html" method="post">
            <div class="form-group">
                <form:label path="name">Name:</form:label>
                <form:input path="name"/>
            </div>
            <div class="form-group">
                <form:label path="email">Email:</form:label>
                <form:input path="email"/>
            </div>
            <div class="form-group">
                <form:label path="bookIsbn">Book ISBN:</form:label>
                <form:input path="bookIsbn"/>
            </div>
            <input type="submit" value="Add Author"/>
        </form:form>
        
        <hr/>
        
        <table>
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Book ISBN</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${AUTH_LIST}" var="author">
                    <tr>
                        <td> <c:out value="${author.name}"/> </td>
                        <td> <c:out value="${author.email}"/> </td>
                        <td> <c:out value="${author.bookIsbn}"/> </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
         <div class ="container">
         <a href="index.jsp">Back</a>
         </div>
    </div>
   
</body>
</html>
