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
		location.href="/board/del?num=${b.num }";//url /board/del로 삭제요청. 삭제할 글번호를 파라메터 num으로 보냄
	});
});
</script>
</head>
<body>
<c:if test="${sessionScope.loginId != b.writer.id}">
<c:set var="stat">readonly</c:set>
</c:if>
<h3>글 상세페이지</h3>
<form action="/board/edit" method="post">
<table border="1">
<tr><th>글번호</th><td><input type="text" name="num" value="${b.num }" readonly></td></tr>
<tr><th>작성일</th><td><input type="text" value="${b.wdate }" readonly></td></tr>
<tr><th>작성자</th><td><input type="text" value="${b.writer.id }" readonly></td></tr>
<tr><th>title</th><td><input type="text" name="title" value="${b.title }" ${stat }></td></tr>
<tr><th>content</th><td><textarea rows="10" cols="30" name="content"  ${stat }>${b.content }</textarea></td></tr>
<c:if test="${sessionScope.loginId == b.writer.id}">
<tr><th>편집</th><td><input type="submit" value="수정"><input type="button" id="del" value="삭제"></td></tr>
</c:if>
</table>
</form>
</body>
</html>