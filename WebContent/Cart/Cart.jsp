<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
table, tr, td, th {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>

<body>
	<h2>장바구니</h2>
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
		</c:otherwise>
	</c:choose>
	<hr>
	<form action="cartProcess" method="post" id="cartForm">
		<table>
			<tr>
				<!-- <td><input type = "checkbox" id="allCheak">전체 선택</td> -->
				<td>상품 정보</td>
				<td>상품 금액</td>
				<td>상품 수량</td>
				<td>배송비</td>
				<td>삭제</td>
			</tr>
			<c:forEach var="cartlist" items="${cartlist}">
				<tr>
					<!-- <td><input type = "checkbox" id="allCheak"></td> -->
					<td>${cartlist.bName}</td>
					<td>${cartlist.bPrice}</td>
					<td>${cartlist.amount}</td>
					<td>배송비 무료</td>
					<td><input type="button" value="삭제"
						onclick="location.href='CartDelete?cartId=${cartlist.cartId}'"></td>

				</tr>
			</c:forEach>
			<tr>
				<td colspan="5">상품가격 ${cartsum}원 (+) 배송비 무료= 주문금액 ${cartsum}원</td>
			</tr>
			<tr>
				<td colspan="5"><input type="button" value="계속 쇼핑하기"
					onclick="location.href='/BOOKS/Books/BooksView.jsp'"> <input
					type="button" id="" value="구매하기" onclick="Buy()"></td>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.4.0.js"></script>
<script type="text/javascript">
	function Buy() {
		location.href = '/BOOKS/buy/buyForm';
	}
</script>
</html>