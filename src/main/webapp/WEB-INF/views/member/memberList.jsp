<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<table border="1">
			<tr>
				<td>아이디</td>
				<td>비밀번호</td>
				<td>이름</td>
				<td>이메일</td>
				<td>가입날짜</td>
				<td>수정날짜</td>
			</tr>
			
			<c:forEach var="i" items="${memberVOList }">
				<tr>
					<td>${i.userid }</td>
					<td>${i.userpw }</td>
					<td>${i.username }</td>
					<td>${i.useremail }</td>
					<td>${i.regdate }</td>
					<td>${i.updatedate }</td>
				</tr>
			</c:forEach>
			
		</table>
	</div>
</body>
</html>