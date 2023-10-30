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
		location.href="/imgboard/del?num=${dto.num }";
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
<tr><th>작성자</th><td><input type="text" name="writer" value="${dto.writer.id }" readonly></td></tr>
<tr><th>작성일</th><td><input type="text" value="${dto.wdate }" readonly></td></tr>
<tr><th>제목</th><td><input type="text" name="title" value="${dto.title }" ${str}></td></tr>
<tr><th>내용</th><td><input type="text" name="content" value="${dto.content }" ${str}></td></tr>
<c:if test="${sessionScope.loginId==dto.writer.id }">
<tr><th>이미지 변경</th><td><input type="file" name="f"></td></tr>
</c:if>
<tr><th>이미지</th><td><img src="/imgboard/read-img?fname=${dto.fname }" style="width:150px;height:150px"></td></tr>
<c:if test="${sessionScope.loginId==dto.writer.id }">
<tr><th>편집</th><td><input type="submit" value="수정"><input type="button" value="삭제" id="del"></td></tr>
</c:if>
</table>
</form>
<a href="/imgboard/list">목록으로</a><br/>
</body>
</html>