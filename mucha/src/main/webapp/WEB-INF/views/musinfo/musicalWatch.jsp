<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
.page-main-style{
		margin-top:30px;
	}

</style>
<div class="page-main-style">

	<h2>${musical.mus_name }</h2>
		<div class="baseInfo">
                <c:if test="${musical.gen_num==1 }">라이선스</c:if>
                <c:if test="${musical.gen_num==2 }">오리지널</c:if>
                <c:if test="${musical.gen_num==3 }">창작</c:if>
                <c:if test="${musical.gen_num==4 }">어린이/가족</c:if>
                <c:if test="${musical.gen_num==5 }">퍼포먼스</c:if>
                 · ${musical.mus_time }분
    	</div>
	<div class="video-container"> <iframe src="https://www.youtube.com/embed/${musical.mus_video }" frameborder="0" width="100%" height="500"></iframe> </div>


</div>
