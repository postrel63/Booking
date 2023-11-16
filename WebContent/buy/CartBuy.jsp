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
/* div {
	padding: 5px;
	margin: 5px;
}

#title {
	float: left;
	height: 60px;
	width: 50%;
	padding: 20px;
	text-align: center;
}

#sequence {
	height: 60px;
	width: 50%;
	text-align: left;
	padding: 20px;
}

#all {
	float:;
}

#info {
	float:;
}

#paypath {
	
} */
table, tr, td, th {
	border: 1px solid black;
	border-collapse: collapse;
}

.list {
	width: 300px;
}
</style>
<body>

	<%-- 	<div id="title">
		<h3>구매결제</h3>
	</div>
	<div id="sequence">
		<p>
			장바구니 > <strong>주문중</strong>> 결제완료
		</p>
	</div>

	<form action="buyProcess" method="post">
		<div id="info">
			<br>
			<p>주문자 정보</p>
			<label for="buy_userId">받는 분</label> <input type="text" value="김동욱"
				id="buy_userId" name="userId"><br> <label
				for="buy_userPN">연락처 </label> <input type="text" name="userPN"><br>
			<label for="buy_userPN">주소 </label> <input type="text"
				name="useraddrss"><br>
		</div>

		<div id="payPath">
			<h3>결제 수단 선택</h3>
			<input type="radio" name="PayMethod">신용카드<br> <input
				type="radio" name="PayMethod">계좌이체<br>
		</div>
		<c:forEach var="cartlist" items="${cartlist}">
			<div id="list">
				<div>${cartlist.bFile}</div>
				<div>${cartlist.bName}</div>
			</div>
		</c:forEach>
		<div>${cartsum}원</div>

		<input type="submit" value="결제하기">

	</form> --%>
	<form action="buyProcess" method="post">
		<table>
			<tr>
				<td colspan="2">장바구니 > <strong>결제중</strong> >결제완료
				</td>

			</tr>
			<tr>
				<td>주문자 정보
					<ol>
						<label for="buy_userId">받는 분</label>
						<input type="text" value="김동욱" id="buy_userId" name="userName">
					</ol>
					<ol>
						<label for="buy_userPN">연락처 </label>
						<input type="text" name="userPN">
					</ol>
					<ol>
						<label for="buy_userPN">주소 </label>
						<input type="text" name="useraddrss">
					</ol>
				</td>
				<td class="list"><c:forEach var="cartlist" items="${cartlist}">
						<ol>${cartlist.bFile}</ol>
						<ol>${cartlist.bName}</ol>
					</c:forEach> <b>${cartsum}</b>원</td>
			</tr>
			<tr>
				<td colspan="2">결제 수단 선택<br> <input type="radio" value="신용카드"
					name="PayMethod">신용카드<br> <input type="radio" value="무통장입금"
					name="PayMethod">무통장입금<br>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" value="메인으로"
					onclick="Main.jsp"><input type="submit" value="결제하기" onclick="location.href='/buy/buyProcess'"> </td>
			</tr>
			
		</table>
	</form>


</body>
</html>