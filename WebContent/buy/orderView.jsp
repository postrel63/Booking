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
	<table>
		<tr>
			<td colspan="2">장바구니 > 결제중 ><strong>결제완료</strong>
			</td>

		</tr>
		<tr>
			<c:forEach var="orderlist" items="${orderlist}" begin="0" end="0">
				<td colspan="2">주문자 정보 <br> 이름: ${orderlist.userName} <br>
					연락처:${orderlist.userPN}<br> 주소: ${orderlist.userAddress}<br>
				</td>

			</c:forEach>
			<c:forEach var="orderlist" items="${orderlist}">
				<tr>
					<td class="list">${orderlist.bName}<br>
						${orderlist.bPrice}<br>
				</tr>
			</c:forEach>
		</tr>

		<tr>
			<td colspan="2"><input type="button" value="메인으로"
				onclick="/BOOKS/Members/Main.jsp"></td>
		</tr>

	</table>

</body>
</html>