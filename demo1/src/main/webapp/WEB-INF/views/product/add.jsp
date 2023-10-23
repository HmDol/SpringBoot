<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/product/add" method="post">
<table border="1" style="item-align : center">
<tr> <th> 상품이름 </th> <td> <input type="text" name="name"> </td> </tr>
<tr> <th> 상품가격 </th> <td> <input type="text" name="price"> </td> </tr>
<tr> <th> 상품수량 </th> <td> <input type="text" name="amount"> </td> </tr>
<tr> <th> 판매자 </th> <td> <input type="text" name="seller" value="${sessionScope.loginId }" readonly> </td> </tr>
<tr> <th> 등록 </th> <td> <input type="submit" value="상품등록"> </td> </tr>
</table>
</form>
</body>
</html>