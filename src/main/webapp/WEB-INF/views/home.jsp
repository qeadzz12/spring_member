<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty sessionScope.id }">
			<h3>
				<a href="/member/login">로그인</a>
				<a href="/member/insert">회원가입</a>
			</h3>
		</c:when>
		<c:otherwise>
			<h1>
				${sessionScope.id } 님 환영합니다
			</h1>
			<h3>
				<a href="/member/info">회원정보</a>
				<a href="/member/logout">로그아웃</a>
			</h3>
		</c:otherwise>
	</c:choose>
	
		
	<P>  The time on the server is ${serverTime}. </P>
	
	
	
</body>
</html>
