<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function boardListPaging(){
//		location.href="boardlistpaging?page=1";
		location.href="boardlistpaging";
	}
</script>
</head>
<body>
	<h2>Main.jsp 파일</h2>
	<button onclick="location.href='boardList'">게시판목록</button>
	<button onclick="boardListPaging()">페이징목록</button>
</body>
</html>