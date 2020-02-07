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
	<h2>MemberModify.jsp 파일</h2>
	<form action="memberModify?id=${sessionScope.loginId}" method="post">
	아이디 : <input type="text" name="id" id="id" value="${sessionScope.loginId}" readonly><br>
	비밀번호 : <input type="password" name="password" id="password"><br>
	이메일 : <input type="text" name="email" id="email"><br>
	<input type="submit" value="수정">
	<input type="reset" value ="다시작성">
	</form>
	<button onclick="main()">메인화면</button>
</body>
</html>