<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"
    integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
    crossorigin="anonymous"></script>
<script>
	$(document).ready(function(){
		$("#commentWriteBtn").click(function(){
			var cwriter = $("#cwriter").val();
			console.log(cwriter);
			var ccontents = $("#ccontents").val();
			var cbnumber = "${boardView.bnumber}";
			$.ajax({
				type : "post",
				url : "commentwrite",
				data : {
						"cwriter" : cwriter,
						"ccontents" : ccontents,
						"cbnumber" : cbnumber},
				dataType : "json",
				success : function(result){
					console.log("댓글 등록 성공");
					var output = "<table border='1'>";
					output += "<tr><th>작성자</th>"
					output += "<th>내용</th></tr>"
					//포이치문
					for(var i in result){
						output += "<tr>";
						output += "<td>" + result[i].cwriter + "</td>";
						output += "<td>" + result[i].ccontents + "</td>";
						output += "</tr>";
					}
					output += "</table>";
					$("#commentArea").html(output);
					$("#cwriter").val("");
					$("#ccontents").val("");
					
				},
				error : function(){
					console.log("통신 실패");
				}
			})
		});
	});
</script>
</head>
<body>
	<h2>BoardView.jsp</h2>

	글번호 : ${boardView.bnumber}
	작성자 : ${boardView.bwriter}
	작성일자 : ${boardView.bdate}
	글제목 : ${boardView.btitle}
	조회수 : ${boardView.bhits}
	내용 : ${boardView.bcontents}
	<button onclick="location.href='boardList'">글목록</button>
	<button onclick="location.href='modifyForm?bnumber=${boardView.bnumber}'">글수정</button>
	<button onclick="location.href='boardDelete?bnumber=${boardView.bnumber}'">삭제</button>
	
	<div id="commentWrite">
		<input type="text" id="cwriter">
		<textarea rows="5" cols="20" id="ccontents"></textarea>
		<button id="commentWriteBtn">댓글입력</button>
	</div>
	
	<div id="commentArea">
		<table border="1">
		<tr><th>작성자</th>
			<th>내용</th></tr>
			<c:forEach items="${commentList}" var="comment">
				<tr>
					<td>${comment.cwriter}</td>
					<td>${comment.ccontents}</td></tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>