<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/product/edit" method="post">
<table border="1" style="item-align : center">
<tr> <th> 상품번호 </th> <td> <input tpye="text" value="${p.num }" readonly>  </td> </tr>
<tr> <th> 상품이름 </th> <td> <input tpye="text" value="${p.name }" readonly> </td> </tr>
<tr> <th> 상품가격 </th> <td> <input tpye="text" value="${p.price }">  </td> </tr>
<tr> <th> 상품수량 </th> <td> <input tpye="text" value="${p.amount }">  </td> </tr>
<tr> <th> 판매자 </th> <td> <input tpye="text" value="${p.seller }" readonly> </td> </tr>
<tr> <td colspan="2"> <input type="submit" value="수정완료"> </td> </tr>
</table>
</form>
</body>
</html>