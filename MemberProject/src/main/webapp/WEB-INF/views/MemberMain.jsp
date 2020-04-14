<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function logout(){
		location.href="memberLogout";
	}
	function memberModify(){
		location.href="memberModify";
	}
</script>
</head>
<body>
	<h2>MemberMain.jsp</h2>
	로그인 완료
	${sessionScope.loginId} 님 환영합니다.
	${kakaoProfile}
	<h1>${nickName}</h1>
	<img src="${thumbnail}">
	<c:if test="${sessionScope.loginId eq 'admin'}">
		<a href="memberList">회원 목록 조회</a>
	</c:if>
	<button onclick="memberModify()">회원 정보 수정</a>
	<button onclick="logout()">로그아웃</button>
	
</body>
</html>