<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Book</title>
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
            padding: 10px 10px;
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
        <h2>Update Book</h2>
        <form action="/dms/updateBook" method="get" modelAttribute="book">
    <input type="hidden" name="id" value="${book.id}"/>
    <div class="form-group">
        <label for="isbn">ISBN:</label>
        <input type="text" id="isbn" name="isbn" value="${book.isbn}" Readonly/>
    </div>
    <div class="form-group">
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" value="${book.title}"/>
    </div>
    <div class="form-group">
        <label for="category">Category:</label>
        <input type="text" id="category" name="category" value="${book.category}"/>
    </div>
    <div class="form-group">
        <label for="quantity">Quantity:</label>
        <input type="text" id="quantity" name="quantity" value="${book.quantity}"/>
    </div>
    <input type="submit" value="Update Book"/>
</form>
        
    </div>
    
</body>
</html>
