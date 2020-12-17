<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<style>
.align-right{
margin-right:210px;
}
.count{
margin-left:210px;
}
.tb{
width:700px;
}
.th{
background-color: #d9534f;
color: color:white;
border:solid 2px white;
}
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
</style>
<div class="page-main-style">
	<h2>뮤지컬 관리</h2>
	<form action="adminMusicalList.do" id="search_form" method="get">
	<ul class="search">
		<li>
			<select name="keyfield" id="keyfield">
				<option value="1">뮤지컬 번호</option>
				<option value="2">뮤지컬 제목</option>
				<option value="3">뮤지컬 장르</option>
				<option value="4">전체</option>
			</select>
		</li>
		<li>
			<input type="text" name="keyword" id="keyword">
		</li>
		<li>
			<input type="submit" value="찾기" class="button">
			<input type="button" value="목록" class="button"
						onclick="location.href='adminMusicalList.do'">
		</li>
	</ul>
	</form>
	<div class="align-right" >
		<c:if test="${!empty user}">
			<input type="button" value="새로 등록하기" onclick="location.href='adminMusicalRegister.do'" class="button">
		</c:if>
	</div>
	<c:if test="${count==0}">
	<div class="align-center">등록된 게시물이 없습니다.</div>
	</c:if>
	<c:if test="${count>0}">
	<div>
		<p class="count">검색된 총 뮤지컬 수 : ${count}</p>
	</div>
	<table class="tb">
		<tr>
			<th width="130" class="th">뮤지컬 번호</th>
			<th width="400" class="th">뮤지컬 제목</th>
			<th class="th">등록일</th>
		</tr>
		<c:forEach var="musical" items="${list}">
		<tr>
			<td>${musical.mus_num}</td>
			<td><a href="adminMusicalDetail.do?mus_num=${musical.mus_num}">${musical.mus_name}</a></td>
			<td>${musical.mus_regdate}</td>
		</tr>
		</c:forEach>
	</table>
	<div class="align-center">${pagingHtml}</div>
	</c:if>
</div>