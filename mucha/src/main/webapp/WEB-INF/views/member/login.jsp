<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<div class="page-main-style">
	<h2>회원 로그인</h2>
	<form:form action="login.do" commandName="memberVO">
		<form:errors element="div" cssClass="error-color"/>
		<ul>
			<li>
				<label for="email">이메일</label>
				<form:input path="email"/>
				<form:errors path="email" cssClass="error-color"/>        
			</li>
			<li>
				<label for="password">비밀번호</label>
				<form:password path="password"/>
				<form:errors path="password" cssClass="error-color"/>
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="로그인" class="submit">
			<input type="button" value="회원가입" class="button"
				onclick="location.href='${pageContext.request.contextPath}/member/join.do'">
		</div>
		<br>
		<div class="align-right">
			<input type="button" value="비밀번호 찾기" class="button"
				onclick="location.href='${pageContext.request.contextPath}/member/findPassword.do'"> 
			   
		</div>
	</form:form>
</div>