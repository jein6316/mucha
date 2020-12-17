<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
body.home{
	background-color:#27272b;
}
.page-main-style{
	color:white;
}
</style>
<link href="${pageContext.request.contextPath}/resources/css/musinfo/raty-master/demo/stylesheets/labs.css" media="screen" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/resources/css/musinfo/raty-master/demo/javascripts/jquery.js"></script>
<script src="${pageContext.request.contextPath}/resources/css/musinfo/raty-master/lib/jquery.raty.js"></script>
<script src="${pageContext.request.contextPath}/resources/css/musinfo/raty-master/demo/javascripts/labs.js" type="text/javascript"></script>

<div class="page-main-style">
	<h2>한줄평 보기</h2>
	<c:if test="${count==0 }">
		<div class="align-center">등록된 한줄평이 없습니다.</div>
	</c:if>
	<!-- 한줄평 -->

	<c:if test="${count!=0 }">
		평균 평점 : ${avg }(${num}명)
		<table>
			<tr>
				<th>닉네임</th>
				<th>평점</th>
				<th>한줄평</th>
			</tr>
			<c:forEach var="list" items="${list}">
				<!-- 내가 쓴 리뷰 먼저 보기 -->
				<c:if test="${!empty user&& user.mem_num==list.mem_num}">
					<tr>
						<td>${list.nickname}</td>
						<td>${list.rev_rate}</td>
						<td>${list.review}
						<c:if test="${list.hide_rev==null}">
						<!-- 로그인이 되어 있고 작성자 아이디와 로그인 아이디가 일치해야 수정/삭제 권한을 줌 -->
							<input type="button" value="수정"
							onclick="location.href='modify.do?rev_num=${list.rev_num}'">
							<input type="button" value="삭제" id="delete_btn"
							onclick="location.href='delete.do?rev_num=${list.rev_num}'">
						</c:if>
						</td>
					</tr>
				</c:if>
				<c:if test="${user.mem_num!=list.mem_num}">
					<tr>
						<td>${list.nickname}</td>
						<td>${list.rev_rate}</td>
						<td>${list.review}</td>
					</tr>
				</c:if>
			</c:forEach>
		</table>
	</c:if>
</div>
