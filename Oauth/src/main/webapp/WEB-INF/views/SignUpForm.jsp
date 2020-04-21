<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignUpForm</title>
</head>
<body>
	<form action="memberSignUp" method="post" id="memberSignUpForm">
		<table>
		<c:choose>
        	<c:when test="${Gid ne null}">
       	 		<tr>
        			<td>아이디 : <input type="text" name="mid" id="id" onkeyup="idCheck()"><button type="button" onclick="idOverlap()">아이디중복확인</button>&nbsp;&nbsp;<span id="idCheckResult"></span></td>
        			<td><input type="hidden" name="kakaoId" id="kakaodId" value="${Gid}"><br></td>
        		</tr>
        	</c:when>
    	    <c:when test="${Fid ne null}">
	        	<tr>
        			<td>아이디 : <input type="text" name="mid" id="id" onkeyup="idCheck()"><button type="button" onclick="idOverlap()">아이디중복확인</button>&nbsp;&nbsp;<span id="idCheckResult"></span></td>
        			<td><input type="hidden" name="naverId" id="naverId" value="${naverId}"><br></td>
        		</tr>
        	</c:when>
        	<c:otherwise>
			<tr>
				<td>아이디 : <input type="text" name="mid" id="id" onkeyup="idCheck()"><button type="button" onclick="idOverlap()">아이디중복확인</button>&nbsp;&nbsp;<span id="idCheckResult"></span></td>
			</tr>
			<tr>
				<td>비밀번호 : <input type="password" name=mpassword id="password" placeholder="8~16,숫자,대소문자,특문" onkeyup="passwordCheck()">&nbsp;&nbsp;<span id="passwordResult"></span></td>
			</tr>
			<tr>
				<td>비밀번호 확인 : <input type="password" id="passwordDouble" onkeyup="passwordDoubleCheck()">&nbsp;&nbsp;<span id="passwordDoubleCheckResult"></span></td>
			</tr>
			</c:otherwise>
		</c:choose>
			<tr>
				<td>이름 : <input id="name" type="text" name="mname" onkeyup="nameCheck()" maxlength="4">&nbsp;&nbsp;<span id="nameCheck"></span></td>
			</tr>
			<tr>
				<td>생년월일 : <input id="birth" type="date" name="mbirth" onkeyup="birthCheck()">&nbsp;&nbsp;<span id="birthCheck"></span></td>
			</tr>
			<tr>
				<td>주소 : <input type="text" id="sample6_postcode" name="maddress1" placeholder="우편번호">&nbsp;<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br></td>
			</tr>
			<tr>
				<td><input type="text" id="sample6_address" name="maddress2" placeholder="주소">
				<input type="text" id="sample6_detailAddress" name="maddress3" placeholder="상세주소">
				<input type="text" id="sample6_extraAddress" name="maddress4" placeholder="참고항목"></td>
			</tr>
			<tr>
				<td>핸드폰 : <input id="phone" name="mphone" type="text" onkeyup="phoneCheck()">&nbsp;&nbsp;<span id="phoneCheck"></span></td>
			</tr>
			<tr>
				<td>이메일 : <input id="email" name="memail" type="text" onkeyup="emailCheck()">&nbsp;&nbsp;<span id="emailCheck"></span></td>
			<tr>
			<tr>
				<td>프로필사진 : <input type="file" name="mprofilepic"></td>
			</tr>
			
		</table>
		<input type="submit" value="회원가입">
		<input type="reset" value="다시작성">
		<button type="button" onclick="location.href='main'">이전으로</button>
	</form>
</body>
</html>