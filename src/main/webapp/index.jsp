<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book Management System</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5dc;
            margin: 0;
            padding: 0;
        }
        header {
            background-color: #007bff;
            color: #fff;
            padding: 20px 0;
            text-align: center;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            margin-bottom: 20px;
        }
        header h1 {
            margin: 0;
            font-size: 2.5em;
            font-weight: bold;
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
            padding: 10px 20px;
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
    </style>
</head>
<body>
    <header>
        <h1>Book Management</h1>
    </header>
    <div class="container">
        <a href="book.html">Book List</a>
    </div> 
      <div class="container">
        <a href="student.html">Student List</a>
    </div>
    </div> 
      <div class="container">
        <a href="author.html">Author List</a>
    </div> 
     <div class="container">
     <a href="searchBooks.html">Search Books</a>
    </div> 
    <div class="container">
     <a href="issue.html">Issue Books</a>
    </div> 
        

</body>
</html>
