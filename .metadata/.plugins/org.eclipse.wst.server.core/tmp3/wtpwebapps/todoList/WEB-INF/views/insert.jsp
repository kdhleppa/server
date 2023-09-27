<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>등록창</title>
</head>
<body>
	<h1>to do 등록하기</h1>
	<form action="/memo1/insert" method="post">
	<p>제목</p>
	<input type="text" name="subject">
	<p>메모</p>
	<input type="text" name="memo">
	<button onclick="showAlert()">등록하기</button>
	</form>
	
	
	
	<script>
        
        function showAlert() {
            window.alert("등록되었습니다.");
        }
    </script>
</body>
</html>