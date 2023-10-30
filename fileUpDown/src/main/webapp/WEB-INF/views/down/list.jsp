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
<h3>다운로드ㅡㅡ 목록</h3>

<c:forEach var="f" items="${files }">
<h5><a href="/down/down?fname=${f }">${f }</a></h5>
</c:forEach>

</body>
</html>