<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function boardModify(){
		modifyForm.submit();
	}
	function boardList(){
		location.href="boardList";
	}
</script>
</head>
<body>
<body>
	<form action="boardModify" method="post" name="modifyForm">
		글번호 : <input type="text" name="bnumber" value="${modifyForm.bnumber}" readonly><br>
		제목 : <input type="text" name="btitle" value="${modifyForm.btitle}"><br>
		작성자 : <input type="text" name="bwriter" value="${modifyForm.bwriter}"><br>
		내용 : <textarea rows="20" cols="50" name="bcontents">${modifyForm.bcontents}</textarea><br>
	</form>
	<button onclick="boardModify()">수정</button>
	<button onclick="boardList()">글목록</button>
</body>
</html>