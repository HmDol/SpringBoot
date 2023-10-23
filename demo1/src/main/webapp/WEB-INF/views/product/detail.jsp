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
<table border="1" style="item-align : center">
<tr> <th> 상품번호 </th> <td> ${p.num } </td> </tr>
<tr> <th> 상품이름 </th> <td> ${p.name } </td> </tr>
<tr> <th> 상품가격 </th> <td> ${p.price } </td> </tr>
<tr> <th> 상품수량 </th> <td> ${p.amount } </td> </tr>
<tr> <th> 판매자 </th> <td> ${p.seller } </td> </tr>
<c:if test="${sessionScope.loginId == p.seller }">
<tr> <th> 수정 </th> 
<td> 
<input type="button" value="상품수정" onclick="location.href='/product/edit?num=${p.num}'">
<input type="button" value="상품삭제" onclick="location.href='/product/del?num=${p.num}'"> 
</td> </tr>
</c:if>
</table>
</form>
</body>
</html>