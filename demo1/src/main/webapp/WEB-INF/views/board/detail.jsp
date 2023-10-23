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
<c:if test="${sessionScope.loginId != b.writer}">
<c:set var="stat">readonly</c:set>
</c:if>
<h3>상세목록</h3>
<form action="/board/edit" method="post">
글번호 : <input type="text" name="num" value="${b.num }" readonly> <br/>
제목: <input type="text" name="title" value="${b.title }" ${stat} > <br/>
내용: <input type="text" name="content" value="${b.content }"${stat} > <br/>
작성자: <input type="text" name="writer" value="${b.writer }" readonly> <br/>
작성일: <input type="text" name="wdate" value="${b.wdate }" readonly> <br/>
<c:if test="${sessionScope.loginId == b.writer}">
<input type="submit" value="수정">
<a href="/board/del?num=${b.num }">삭제</a>
</c:if>
</form>
<a href="/board/list">목록으로</a>
</body>
</html>