<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>개시글 작성</h3>
<form action="/board/add" method="post">
title:<input type="text" name="title"><br/>
작성자:<input "type="text" value="${sessionScope.loginId }"name="writer"><br/>
content:<input style="width : 200px; height: 200px;"type="text" name="content"><br/>
<input type="submit" value="작성">
</form>
</body>
</html>