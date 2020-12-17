<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<style>
.button {
	border:0;
	outline:0;
	background-color: white;
	color: #black;
	
}
.button:hover {
	background-color: #d9534f;
	color: #fff;
}
.submit{
	border:0;
	outline:0;
	background-color: white;
	color: #black;
}
.submit:hover{
	background-color: #d9534f;
	color: #fff;
}
</style>
<meta charset="UTF-8">
<title>이용권 만료 안내</title>
</head>
<body>

	<h2>월 이용권 이용기간이 만료되었습니다!<br><br>다시 로그인해주세요!</h2>
	
	<input type="button" value="로그인"
			    onclick="location.href='${pageContext.request.contextPath}/main/musMain.do'"> 
</body>
</html>