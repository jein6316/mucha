<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<style>
.search_contents_title{
	margin-left:40px;
}
.categoryList{
float:left;
padding-right:20px;
margin-bottom:15px;

}
.post{
width:200px; 
height:280px;
}
.title{
font-size:20px;
}
</style>
<div class="search">	
		<div class="search_contents_title">
			<c:if test="${gen_num == 1}">
			라이선스
			</c:if>
			<c:if test="${gen_num == 2}">
			오리지널
			</c:if>
			<c:if test="${gen_num == 3}">
			창작
			</c:if>
			<c:if test="${gen_num == 4}">
			어린이/가족
			</c:if>
			<c:if test="${gen_num == 5}">
			퍼포먼스
			</c:if>
		</div>
		<div class="search_type1-contents_contents">
		<ul>
			<c:forEach var="musMain" items="${list}">				
				<li class="categoryList">
					<a href="${pageContext.request.contextPath}/musinfo/musinfoDetail.do?mus_num=${musMain.mus_num}">
						<img src="postView.do?mus_num=${musMain.mus_num}" class="post">
					</a>
					<br>
					<span class="title">${musMain.mus_name}</span>
				</li>
			</c:forEach>
		</ul>
		</div>			

</div>

