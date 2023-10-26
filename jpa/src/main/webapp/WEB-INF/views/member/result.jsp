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
<center>
<h3>로그인 성공</h3>
<table border="1">
	<tr> <th> ${sessionScope.loginId } 님 로그인</th>
	<tr> 
	<td style="width : 300px;">
		<a href="/member/get?id=${sessionScope.loginId }">내정보 </a><br/>
		<a href="/member/del?id=${sessionScope.loginId }">탈퇴 </a><br/>
		<a href="/member/logout">로그아웃</a><br/>
		<a href="/board/list">글목록</a><br/>
		<a href="/product/list">상품목록</a><br/>
		<a href="/guestbook/list">방명록</a><br/>
	</td>
</table>
</center>

</body>
</html>