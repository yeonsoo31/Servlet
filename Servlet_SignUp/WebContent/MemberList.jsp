<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
td{
width:150px;
height:100px;
border:1px solid black;
}
</style>
</head>
<body>
	<h2>MemberList.jsp 파일</h2>
	<table border="1">
		<tr>
			<th>ID</th><th>PASSWORD</th><th>NAME</th>
			<th>BIRTH</th><th>GENDER</th><th>EMAIL</th>
			<th>상세조회</th><th>회원탈퇴</th>
		</tr>
	<c:forEach var="memberList" items="${memberList}">
		<tr>
			<td>${memberList.id}</td>
			<td>${memberList.password}</td>
			<td>${memberList.name}</td>
			<td>${memberList.birth}</td>
			<td>${memberList.gender}</td>
			<td>${memberList.email}</td>
			<td><a href="memberView?id=${memberList.id}">조회</a></td>
			<td><a href="memberDelete?id=${memberList.id}">삭제</a></td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>