<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
<script>
	function boardPost(){
		boardPostForm.submit();
	}
	
</script>
</head>
<body>
	<form action="boardPost" method="post" name="boardPostForm"
	enctype="multipart/form-data">
	작성자 : <input type="text" name="bwriter"><br>
	제목 : <input type="text" name="btitle"><br>
	내용 : <textarea name="bcontents" cols="40" rows="20"></textarea><br>
	첨부파일 : <input type="file" name="bfile">
	</form>
	<button onclick='boardPost()'>글등록</button>
	<button onclick="location.href='boardList'">목록</button>
</body>
</html>