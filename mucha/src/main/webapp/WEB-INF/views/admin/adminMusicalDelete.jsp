<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="page-main-style">
	<h2>뮤지컬 삭제</h2>
	<form:form action="adminMusicalDelete.do" commandName="memberVO">
	<form:errors element="div" cssClass="error-color"/>
		<form:hidden path="mus_num"/>
		<ul>
			<li>
				<label for="email">관리자 이메일</label>
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
			<input type="submit" value="삭제하기">
			<input type="button" value="뒤로 가기"
			    onclick="history.back()">
		</div>
	</form:form>
</div>	