<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<input type="button" value="회원가입"
		onclick="location.href='/BOOKS/Members/JoinForm.jsp'">
<c:choose>
	<c:when test="${sessionScope.loginId == null}">
		<form action="MemberLogin" method="post">
			<label>아이디<input type="text" name="userId"></label><br>
			<label>비밀번호<input type="text" name="userPw"></label> <input
				type="submit" value="로그인">
		</form>
	</c:when>
	<c:otherwise>
			<h2>${sessionScope.loginId}님환영합니다.</h2>
	<input type="button" value="장바구니로" onclick="location.href='/BOOKS/cart/CartView'"> 
	<input type="button" value="주문조회" onclick="location.href='/BOOKS/buy/orderView'">
		</c:otherwise>
	</c:choose>
	<hr>

</body>
<script>
	
</script>
</html>