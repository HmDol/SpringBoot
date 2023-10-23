<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>회원정보</h3>
<form action="/member/edit" method="post">
id: <input type="text" name="id" value="${m.id }" readonly> <br/>
pwd: <input type="text" name="pwd" value="${m.pwd }"> <br/>
name: <input type="text" name="name" value="${m.name }"><br/>
email: <input type="text" name="email" value="${m.email }" readonly><br/>
<input type="submit" value="수정">
<a href="/member/del?num=${m.num }">삭제</a>
</form>
<a href="/member/list">목록으로</a>
</body>
</html>