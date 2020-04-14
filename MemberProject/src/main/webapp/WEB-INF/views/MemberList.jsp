<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
    crossorigin="anonymous"></script>
<script>
	function memberViewAjax(viewId){
		console.log(viewId);
		$.ajax({
			type : "post",
			url : "memberViewAjax",
			data : {"mid" : viewId},
			dataType : "json",
			success : function(result){
				console.log(result);
				console.log(result.mid);
				var output = "<table border='1'>";
				output += "<tr><th>ID</th><th>PASSWORD</th><th>NAME</th><th>BIRTH</th><th>GENDER</th><th>EMAIL</th></tr>";
				output += "<tr>";
				output += "<td>"+result.mid+"</td>";
				output += "<td>"+result.mpassword+"</td>";
				output += "<td>"+result.mname+"</td>";
				output += "<td>"+result.mbirth+"</td>";
				output += "<td>"+result.mgender+"</td>";
				output += "<td>"+result.memail+"</td>";
				output += "</tr>";
				output += "</table>";
				// div 에 output에 담긴 값 출력하기
				$("#memberviewdiv").html(output);
			},
			error : function(){
				console.log("통신실패!");
			} 
		});
	}
</script>
<title>Insert title here</title>
<link type="text/css" rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/table.css">
</head>
<body>
	<h2>MemberList.jsp 파일</h2>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>상세조회</th>
			<th>회원삭제</th>
		</tr>
	<c:forEach var="memberList" items="${memberList}">
		<tr> 
			<td>${memberList.mid}</td>
			<td>${memberList.mname}</td>
			<td><button onclick="memberViewAjax('${memberList.mid}')">상세조회(ajax)</button></td>
			<td><a href="memberView?mid=${memberList.mid}">조회</a></td>
			<td><a href="memberDelete?mid=${memberList.mid}">삭제</a></td>
		</tr>
	</c:forEach>
	</table>
	
	<div id="memberviewdiv">
	
	</div>
	
</body>
</html>