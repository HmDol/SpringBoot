<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>로그인 성공</h3>
<table border="1">
	<tr>  <th> ${sessionScope.loginId } 님 로그인</th>
	<tr> 
	<td style="width : 300px;">
		<a href="/member/get?id=${sessionScope.loginId }">내정보 </a><br/>
		<a href="/member/del?id=${sessionScope.loginId }">탈퇴 </a><br/>
		<a href="/member/logout">로그아웃</a><br/>
		<a href="/imgboard/list">이미지 게시판</a><br/>
		<a href="/data/list">다운로드 게시판</a><br/>
	
</table>


</body>
</html>