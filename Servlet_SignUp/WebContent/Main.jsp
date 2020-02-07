<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function login(){
		location.href="Login.jsp";
	}
	function signUp(){
		location.href="SignUp.jsp";
	}
</script>
</head>
<body>
	<h2>Main.jsp 파일</h2>
	<button onclick="login()">로그인</button>
	<button onclick="signUp()">회원가입</button>
</body>
</html>