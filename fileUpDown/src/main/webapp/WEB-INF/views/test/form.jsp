<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>업로드</h3>
<form action="/test/upload" method="post" enctype="multipart/form-data">
title: <input type="text" name="title"><br>
file: <input type="file"	name="f"><br>
<input type="submit" value="저장">
</form>
</body>
</html>