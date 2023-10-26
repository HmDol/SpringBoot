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
<h3>상세 게시글</h3>
<c:if test="${sessionScope.loginId!=i.writer.id }">
<c:set var="str">readonly</c:set>
</c:if>
<a href="/imgboard/list" >목록으로</a>
<form action="/imgboard/edit" method="post"	enctype="multipart/form-data">
<table border=1	>
<tr> <th>글번호</th> <td><input type="text" name="num" value="${i.num }" readonly></td>  </tr>
<tr> <th>글제목</th> <td ><input type="text" name="title" value="${i.title }" ${str}></td>  </tr>
<tr> <th>사진</th> <td><img src="/imgboard/read-img?fname=${i.fname }" style="height:400px"></td>  </tr>
<c:if test="${sessionScope.loginId == i.writer.id}">
<tr> <th>사진변경</th> <td><input type="file" name="f"></td>  </tr>
</c:if>
<tr> <th>내용</th> <td><input type="text" name="content" value="${i.content }" ${str}></td>  </tr>
<tr> <th>작성자</th> <td><input type="text" name="wrtier" value="${i.writer.id }" readonly></td>  </tr>
<tr> <th>작성일</th> <td><input type="text" name="wdate" value="${i.wdate }" readonly></td>  </tr>
</table>
<c:if test="${sessionScope.loginId == i.writer.id}">
<br>
<input type="submit" id="edit"value="수정"> <input type="button" value="삭제" onclick="location.href='/imgboard/del?num=${i.num}'"> 
</c:if>
</form>
</body>
</html>