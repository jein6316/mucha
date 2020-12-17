<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form action="delete.do" commandName="commandVO" enctype="multipart/form-data">
	<form:hidden path="mus_rate"/>
	<h2>삭제하시겠습니까?</h2>
	<div class="align-center">
		<input type="submit" value="삭제">
		<input type="button" value="뒤로가기" onclick="history.go(-1)">
	</div>
</form:form>
