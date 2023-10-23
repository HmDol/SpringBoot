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
<h3>게시글 목록</h3>
<table border="1">
<tr>
<th>글번호</th><th>제목</th><th>내용</th>
</tr>
<c:forEach var="b" items="${list }">
<tr>
<th><a href="/board/edit?num=${b.num }">${b.num } </a></th>
<th>${b.title}</th>
<th>${b.writer }</th>
</tr>
</c:forEach>
</table>
<a href="/board/add">글작성</a>
</body>
</html>