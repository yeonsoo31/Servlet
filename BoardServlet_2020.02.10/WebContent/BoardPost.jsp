<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function boardPost(){
		boardPostForm.submit();
	}
</script>
</head>
<body>
	<h2>BoardPost.jsp 파일</h2>
	<form action="boardPost" method="post" name="boardPostForm">
	작성자 : <input type="text" name="bWriter"><br>
	비밀번호 : <input type="password" name="bPassword"><br>
	제목 : <input type="text" name="bTitle"><br>
	내용 : <textarea name="bContents" cols="40" rows="20"></textarea><br>
	</form>
	<button onclick="boardPost()">글등록</button>
	<button onclick="location.href='boardList'">목록</button>
</body>
</html>