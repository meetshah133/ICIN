<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<table class="table table-striped">
			<caption>Your quizquestions are</caption>
			<thead>
				<tr>
					<th>questionId</th>
					<th>question</th>
					<th>answer</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ques}"  var="todo">
					<tr>
						<td>${todo.id}</td>
						<td>${todo.question}</td>
						<td>${todo.answer}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
</body>
</html>