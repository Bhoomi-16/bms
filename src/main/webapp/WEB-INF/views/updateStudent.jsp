<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Student</title>
<style>
    body {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
        background-color: #f5f5dc;
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
</style>
</head>
<body>
    <div class="form-container">
        <h2>Update Student</h2>
        <form action="/dms/updateStudent" method="get" modelAttribute="student">
            <input type="hidden" name="usn" value="${student.usn}"/>
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" value="${student.name}"/>
            </div>
            <input type="submit" value="Update Student"/>
        </form>
    </div>
</body>
</html>
