<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function boardDelete(){
		var passConfirm = prompt('비밀번호를 입력하세요');
		var password = '${boardView.bPassword}';
		if(password == passConfirm){
			location.href='boardDelete?bNumber=${boardView.bNumber}';
		} else {
			alert('비밀번호가 틀립니다.');
		}
	}
</script>
</head>
<body>
	<h2>BoardView.jsp</h2>

	글번호 : ${boardView.bNumber}
	작성자 : ${boardView.bWriter}
	작성일자 : ${boardView.bDate}
	글제목 : ${boardView.bTitle}
	조회수 : ${boardView.bHits}
	내용 : ${boardView.bContents}
	파일 : <img src="fileUpload/${boardView.bFile}" width="200" height="200">
	파일명 : ${boardView.bFile}
	<button onclick="location.href='boardList'">글목록</button>
	<button onclick="location.href='boardModify?bNumber=${boardView.bNumber}'">글수정</button>
	<button onclick="boardDelete()">삭제</button>
</body>
</html>