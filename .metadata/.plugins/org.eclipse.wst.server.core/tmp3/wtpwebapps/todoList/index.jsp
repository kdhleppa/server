<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>todolist</title>

<link rel="stylesheet" href="/resources/css/main.css">
</head>
<body>
	<main>
	    <div id="container">
	    <%-- 로그인 안되있을때 --%>
	    <c:choose>
	    	<c:when test="${empty sessionScope.loginMember }">
			    <h1>투 두 리스트 로그인</h1>
			    <div id="formcontainer">
				    <form action="/member/login" method="post" name="login-form" id="loginfrm">
				        <p>아이디</p>
				        <input type="text" name="inputId" placeholder="아이디">
				        <p>패스워드</p>
				        <input type="password" name="inputPw" placeholder="비밀번호">
				        <button>로그인</button>
				        <a href="">회원가입</a>
				    
		    		</form>
	    		</div>
	    
	    </c:when>
	    <c:otherwise>
	    	<article class="login-area">
	    		<p>${sessionScope.loginMember.memberNickname }의 TODO LIST</p>
	    		<c:choose>
	    			<%-- todoList 가 비어있을때 --%>
	    			<c:when test="${empty sessionScope.tdList }">
	    				<p>할일이 없습니다.</p>
	    			</c:when>
	    			<c:otherwise>
	    				<c:forEach var="todo" items="${tdList}">
	    					<div id="todoList">
	    					<p>${todo.todoTitle}</p>
	    					<p>(${todo.todoMemo})</p>
	    					<p>${todo.todoDate }</p>
	    					<a href="/update?no=${todo.todoNo}">수정</a>
	    					<a href="/delete?no=${todo.todoNo}">삭제</a>
	    					
	    					</div>
	    				
	    				</c:forEach>
	    				
	    			</c:otherwise>
	    		</c:choose>
	    		<a href="/memo1/insert">등록하기</a>
	    		<a href="/member/logout">로그아웃</a>
	    	</article>
	    
	    </c:otherwise>
	    </c:choose>
	    </div>
	</main>
    
    
    
    
    
</body>
</html>