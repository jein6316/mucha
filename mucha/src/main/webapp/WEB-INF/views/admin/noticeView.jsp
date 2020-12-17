<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<script src="${pageContext.request.contextPath}/resources/js/videoAdapter.js"></script>

<style>
h2{
align-center;
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
	<h2>${notice.no_title}</h2>
	<ul>
		<li>번호 : ${notice.no_num}</li>
		<li>작성자 : ${notice.mem_num}</li>
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
		<c:if test="${user.auth==0}">
		<input type="button" value="수정" class="button"
		       onclick="location.href='noticeUpdate.do?no_num=${notice.no_num}'">
		<input type="button" value="삭제" id="delete_btn" class="button">
		<script>
			var delete_btn = document.getElementById('delete_btn');
			//이벤트 연결
			delete_btn.onclick=function(){
				var choice = window.confirm('삭제하시겠습니까?');
				if(choice){
					location.href='noticeDelete.do?no_num=${notice.no_num}';
				}
			};
		</script>              
		</c:if>
		<input type="button" value="목록" class="button"
		       onclick="location.href='noticeList.do'">
	</div>
</div>







