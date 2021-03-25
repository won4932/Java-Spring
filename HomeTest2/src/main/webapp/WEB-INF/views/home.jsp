<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<title>Home</title>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>
		  const getSubmit = ()=>{
			  $.ajax({
				url: "url", // 요청 할 주소
				//type:'GET', // GET, PUT
				//dataType:'xml',// xml, json, script, html
				//contentType : "application/xml",
				//jsonp : "callback",
				//beforeSend:function(jqXHR) {
				//},// 서버 요청 전 호출 되는 함수 return false; 일 경우 요청 중단
				success:function(result) {
					alert("hello");
					console.log(JSON.stringify(result));
					$("#response").val(JSON.stringify(result));
					
				},// 요청 완료 시
				error:function(jqXHR) {
					alert("failed");
				},// 요청 실패.
				complete:function(jqXHR) {}// 요청의 실패, 성공과 상관 없이 완료 될 경우 호출
				});
		  };	
	</script>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<input type="button" onclick="getSubmit();">
<textarea id="response"></textarea>
</body>
</html>