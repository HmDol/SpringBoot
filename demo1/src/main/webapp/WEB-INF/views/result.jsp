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
<h3>회원가입 성공</h3>
${m.id } / ${m.pwd } / ${m.name }/ ${m.email }<br/>
<c:forEach var="f" items="${m.list }">
${f.title } / ${f.path }<br/>
</c:forEach>
</body>
</html>