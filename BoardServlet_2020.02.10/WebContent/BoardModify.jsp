<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script>
		function boardModify(){
			var password = '${boardModify.bPassword}';
			var passConfirm = document.getElementById("bPassword").value;
			if(password == passConfirm){
				modifyForm.submit();
			} else {
				alert('비밀번호가 틀립니다!!');
			}
		}
	</script>
</head>
<body>
	<h2>BoardModify.jsp 파일</h2>
	<form action="modifyProcess" method="post" name="modifyForm">
		글번호 : <input type="text" name="bNumber" value="${boardModify.bNumber}" readonly><br>
		비밀번호 : <input type="password" name="bPassword" id="bPassword" value="${boardModify.bPassword}"><br>
		제목 : <input type="text" name="bTitle" value="${boardModify.bTitle}"><br>
		작성자 : <input type="text" name="bWriter" value="${boardModify.bWriter}"><br>
		내용 : <textarea rows="20" cols="50" name="bContents">${boardModify.bContents}</textarea><br>
	</form>
	<button onclick="boardModify()">수정</button>
</body>
</html>