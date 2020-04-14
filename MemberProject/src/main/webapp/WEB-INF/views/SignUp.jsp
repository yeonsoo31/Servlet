<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
    crossorigin="anonymous"></script>
<title>회원가입</title>
<script>
	function idOverlap(){
		var inputId = document.getElementById("id").value;
		var checkResult = document.getElementById("checkResult");
		// ajax(Asynchronous javascript and XML) 사용
		// 서버로 데이터 전송 시  JSON(JavaScript Object Notation) 사용
		$.ajax({
			type : "post",
			url : "idOverlap",
			data : {"mid" : inputId},
			dataType : "text",
			success : function(result){
				console.log("통신 성공!!");
				console.log("서버리턴값"+result);
				if(result=="OK"){
					//alert("사용가능한 ID 입니다!");
					checkResult.style.color="green";
					checkResult.innerHTML="사용가능한 ID 입니다!";
				} else {
					//alert("이미 사용중인 ID 입니다!")
					checkResult.style.color="red";
					checkResult.innerHTML="이미 사용중인 ID 입니다!";
				}
			},
			error : function(){
				console.log("통신 실패!!")
				alert("통신 실패!!");
			} 
		});
		
	}
</script>
</head>
<body>
<h2>SignUp.jsp 파일</h2>
	<form action="memberJoin" method="post" id=memberJoinForm>
        	카카오 아이디 : ${kakaoId}
	<table>
        <c:choose>
        	<c:when test="${kakaoId ne null}">
       	 		<tr>
        			<td>아이디 : <input type="text" name="mid" id="id" onkeyup="idOverlap()"><span id="checkresult"></span></td>
        			<td><input type="hidden" name="kakaoId" id="kakaodId" value="${kakaoId}"><br></td>
        		</tr>
        	</c:when>
    	    <c:when test="${naverId ne null}">
	        	<tr>
        			<td>아이디 : <input type="text" name="mid" id="id" onkeyup="idOverlap()"><span id="checkresult"></span></td>
        			<td><input type="hidden" name="naverId" id="naverId" value="${naverId}"><br></td>
        		</tr>
        	</c:when>
        	<c:otherwise>
        		<tr>
        			<td>아이디 : <input type="text" name="mid" id="id" onkeyup="idOverlap()"><span id="checkresult"></span></td>
        			<td>비밀번호 : <input type="password" name="mpassword" id="password"></td>
        		</tr>
        	</c:otherwise>
        </c:choose>
            <!-- <td>아이디</td>
            <td><input type="text" name="mid" id="id" onkeyup="idOverlap()">
            <span id = "checkResult"></span>
            </td>
        </tr>
        <tr class="passwordtr">
        	<td>비밀번호</td>
        	<td><input type="password" name="mpassword" id="password"></td>
        </tr> -->
		<tr>
			<td>이름 : <input type="text" name="mname" id="name"></td>
		</tr>
		<tr>
			<td>생년월일 : <input type="date" name="mbirth" id="birth"></td>
		</tr>
		<tr>
			<td>성별 : <input type="radio" name="mgender" value="남" checked="checked">남자
			<input type="radio" name="mgender" value="여">여자</td>
		</tr>
		<tr>
			<td>이메일 : <input type="email" name="memail" id="email"></td>
		</tr>
	</table>
		<input type="submit" value="회원가입">
		<input type="reset" value="다시작성">
	</form>
	<button onclick="idOverlap()">아이디중복확인</button>
</body>
</html>