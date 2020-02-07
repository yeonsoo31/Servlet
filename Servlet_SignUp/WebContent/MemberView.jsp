<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>MemberView.jsp 파일</h2>
	
	<table border="1">
		<tr>
			<th>ID</th><th>PASSWORD</th><th>NAME</th>
			<th>BIRTH</th><th>GENDER</th><th>EMAIL</th>
		</tr>
		
		<tr>
			<td>${memberView.id}</td>
			<td>${memberView.password}</td>
			<td>${memberView.name}</td>
			<td>${memberView.birth}</td>
			<td>${memberView.gender}</td>
			<td>${memberView.email}</td>
		</tr>
	</table>
</body>
</html>