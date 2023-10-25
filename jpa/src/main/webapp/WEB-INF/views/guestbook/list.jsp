<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	$("#writeForm").click(function(){
		$("#save").val("작성");
		$("#f").show();
		type = 1;
	});
	$("#save").click(function(){
		let param={};
		let content = ${"#save"}.val();
		if(type==1){
			param={"writer":'${sessionScope.loginId}',"content":content, "type" : 1};
		}else{
			param = {"num":$("#num").val(),"content":content, "type":2};
		}
		$.ajax({
			url:"/guestbook/save",
			type:"post",
			data:param,
			dataType:'json',
			success:function(res){
				if(type==1){
				let html = "<table border=1";
				html += "<tr> <th>방명번호</th>  <td>"+ res.num;
				html += "<c:if test=\"'${sessionScope.loginId }'=="+res.writer+"\">";
				html += "<input type='button' value='수정' class='edit'num='"+res.num+"'>";
				html += "<input type='button' value='취소' class='cancel'>";
				html += "</c:if>";
				html += "</td></tr>";
				html += "<tr> <th>작성자</th>  <td>"+ res.write +"</td> </tr>";
				html += "<tr> <th>작성일</th>  <td>"+ res.wdate +"</td> </tr>";
				html += "<tr> <th>내용</th>  <td id='cont_"+res.num+"'>"+res.content +"</td> </tr>";
				html += "</table>";
				$("#divlist").prepend(html);
				
				}else{
					$("#cont_"+res.num).text(res.content);
				}
				$("#f").hide();
				$("#content").val("");
			},
			error:function(){
				alert("error");
			}
		});
	});
	$(".edit").click(function(){
		$("#save").val("작성");
		$("#f").show();
		type = 2;
		$("#num").val(num);
	});
});
</script>
</head>
<body>
<h3>방명록</h3>
<input type="button" id="writeForm" value="글작성"><br>
<div id="divlist">
<c:forEach var="m" items="${list }">
<table border="1">
<tr> <th>방명번호</th>  
<td>
	${m.num }
	<c:if test="${b.writer.id == sessionScope.loginId }">
		<input type="button" value="수정" class="edit" num="${b.num }">
		<input type="button" value="취소" class="cancel" num="${b.num }">
	</c:if>
</td> 
</tr> 
<tr> <th>작성자</th> <td>${m.writer.id }</td> </tr>
<tr> <th>날짜</th> <td>${m.wdate }</td> </tr>
<tr> <th>내용</th> <td id='cont_+${m.num }'>${m.content }</td></tr>
</table>
</c:forEach>
</div>
<from id="f" action="guestbook/save" style="position: absolute; top: 83px; left:270px;">
내용 : <input type="text" id="content">
<input type="button" id="save" value="작성">
<input type="hidden" id="num">
</from>
</body>
</html>