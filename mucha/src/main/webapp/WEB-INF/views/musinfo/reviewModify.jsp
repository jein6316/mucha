<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/musinfo/style.css">
<link href="${pageContext.request.contextPath}/resources/css/musinfo/raty-master/demo/stylesheets/labs.css" media="screen" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/resources/css/musinfo/raty-master/demo/javascripts/jquery.js"></script>
<script src="${pageContext.request.contextPath}/resources/css/musinfo/raty-master/lib/jquery.raty.js"></script>
<script src="${pageContext.request.contextPath}/resources/css/musinfo/raty-master/demo/javascripts/labs.js" type="text/javascript"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/layout.css">
<style>
h1 {
	text-align:center;
	color:#FFF;
}

body{
	background-color:#27272b;
}
textarea{
	width:300px;
	height:100px;
	margin-bottom:10px;
	float:center;
}
#half,#review{
	margin-left:75px;
}
.result{
	margin-left:280px;
}
</style>
<h1>솔직한 감상평을 들려주세요!(최대 100자)</h1>
<form:form action="modify.do" commandName="commentsVO"
	enctype="multipart/form-data" id="reviewForm" name="reviewForm">
	<form:hidden path="rev_num" />
	<form:input type="hidden" path="rev_rate" />
	<form:errors path="rev_rate" cssClass="error-color"/>
	<label for=review></label>
	<div id="half"></div>
	<form:textarea id="review" name="review" path="review" />
	<form:errors path="review" cssClass="error-color" />
	<div class="result">
		<input type="submit" value="등록"> <input type="button"
			value="홈으로" onclick="location.href='../main/musMain.do'">
	</div>
</form:form>
<script>
	$.fn.raty.defaults.path = '${pageContext.request.contextPath}/resources/css/musinfo/raty-master/lib/images';
	$(function() {
		//현재 사용중인 별점주기 코드
		$('#half').raty({
			half : true,
			click : function(score, evt) {
				alert(score + "점이었군요!");
				$('#rev_rate').val(score);
			},
			score : function() {
				return $(this).attr('data-score');
			},

		});

		//별점 데이터 넘겨주기
		function getInputValue() {
			var rev_rate = $('#rev_rate').val();
		}
	});
	//글자수 제한
	$(document).ready(function(){
		$('#review').on('keyup',function(){
			if($(this).val().length>100){
				$(this).val($(this).val().substring(0,100));
				alert("글자수가 너무 많아요!");
				}
			});
		});
</script>	