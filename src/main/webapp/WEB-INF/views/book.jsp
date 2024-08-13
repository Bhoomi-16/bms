<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book page</title>
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
    .btn-danger {
    background-color: #dc3545; /* Red color for danger */
    color: #fff;
    border: 1px solid #dc3545; /* Border color matches the background */
    padding: 5px 10px;
    border-radius: 4px;
    cursor: pointer;
    text-align: center;
    font-size: 16px;
    font-weight: bold;
    transition: background-color 0.3s ease, border-color 0.3s ease;
}

.btn-danger:hover {
    background-color: #c82333; /* Darker red when hovered */
    border-color: #bd2130;
}

.btn-danger:focus {
    outline: none;
    box-shadow: 0 0 0 2px rgba(220, 53, 69, 0.5); /* Add a focus shadow */
}
    
</style>
</head>
<body>
    <div class="form-container">
        <h2>Book page</h2>
        <form:form action="book.html" method="post" >
            <div class="form-group">
                <form:label path="id">ID:</form:label>
                <form:input path="id"/>
            </div>
            <div class="form-group">
                <form:label path="isbn">ISBN:</form:label>
                <form:input path="isbn"/>
            </div>
            <div class="form-group">
                <form:label path="title">TITLE:</form:label>
                <form:input path="title"/>
            </div>
            
            <div class="form-group">
                <form:label path="category">CATEGORY:</form:label>
                <form:input path="category"/>
            </div>
            <div class="form-group">
                <form:label path="quantity">QUANTITY:</form:label>
                <form:input path="quantity"/>
            </div>
            <input type="submit" value="Add Book"/>
        </form:form>
        
        <hr/>
    
        
        <table>
            <thead>
                <tr>
                    <th>Book ID</th>
                    <th>Book ISBN</th>
                    <th>Book TITLE</th>
                    <th>Book CATEGORY</th>
                    <th>Book QUANTITY</th>
                    <th>actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${BOOK_LIST}" var="b">
                    <tr>
                        <td> <c:out value="${b.id}"/> </td>
                        <td> <c:out value="${b.isbn}"/> </td>
                        <td> <c:out value="${b.title}"/> </td>
                         <td> <c:out value="${b.category}"/> </td>
                        <td> <c:out value="${b.quantity}"/> </td>
                         <td>
                         
                            <a href="updateBook/${b.id}">Update</a>
                            <form action="deleteBook" method="post" style="display:inline;">
                            <input type="hidden" name="id" value="${b.id}"/>
                            <button type="submit" class="btn btn-danger">Delete</button>
                        </form>
                        </td>
                         
                    </tr>
                </c:forEach>
            </tbody>
        </table>
         <div class="Container">
        <a href="index.jsp">Back</a>
    </div>
    </div>
</body>
</html>
