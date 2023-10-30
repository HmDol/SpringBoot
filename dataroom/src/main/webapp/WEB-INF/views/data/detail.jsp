<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#down").click(function(){
		let win = window.open("downpage?fname=${data.fname}&num=${data.num}", "win", "width=500,height=300");
	});
});
</script>
</head>
<body>
<h3>자료 페이지</h3>
<c:if test="${sessionScope.loginId!=data.writer.id }">
<c:set var="str">readonly</c:set>
</c:if>
<form action="/data/edit" method="post" enctype="multipart/form-data">
<table border="1">
<tr><th>글번호</th><td><input type="text" name="num" value="${data.num }" readonly></td></tr>
<tr><th>작성자</th><td><input type="text" name="writer" value="${data.writer.id }" readonly></td></tr>
<tr><th>작성일</th><td><input type="text" value="${data.wdate }" readonly></td></tr>
<tr><th>제목</th><td><input type="text" name="title" value="${data.title }" ${str}></td></tr>
<tr><th>내용</th><td><input type="text" name="content" value="${data.content }" ${str}></td></tr>
<c:if test="${sessionScope.loginId==data.writer.id }">
<tr><th>파일 변경</th><td><input type="file" name="f"></td></tr>
</c:if>
<tr><th>자료</th><td>${data.fname }<input type="button" id="down" value="다운로드"></td></tr>
<tr><th>다운수</th><td>${data.cnt }</td></tr>
<c:if test="${sessionScope.loginId==data.writer.id }">
<tr><th>편집</th><td><input type="submit" value="수정"><input type="button" value="삭제" id="del"></td></tr>
</c:if>
</table>
</form>
<a href="/data/list">목록으로</a><br/>
</body>
</html>