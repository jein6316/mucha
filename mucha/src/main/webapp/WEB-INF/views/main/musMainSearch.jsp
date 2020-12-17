<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<style>
.list{
float:left;
padding-right:10px;
margin-bottom:15px;
font-
}
.post{
width:200px; 
height:300px;
}
.title{
font-size:20px;
}
</style>
<div class="search">
	<c:if test="${count == 0}">
		<div class="align-center">등록된 뮤지컬이 없습니다.</div>
	</c:if>
	<c:if test="${count > 0}">
		<div class="search_contents_title">검색한 뮤지컬</div>
		<div class="search_type1-contents_contents">
		<ul>
			<c:forEach var="musMain" items="${list}">				
				<li class="list">
					<a href="${pageContext.request.contextPath}/musinfo/musinfoDetail.do?mus_num=${musMain.mus_num}">
						<img src="postView.do?mus_num=${musMain.mus_num}" class="post">
					</a>
					<br>
					<span class="title">${musMain.mus_name}</span>
				</li>
			</c:forEach>
		</ul>
		</div>
	</c:if>	
</div>
