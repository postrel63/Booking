<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"
integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg=="
crossorigin="anonymous"></script>

<script>
$(document).ready(function(){
	$("#userId").keyup(function(){
		var idCheck = $("#userId").val();
		$.ajax( {
			type : "get",
			url : "CheakId",
			data : {"uId" : idCheck }, 
			success : function(data){  
				console.log("data:"+data);
				if(data == "OK"){
					$("#confirmId").css("color","green").text("사용가능")
				}else{
					$("#confirmId").css("color","red").text("사용불가")
				}
			},
			error:function(){
				
			}
		} )
	})
})

</script>
<style>
table, tr, td, th {
	border: 1px solid black;
	border-collapse: collapse;
	padding: 5px;
}

fieldset {
	width: 225px;
}
</style>
<body>
	
	<h2>회원가입</h2>
	<form action="memberJoin" method="post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="userId" id="userId"> <span
					id="confirmId"></span></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="userPw"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="userName"></td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td><input type="date" name="userBirth"></td>
			</tr>
			<tr>
				<td>성별</td>
				<td><input type="radio" name="userGender" value="남자">남자
				    <input type="radio" name="userGender" value="여자" >여자</td>
			</tr>
			<tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="userEmail"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="회원가입"><input
					type="reset" value="다시작성"></td>
			</tr>
		</table>
	</form>

</body>
</html>