<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function selectDB(){
	location.href="selectDB";
}
</script>
</head>
<body>
<h2>저장 성공.</h2>
<h2>DB 내용 조회하기</h2>
<a href="selectDB">DB 조회 링크</a>
<button onclick="selectDB()">DB 조회</button>

</body>
</html>