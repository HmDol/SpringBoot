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
<h3>회원목록</h3>
<c:forEach var="m" items="${list }">
<a href="/member/get?id=${m.id }">${m.id } </a>
/ ${m.pwd } / ${m.name }/ ${m.email }<br/>
</c:forEach>
</body>
</html>