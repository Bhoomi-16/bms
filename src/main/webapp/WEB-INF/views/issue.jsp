<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Issue Book</title>
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
	background-color: #dc3545; 
	color: #fff;
	border: 1px solid #dc3545;
	padding: 5px 10px;
	border-radius: 4px;
	cursor: pointer;
	text-align: center;
	font-size: 16px;
	font-weight: bold;
	transition: background-color 0.3s ease, border-color 0.3s ease;
}

.btn-danger:hover {
	background-color: #c82333; 
	border-color: #bd2130;
}

.btn-danger:focus {
	outline: none;
	box-shadow: 0 0 0 2px rgba(220, 53, 69, 0.5); 
}
</style>
</head>
<body>
	<div class="form-container">
		<h2>Issue Page</h2>

		<form action="issue.html" method="post">
			<div class="form-group">
				<label for="issuedTo">Issued To:</label> <input type="text"
					id="issuedTo" name="issuedTo" value="${command.issuedTo}" />
			</div>

			<div class="form-group">
				<label for="issueDate">Issue Date:</label> <input type="date"
					id="issueDate" name="issueDate" value="${command.issueDate}" />
			</div>

			<div class="form-group">
				<label for="returnDate">Return Date:</label> <input type="date"
					id="returnDate" name="returnDate" value="${command.returnDate}" />
			</div>

			<div class="form-group">
				<label for="bookId">Book:</label> <select id="bookId" name="bookId">
					<c:forEach items="${BOOK_LIST}" var="book">
						<option value="${book.id}">${book.title}</option>
					</c:forEach>
				</select>
			</div>

			<input type="submit" value="Add Issue" />
		</form>



		<hr />

		<table>
			<thead>
				<tr>
					<th>Issue ID</th>
					<th>Book Title</th>
					<th>Issued To</th>
					<th>Issue Date</th>
					<th>Return Date</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ISSUE_LIST}" var="issue">
					<tr>
						<td><c:out value="${issue.id}" /></td>
						<td><c:out value="${issue.book.title}" /></td>
						<td><c:out value="${issue.issuedTo}" /></td>
						<td><c:out value="${issue.issueDate}" /></td>
						<td><c:out value="${issue.returnDate}" /></td>
						<td><a href="updateIssue/${issue.id}">Update</a>
							<form action="deleteIssue" method="post" style="display: inline;">
								<input type="hidden" name="id" value="${issue.id}" />
								<button type="submit" class="btn btn-danger">Delete</button>
							</form></td>
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
