<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>방명록 작성</h3>
<form action="/guestbook/add" method="post">
작성자 : <input type="text" name="writer" value="${sessionScope.loginId }"> 
내용 :  <input type="text" name="content">
<input type="submit" value="작성 완료">
</form> 
</body>
</html>