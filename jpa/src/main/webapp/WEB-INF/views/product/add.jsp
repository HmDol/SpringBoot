<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h3>상품등록</h3>
<form action="/product/add" method="post">
<table border="1">
<tr><th>판매자</th><td><input type="text" name="seller" value="${sessionScope.loginId }" readonly></td></tr>
<tr><th>상품명</th><td><input type="text" name="name"></td></tr>
<tr><th>가격</th><td><input type="number" name="price"></td></tr>
<tr><th>수량</th><td><input type="number" name="amount"></td></tr>
<tr><th>등록</th><td><input type="submit" value="등록"></td></tr>
</table>
</form>
</body>
</html>