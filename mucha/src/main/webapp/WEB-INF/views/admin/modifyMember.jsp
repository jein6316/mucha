<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="page-main-style">
	<h2>회원정보 변경</h2>
	<form:form action="modifyMember.do" commandName="memberVO">
		<form:errors element="div" cssClass="error-color"/>
		<ul>
			<li>
				<label for="nickname">닉네임</label>
				<form:input path="nickname"/>
				<form:errors path="nickname" cssClass="error-color"/>
			</li>
			<li>
				<label for="phone">연락처</label>
				<form:input path="phone"/>
				<form:errors path="phone" cssClass="error-color"/>
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="수정">
			<input type="button" value="홈으로"
			    onclick="location.href='${pageContext.request.contextPath}/member/memberMain.do'">
		</div>
	</form:form>
</div>