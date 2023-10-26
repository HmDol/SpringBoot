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
<h3>이미지 게시판 목록</h3>
<a href="/imgboard/add">게시글 작성</a>
<table border=1>
<tr> <th>글번호</th> <th>제목</th> <th>작성자</th> </tr>
<c:forEach var="i" items="${list }">
<tr> <td> ${i.num }</td> <td> <a href="/imgboard/detail?num=${i.num}">${i.title }</a></td> <td> ${i.writer.id }</td> </tr> 
</c:forEach>
</table>
</body>
</html>