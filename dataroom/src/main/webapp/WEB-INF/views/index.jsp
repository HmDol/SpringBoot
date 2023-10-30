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
<c:if test="${empty sessionScope.loginId }">
<a href="/member/login">로그인</a><br/>
<a href="/member/join">회원가입</a><br/>
</c:if>
<c:if test="${not empty sessionScope.loginId }">
<a href="/member/get?id=${sessionScope.loginId }">내정보 </a>
<a href="/member/del?id=${sessionScope.loginId }">탈퇴 </a>
<a href="/member/logout">로그아웃</a><br/>
<h3>자료실</h3>
<a href="/data/add">글작성</a><br/>
<form action="/data/getbyfname" method="post">
파일종류로 검색: 
<select name="type">
<option>jpg</option>
<option>pdf</option>
<option>txt</option>
<option>exe</option>
<option>zip</option>
</select>
<input type="submit" value="검색" id="search">
</form>
<table border="1">
<tr><th>제목</th><th>파일명</th><th>작성자</th><th>다운로드수</th></tr>
<c:forEach var="f" items="${list }">
<tr><td>${f.title }</td><td><a href="/data/detail?num=${f.num }">${f.fname }</a></td><td>${f.writer.id }</td><td>${f.cnt }</td></tr>
</c:forEach>
</table>
</c:if>
</body>
</html>