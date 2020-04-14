<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Main.jsp 파일</h2>
	<a href='signUp'">회원가입</a>
	<a href='login'">로그인</a>
	
	<h3>카카오로 회원가입</h3>
	<a href="kakaojoin">
		<img src="${pageContext.request.contextPath}/resources/img/kakao_account_login_btn_large_narrow.png">
	</a>
	
	<h3>네이버로 회원가입</h3>
	<a href="naverjoin">
		<img width="450" height="100" src="${pageContext.request.contextPath}/resources/img/네이버 아이디로 로그인_아이콘형_Green.PNG">
	</a>
	
</body>
</html>