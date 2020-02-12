<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>MailForm.jsp 파일</h2>
	
	
	<form action="mailSend" method="post">
	보내는 사람 : <input type="text" name="sender">
	받는 사람 : <input type="text" name="receiver">
	제목 : <input type="text" name="title">
	내용 : <textarea name="contents" cols="40" rows="30"></textarea>
	
	<input type="submit" value="메일전송">
	
	</form> 
</body>
</html>