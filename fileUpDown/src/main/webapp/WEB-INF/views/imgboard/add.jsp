<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>이미지 게시글 작성</h3>
<form action="/imgboard/add" method="post" enctype="multipart/form-data">
<table border=1>
<tr> <th>제목</th> <td> <input type="text" name="title"> </td> </tr>
<tr> <th>작성자</th> <td> <input type="text" value="${sessionScope.loginId }" name="writer" readonly	> </td> </tr>
<tr> <th>내용</th> <td> <input type="text" name="content"> </td> </tr>
<tr> <th>사진</th> <td> <input type="file" name="f"> </td> </tr>
<tr> <td colspan=2><input type="submit" value="작성완료"></td> </tr>
</table>
</form>
</body>
</html>