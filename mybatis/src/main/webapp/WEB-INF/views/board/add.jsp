<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h3>글작성</h3>
<form action="/board/add" method="post">
<table border="1">
<tr><th>작성자</th><td><input type="text" name="writer" value="${sessionScope.loginId }" readonly></td></tr>
<tr><th>title</th><td><input type="text" name="title"></td></tr>
<tr><th>content</th><td><textarea rows="10" cols="30" name="content"></textarea></td></tr>
<tr><th>작성</th><td><input type="submit" value="작성"></td></tr>
</table>
</form>
</body>
</html>