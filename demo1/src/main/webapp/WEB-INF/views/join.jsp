<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h3>회원가입</h3>
<form action="/join" method="post">
id:<input type="text" name="id"><br/>
pwd:<input type="password" name="pwd"><br/>
name:<input type="text" name="name"><br/>
email:<input type="email" name="email"><br/>
file1:
<input type="text" name="list[0].title">
<input type="text" name="list[0].path"><br/>
file2:
<input type="text" name="list[1].title">
<input type="text" name="list[1].path"><br/>
<input type="submit" value="가입">
</form>
</body>
</html>