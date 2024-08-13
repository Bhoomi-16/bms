<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Issue</title>
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
		<h2>Update Issue</h2>
		<form:form action="/dms/updateIssue" method="post"
			modelAttribute="command">

			<form:hidden path="id" />


			<form:hidden path="book.id" />

			<div class="form-group">
				<form:label path="issuedTo">Issued To:</form:label>
				<form:input path="issuedTo" />
			</div>

			<div class="form-group">
				<form:label path="issueDate">Issue Date:</form:label>
				<form:input path="issueDate" type="date" />
			</div>

			<div class="form-group">
				<form:label path="returnDate">Return Date:</form:label>
				<form:input path="returnDate" type="date" />
			</div>

			<div class="form-group">
				<form:label path="book.id">Book:</form:label>
				<form:select path="book.id">
					<form:options items="${BOOK_LIST}" itemValue="id" itemLabel="title" />
				</form:select>
			</div>

			<input type="submit" value="Update Issue" />
		</form:form>

	</div>
	
	
</body>
</html>
