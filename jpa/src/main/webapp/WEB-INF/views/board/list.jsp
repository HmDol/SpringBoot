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
<h3>글목록</h3>
<a href="/board/add">글작성</a><br/>
<table border="1">
<tr><th>글번호</th><th>제목</th><th>작성자</th></tr>
<c:forEach var="b" items="${list }">
<tr><td>${b.num }</td>
<td><a href="/board/edit?num=${b.num }">${b.title }</a></td><td>${b.writer.id }</td>
</c:forEach>
</table>
</body>
</html>