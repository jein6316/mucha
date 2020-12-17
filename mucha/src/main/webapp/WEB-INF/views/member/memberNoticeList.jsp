<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
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
	<h2>공지사항</h2>
	<form action="memberNoticeList.do" id="search_form" method="get">
		<ul class="search">
			<li>
				<select name="keyfield" id="keyfield">
					<option value="1">제목</option>
					<option value="2">내용</option>
					<option value="3">작성 관리자 번호</option>
					<option value="4">전체</option>
				</select>
			</li>  
			<li>
				<input type="text" name="keyword" name="keyword">
			</li>
			<li>
				<input type="submit" value="찾기">
				<input type="button" value="목록" onclick="location.href='memberNoticeList.do'">
			</li>
		</ul>
	</form>
	<c:if test="${count == 0}">
		<div class="align-center">등록된 게시물이 없습니다.</div>
	</c:if>
	<c:if test="${count > 0}">
		<table id="noticeTable" class="noticeTable" >
			<tr class="th">
				<th>번호</th>
				<th width="400">제목</th>
				<th>최근 수정일</th>
				<th>조회수</th>
			</tr>
			<c:forEach var="notice" items="${list}">
				<tr>
					<td>${notice.no_num}</td>
					<td><a href="memberNoticeView.do?no_num=${notice.no_num}">${notice.no_title}</a></td>
					<td>${notice.no_regdate}</td>
					<td>${notice.no_hit}</td>
				</tr>			
			</c:forEach>
		</table>
		<div class="align-center">${pagingHtml}</div>
	</c:if>	
</div>  