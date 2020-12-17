<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="page-main-style">
	<h2>회원 탈퇴</h2>
	<form:form action="deleteMember.do" commandName="memberVO">
		<form:errors element="div" cssClass="error-color"/>
		<ul>
			<li>
				<label for="email">이메일</label>
				<form:input path="email"/><br>
				<form:errors path="email" cssClass="error-color"/>        
			</li>
			<li>
				<label for="password">비밀번호</label>
				<form:password path="password"/><br>
				<form:errors path="password" cssClass="error-color"/>
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="탈퇴하기">
			<input type="button" value="홈으로"
			    onclick="location.href='${pageContext.request.contextPath}/main/musMain.do'"> 
		</div>
	</form:form>
</div>







