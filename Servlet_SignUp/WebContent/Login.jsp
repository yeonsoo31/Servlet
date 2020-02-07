<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script>
	function main(){
		location.href="Main.jsp";
	}
	</script>
</head>
<body>
	<form action="memberlogin" method="post">
	아이디 : <input type="text" name="id" id="id"><br>
	비밀번호 : <input type="password" name="password" id="password"><br>
	<input type="submit" value="로그인">
	</form>
	<button onclick="main()">돌아가기</button>
</body>
</html>