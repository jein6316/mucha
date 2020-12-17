<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<style>
.review{
width:400px;
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
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$(document).on('click','#hiddenReview',function(){//가려진 리뷰 보기
		location.href="${pageContext.request.contextPath}/admin/hiddenReviews.do";
		

	});
	$(document).on('click','#allReview',function(){//전체 리뷰 보기

		location.href="${pageContext.request.contextPath}/admin/adminMusicalReviews.do";
		
	});
});    
</script>
<div class="page-main-style">
	<h2>등록된 뮤지컬 리뷰</h2>
	<form action="adminMusicalReviews.do" id="search_form" method="get">
	<ul class="search">
		<li>
			<select name="keyfield" id="keyfield">
				<option value="1">뮤지컬 번호</option>
				<option value="2">회원 번호</option>
				<option value="3">전체</option>
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
		<c:if test="${check==0}">
		<input type="button" value="가려진 리뷰만 보기" id="hiddenReview" class="button" />
		</c:if>
		<c:if test="${check==1}">
		<input type="button" value="전체 리뷰 보기" id="allReview" class="button" />
		</c:if>
		<c:if test="${count==0}">
			<div class="align-center">등록된 게시물이 없습니다.</div>
		</c:if>
	</div>
	<c:if test="${count>0}">
	<div>
	검색된 총 뮤지컬 수 : ${count}
	</div>
		<table class="tb">
			<tr class="th">
				<th>리뷰 번호</th>
				<th width="130">뮤지컬 번호</th>
				<th>닉네임</th>
				<th>회원번호</th>
				<th>평점</th>
				<th class="review">한줄평</th>
				<c:if test="${musical.hide_rev!=null}">
				<th>가려진 한줄평</th>
				</c:if>
				<th>리뷰 등록일</th>
				<th>리뷰 가리기</th>
			</tr>
			<c:forEach var="musical" items="${list}">
				<tr>
					<td>${musical.rev_num}</td>
					<td><a href="${pageContext.request.contextPath}/musinfo/reviews.do?mus_num=${musical.mus_num}">${musical.mus_num}</a></td>
					<td>${musical.nickname}</td>
					<td>${musical.mem_num}</td>
					<td>${musical.rev_rate}</td>
					<c:if test="${musical.hide_rev!=null}">
					<td class="review">${musical.hide_rev}</td>
					</c:if>
					<c:if test="${musical.hide_rev==null}">
					<td class="review">${musical.review}</td>
					</c:if>
					<td>${musical.rev_regdate}</td>
					<td>
					<c:if test="${musical.hide_rev==null}">
					<input type="button" value="가리기" id="rev_delete" onclick="location.href='reviewHide.do?rev_num=${musical.rev_num}'" class="button"/>
					</c:if>
					<c:if test="${musical.hide_rev!=null}">
					<input type="button" value="되돌리기" id="rev_delete" onclick="location.href='reviewReturn.do?rev_num=${musical.rev_num}'" class="button"/>
					</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
		<div class="align-center">${pagingHtml}</div>
	</c:if>
</div>