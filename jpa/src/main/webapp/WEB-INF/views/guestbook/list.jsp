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
	let type = 1;//1:추가, 2:수정
	$("#f").hide();
	$("#writeForm").click(function(){
		$("#save").val("작성");
		$("#f").show();
		type = 1;
	});
	$("#save").click(function(){
		let param = {};
		let content = $("#content").val(); // val():입력 양식값을 읽고, 씀-> val('abcd'), text():태그사이의 내용을 읽고씀. html():태그 사이의 html코드를 읽고 씀
		if(type==1){
			param = {"writer":'${sessionScope.loginId}', "content":content, "type":1};
		}else{
			param = {"num":$("#num").val(), "content":content, "type":2};
		}
		$.ajax({
			url:"/book/save",
			type:"post",
			data:param,
			dataType:'json',
			success: function(res){//res: 받은 응답
				if(type==1){
					let html = "<table border=1 id='t_"+res.num+"'>";
					html += "<tr><th>글번호</th><td>"+res.num;
					if('${sessionScope.loginId }'==res.writer){
						html += "<input type='button' value='수정' class='edit' num='"+res.num+"'>";
						html += "<input type='button' value='삭제' class='del' num='"+res.num+"'>";
					}
					html += "</td></tr>";
					html += "<tr><th>작성자</th><td>"+res.writer+"</td></tr>";
					html += "<tr><th>작성일</th><td>"+res.wdate+"</td></tr>";
					html += "<tr><th>내용</th><td id='cont_"+res.num+"'>"+res.content+"</td></tr>";
					html += "</table>";
					$("#divlist").prepend(html);
					$(".edit").on("click", function(){
						let num = $(this).attr("num");
						$("#save").val("수정");
						$("#content").val($("#cont_"+num).text());
						$("#f").show();
						type = 2;
						$("#num").val(num);
					});
					$(".del").on("click", function(){
						let num = $(this).attr("num");
						$("#t_"+num).remove();//테이블 삭제
						$.ajax({
							url:"/book/del",
							type:"post",
							data:{"num":num},
							dataType:'json',
							success: function(res){//res: 받은 응답
								
							},
							error: function(){
								alert("error");
							}
						});
					});
				}else{
					$("#cont_"+res.num).text(res.content);
				}
				$("#f").hide();
				$("#content").val("");
			},
			error: function(){
				alert("error");
			}
		});
	});
	$(".cancel").click(function(){
		$("#f").hide();
	});
	$(".edit").click(function(){
		let num = $(this).attr("num");
		$("#save").val("수정");
		$("#content").val($("#cont_"+num).text());
		$("#f").show();
		type = 2;
		$("#num").val(num);
	});
	$(".del").click(function(){
		let num = $(this).attr("num"); //this:이벤트 발생 객체
		$("#t_"+num).remove();//테이블 삭제
		$.ajax({
			url:"/book/del",
			type:"post",
			data:{"num":num},
			dataType:'json',
			success: function(res){//res: 받은 응답
				
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
<h3>방명록</h3>
<input type="button" id="writeForm" value="글작성"><br/>
<div id="divlist">
<c:forEach var="b" items="${list }">
<table border="1" id="t_${b.num }">
<tr><th>글번호</th>
<td>
	${b.num }
	<c:if test="${b.writer.id == sessionScope.loginId }">
		<input type="button" value="수정" class="edit" num="${b.num }">
		<input type="button" value="삭제" class="del" num="${b.num }">
	</c:if>
</td>
</tr>
<tr><th>작성자</th><td>${b.writer.id }</td></tr>
<tr><th>작성일</th><td>${b.wdate }</td></tr>
<tr><th>내용</th><td id='cont_${b.num }'>${b.content }</td></tr>
</table>
</c:forEach>
</div>
<form id="f" action="" style="position:absolute;top:100px;left:100px">
내용:<input type="text" id="content">
<input type="button" id="save" value="작성">
<input type="hidden" id="num">
</form>
</body>
</html>