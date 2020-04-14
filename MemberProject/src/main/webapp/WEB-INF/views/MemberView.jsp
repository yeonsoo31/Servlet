<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<td>${memberView.mid}</td>
			<td>${memberView.mpassword}</td>
			<td>${memberView.mname}</td>
			<td>${memberView.mbirth}</td>
			<td>${memberView.mgender}</td>
			<td>${memberView.memail}</td>
	</table>
</body>
</html>