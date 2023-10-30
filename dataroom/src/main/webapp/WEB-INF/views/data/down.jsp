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
	$("#down").click(function(){
		location.href="/data/down?fname=${fname }&num=${num}";
	});
	$("#aa").click(function(){
		opener.location.reload();//부모창 새로고침
		close();
	});
});
</script>
</head>
<body>
<h3>다운로드 페이지</h3>
다운로드 파일:${fname }
<input type="button" value="다운로드" id="down">
<input type="button" value="창닫기" id="aa">
</body>
</html>