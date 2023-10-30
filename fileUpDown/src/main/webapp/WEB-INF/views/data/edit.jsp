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
	$("#del").click(function(){
		location.href="/data/del?num=${dto.num }";
	});
	$("#data").click(function(){
		location.href="/data/updatecnt?num=${dto.num }";
	});
});
</script>
</head>
<body>
<h3>상세페이지</h3>
<c:if test="${sessionScope.loginId!=dto.writer.id }">
<c:set var="str">readonly</c:set>
</c:if>
<form action="/imgboard/edit" method="post" enctype="multipart/form-data">
<table border="1">
<tr><th>글번호</th><td><input type="text" name="num" value="${dto.num }" readonly></td></tr>
<tr><th>제목</th><td><input type="text" name="title" value="${dto.title }" ${str}></td></tr>
<tr><th>작성자</th><td><input type="text" name="writer" value="${dto.writer.id }" readonly></td></tr>
<tr><th>자료</th><td><a id="#data" href="/data/down?fname=${dto.fname }" name="fname">${dto.fname }</a></td></tr>
<c:if test="${sessionScope.loginId==dto.writer.id }">
<tr><th>자료 변경</th><td><input type="file" name="f"></td></tr>
</c:if>
<tr><th>자료설명</th><td><input type="text" name="content" value="${dto.content }" ${str}></td></tr>
<tr><th>작성일</th><td><input type="text" name="wdate" value="${dto.wdate }" readonly></td></tr>
<tr><th>다운로드 수</th><td><input type="text" name="cnt" value="${dto.cnt }" readonly></td></tr>
<c:if test="${sessionScope.loginId==dto.writer.id }">
<tr><th>편집</th><td><input type="submit" value="수정"><input type="button" value="삭제" id="del"></td></tr>
</c:if>
</table>
</form>
<a href="/data/list">목록으로</a><br/>
</body>
</html>