<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<input type="button" value="장바구니" onclick="location.href='/BOOKS/cart/CartView'">
<hr>
	<form action="CartInsert" method="post" id="booksView">
		<table>
			<tr>
				<td><input type="hidden" value="나미야 잡화점의 기적" name="bName">나미야
					잡화점의 기적</td>
				<td><select name="amount"><option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
				</select></td>
				<td><input type="submit" value="장바구니에 담기"></td>
			</tr>
		</table>
	</form>
	<form action="CartInsert" method="post" id="booksView">
		<table>
			<tr>
				<td><input type="hidden" value="가면산장 살인사건" name="bName">가면산장
					살인사건</td>
				<td><select name="amount"><option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option></select></td>
				<td><input type="submit" value="장바구니에 담기"></td>
			</tr>
		</table>
	</form>
</body>
</html>