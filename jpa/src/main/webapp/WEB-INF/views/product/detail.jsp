<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#amount").change(function(){
		//let price = parseInt($("#price").val());
		let payment = $("#price").val() * $("#amount").val();
		$("#res").text(payment);
	});
});
</script>
</head>
<body>
<h3>상세페이지</h3>
<table border="1">
<tr><th>상품명</th><td>${p.name }</td></tr>
<tr><th>판매자</th><td>${p.seller.id }</td></tr>
<tr><th>가격</th><td><input type="number" id="price" name="price" value="${p.price }" readonly></td></tr>
<tr><th>주문수량</th><td><input type="number" id="amount" name="amount"></td></tr>
<tr><th>결제금액</th><td><span id="res">0</span>원</td></tr>
<tr><th>주문</th><td><input type="button" value="즉시결제"><input type="button" value="장바구니"></td></tr>
</table>
</body>
</html>