<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
	<legend>회원정보 수정</legend>
		<form action="" method="post">
			아이디: <input type="text" value="${memberVO.userid }" name="userid" readonly>  <br>
			비밀번호: <input type="text" value="${memberVO.userpw }" name="userpw"> <br>
			이름:<input type="text" value="${memberVO.username }" name="username">  <br>
			이메일:<input type="text" value="${memberVO.useremail }" name="useremail">  <br>
			
			<input type="submit" value="정보 수정">
		</form>
	</fieldset>
</body>
</html>