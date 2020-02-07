<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원정보입력</h2>
<form action="signUp" method="post">
	아이디 : <input type="text" name="id" id="id"><br>
	비밀번호 : <input type="password" name="password" id="password"><br>
	이름 : <input type="text" name="name" id="name"><br>
	생년월일 : <input type="date" name="birth" id="birth"><br> 
	성별 : 
		<input type="radio" name="gender" value="남" checked="checked">남자
		<input type="radio" name="gender" value="여">여자<br>
	이메일 : <input type="text" name="email" id="email"><br>
	<input type="submit" value="회원가입">
	<input type="reset" value ="다시작성">
</form>
</body>
</html>