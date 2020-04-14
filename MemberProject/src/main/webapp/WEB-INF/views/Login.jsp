<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h2>Login.jsp 파일</h2>
	<form action="memberLogin" method="post" id=loginForm>
	<table class="loginC">
        <tr class="idtr">
            <td>아이디</td>
            <td><input type="text" name="mid" id="id"></td>
        </tr>
        <tr class="passwordtr">
        	<td>비밀번호</td>
        	<td><input type="password" name="mpassword" id="password"></td>
        </tr>
    </table>
    <button onclick="submit">로그인</button>
    </form>
    <button onclick="location.href='signUp'">회원가입</button>
	<h3>카카오로 로그인</h3>
	<a href="kakaologin">
		<img src="${pageContext.request.contextPath}/resources/img/kakao_account_login_btn_large_narrow.png">
	</a>
	
	<h3>네이버로 로그인</h3>
	<a href="naverlogin">
		<img width="450" height="100" src="${pageContext.request.contextPath}/resources/img/네이버 아이디로 로그인_완성형_Green.PNG">
	</a>
</body>
</html>