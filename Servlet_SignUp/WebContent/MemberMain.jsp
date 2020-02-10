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
		location.href="MemberModify.jsp";
	}
	</script>
</head>
<body>
<h2>${sessionScope.loginId}님 환영합니다.</h2>

<c:if test="${sessionScope.loginId eq 'admin'}">
<a href="memberList">회원목록조회</a>
</c:if>

<button onclick="memberModify()">회원정보수정</button>
<button onclick="logout()">로그아웃</button>

</body>
</html>