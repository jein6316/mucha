<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<script src="${pageContext.request.contextPath}/resources/js/videoAdapter.js"></script>  
<div class="page-main-style">
	<h2>${notice.no_title}</h2>
	<ul>
		<li>번호 : ${notice.no_num}</li>
		<li>조회수 : ${notice.no_hit}</li>
		<li>작성일 : ${notice.no_regdate}</li>
	</ul>
	<hr size="1" width="100%">
	
	<p>
		${notice.no_content}
	</p>
	<hr size="1" width="100%">
	<div class="align-right">
	    <%--수정 삭제의 경우는 로그인이 되어있고 로그인한 회원번호와 작성자 회원번호가
	               일치해야 함 --%>

		<input type="button" value="목록"
		       onclick="location.href='memberNoticeList.do'">
	</div>
</div>







