<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<style>
.tb{
width:700px;
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
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
function button_event(){
	if (confirm("정말 삭제하시겠습니까?") == true){    
		location.href="${pageContext.request.contextPath}/admin/adminDelete.do?mem_num="+${memberVO.mem_num};
	}else{   //취소
	    return;
	}
			
};	
</script>
<div class="page-main-style">
	<h2>관리자 정보 상세 보기</h2>
	<table class="tb">
		<tr>
			<th>관리자 번호</th>
			<td>${memberVO.mem_num}</td>
		</tr>
		<tr>
			<th>관리자 이메일</th>
			<td><a href="mailto:">${memberVO.email}</a></td>
		</tr>
		<tr>
			<th>관리자 닉네임</th>
			<td>${memberVO.nickname}</td>
		</tr>
		<tr>
			<th>관리자 전화번호</th>
			<td>${memberVO.phone}</td>
		</tr>
		<tr>
			<th>관리자 생년월일</th>
			<td>${memberVO.birth}</td>
		</tr>
		<tr>
			<th>관리자 등록일</th>
			<td>${memberVO.mem_regdate}</td>
		</tr>
	</table>
	<c:if test="${admin.mem_num=='100' && memberVO.mem_num!='100'}">
	<div class="align-center">
		<input type="button" id="delete" value="삭제" onclick="button_event();" class="button">
	</div>
	</c:if>
</div>