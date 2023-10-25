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
	$("#f").hide();
	$(".editForm").click(function(){
		let num = $(this).attr("num");
		$.ajax({
			url:"/product/getjson",
			type:"post",
			data:{"num":num},
			dataType:'json',
			success: function(res){//res: 받은 응답
				$("#num").val(res.num);
				$("#seller").val(res.seller);
				$("#name").val(res.name);
				$("#price").val(res.price);
				$("#amount").val(res.amount)
				$("#f").show();
			},
			error: function(){
				alert("error");
			}
		});
	});
	$("#cancel").click(function(){
		$("#f").hide();
	});
	$("#edit").click(function(){
		let num = $("#num").val();
		let seller = $("#seller").val();
		let name = $("#name").val();
		let price = $("#price").val();
		let amount = $("#amount").val();
		$.ajax({
			url:"/product/edit",
			type:"post",
			data:{"num":num, "seller":seller, "name":name, "price":price, "amount":amount},
			dataType:'json',
			success: function(res){//res: 받은 응답
				$("#name_"+num).text(res.name);
				$("#price_"+num).text(res.price);
				$("#f").hide();
			},
			error: function(){
				alert("error");
			}
		});
	});
});
</script>
</head>
<body>
<h3>상품목록</h3>
<form action="/product/getbyname">
상품명 : <input type="text" name="name"> <input type="submit" value="검색">
</form>
<form action="/product/getbyseller">
판매자 : <input type="text" name="seller"> <input type="submit" value="검색">
</form>
<form action="/product/getbyprice">
가격대 : <input type="text" name="p1"> ~ <input type="text" name="p2"> <input type="submit" value="검색">
</form>
<a href="/product/add">상품등록</a><br/>
<table border="1">
<tr><th>상품명</th><th>가격</th><th>판매자</th><th>수정/삭제</th></tr>
<c:forEach var="p" items="${list }">
<tr><td><a href="/product/get?num=${p.num }"><span id="name_${p.num }">${p.name }</span></a></td>
<td id="price_${p.num }">${p.price }</td><td>${p.seller.id }</td>
<c:if test="${sessionScope.loginId == p.seller.id }">
<td>
<input type="button" value="수정" class="editForm" num="${p.num }">
<input type="button" value="삭제" >
</td>
</c:if>
</tr>
</c:forEach>
</table>
<form id="f" action="" method="post" style="position:absolute;top:150px;left:200px">
<input type="hidden" id="num">
<table border="1">
<tr><th>판매자</th><td><input type="text" id="seller" readonly></td></tr>
<tr><th>상품명</th><td><input type="text" id="name"></td></tr>
<tr><th>가격</th><td><input type="number" id="price"></td></tr>
<tr><th>수량</th><td><input type="number" id="amount"></td></tr>
<tr><th>수정</th><td><input type="button" value="수정" id="edit"><input type="button" value="취소" id="cancel"></td></tr>
</table>
</form>
</body>
</html>