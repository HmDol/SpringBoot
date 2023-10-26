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
<h3>파일업로드 목록</h3>

<c:forEach var="f" items="${files }">
<img src="/test/read-img?fname=${f }" style="width:150px; heigtht:150px;"><br>
</c:forEach>

</body>
</html>