<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
table,tr,td,th{
	border:1px solid black;
	border-collapse: collapse;
}
</style>
<body>
<table>
<tr>
<td colspan="2">장바구니 > 결제중 > <strong>결제완료</strong></td>

</tr>
<tr>
<td>주문자 정보
<ol>성함 : </ol>
<ol>연락처 : </ol>
<ol>배송지 : </ol>
</td>
<td>상품 정보
<ol>상품사진칸</ol>
<ol>상품이름칸</ol>
<ol>상품가격칸</ol>
</td>
</tr>
<tr>
<td colspan="2"><input type="button" value="메인으로" onclick="Main.jsp"></td>
</tr>

</table>

</body>
</html>