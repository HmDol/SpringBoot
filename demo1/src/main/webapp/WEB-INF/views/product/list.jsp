<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
var change = () =>{
	var criteria = document.getElementById("searchCriteria").value;

    // 모든 검색창을 숨깁니다.
    document.getElementById("sellerInput").style.display = "none";
    document.getElementById("productNameInput").style.display = "none";
    document.getElementById("priceRangeInput").style.display = "none";

    // 선택한 기준에 따라 해당 검색창을 보여줍니다.
    if (criteria === "seller") {
    	
        document.getElementById("sellerInput").style.display = "block";
        
    }else if (criteria === "productName") {
    	
        document.getElementById("productNameInput").style.display = "block";
        
        
    }else if(criteria === "priceRange") {
    	
        document.getElementById("priceRangeInput").style.display = "block";
        
    }else{
    	
    }
    	
    
}
</script>
</head>
<body>
<h3>상품 목록</h3>

  <select id="searchCriteria" onChange="change()">
        <option value="seller">판매자</option>
        <option value="productName">상품 이름</option>
        <option value="priceRange">가격</option>
    </select>
	
	<div id="sellerInput" style="">
    <form action="/product/getbyseller">
        <label for="sellerName">판매자:</label>
        <input type="text" id="sellerName" name="seller">
        <input type="submit" value="검색">
    </form>
	</div>
	<div id="productNameInput" style="display:none;">
    <form action="/product/getbyname" >
        <label for="productName">상품 이름:</label>
        <input type="text" id="productName"name="name">
        <input type="submit" value="검색">
    </form>
	</div>
	<div id="priceRangeInput" style="display:none;">
    <form action="/product/getbyprice">
        <label for="minPrice">최소 가격 (원):</label>
        <input type="number" id="minPrice" name="price1">
        <label for="maxPrice">최대 가격 (원):</label>
        <input type="number" id="maxPrice" name="price2">
        <input type="submit" value="검색">
    </form>
	</div>
    




<table border="1">
<tr>
<th>상품이름</th><th>가격</th><th>판매자</th>
</tr>
<c:forEach var="p" items="${list }">
<tr>
<th><a href="/product/get?num=${p.num }">${p.name } </a></th>
<th>${p.price}</th>
<th>${p.seller }</th>
</tr>
</c:forEach>
</table>
<a href="/product/add">상품등록</a>
</table>
</body>
</html>