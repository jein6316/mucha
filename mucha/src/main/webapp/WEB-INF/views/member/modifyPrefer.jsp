<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<style>
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
.submit{
	border:0;
	outline:0;
	background-color: white;
	color: #black;
}
.submit:hover{
	background-color: #d9534f;
	color: #fff;
}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#modPrefer_form').submit(function(){
			if($('#prefer').val()==''){
				alert('하나 이상 선택하세요');
				return false;
			}	
		});
	});
</script>

<style>

form{
	width:95%;
}

</style>

<div class="page-main-style">
	<h2>선호장르 변경</h2>
	<form:form id="modPrefer_form" action="modifyPrefer.do" commandName="memberVO">
		<form:errors element="div" cssClass="error-color"/>
		 <div class="perfer_chk" id="prefer_chk">
		<p>보고싶은 공연을 골라보세요.</p>

		 	<br><br>
		 	<img src="${pageContext.request.contextPath}/resources/post/Sweeney_Todd.jpg" width="180" height="240">
		 	<input type="checkbox" id="prefer" name="prefer" value="1">
		 	<img src="${pageContext.request.contextPath}/resources/post/sunemoone.gif" width="180" height="240">
		 	<input type="checkbox" id="prefer" name="prefer" value="4">
		 	<img src="${pageContext.request.contextPath}/resources/post/Jekyll and Hyde.gif" width="180" height="240">
		 	<input type="checkbox" id="prefer" name="prefer" value="2">
		 	<img src="${pageContext.request.contextPath}/resources/post/annie.gif" width="180" height="240">
		 	<input type="checkbox" id="prefer" name="prefer" value="5">
		 	<img src="${pageContext.request.contextPath}/resources/post/6oclock.png" width="180" height="240">
		 	<input type="checkbox" id="prefer" name="prefer" value="3">
		 	<br><br><br>
		 	<img src="${pageContext.request.contextPath}/resources/post/gloomyday.png" width="180" height="240">
		 	<input type="checkbox" id="prefer" name="prefer" value="3">
		 	<img src="${pageContext.request.contextPath}/resources/post/lapungel.GIF" width="180" height="240">
		 	<input type="checkbox" id="prefer" name="prefer" value="4">
		 	<img src="${pageContext.request.contextPath}/resources/post/Gentleman's_guide.jpeg" width="180" height="240">
		 	<input type="checkbox" id="prefer" name="prefer" value="1">
		 	<img src="${pageContext.request.contextPath}/resources/post/infinityFlying.gif" width="180" height="240">
		 	<input type="checkbox" id="prefer" name="prefer" value="5">
		 	<img src="${pageContext.request.contextPath}/resources/post/The Phantom Of The Opera.gif" width="180" height="240">
		 	<input type="checkbox" id="prefer" name="prefer" value="2">
		 	<br><br><br>
		 	<img src="${pageContext.request.contextPath}/resources/post/redhat.gif" width="180" height="240">
		 	<input type="checkbox" id="prefer" name="prefer" value="4">
		 	<img src="${pageContext.request.contextPath}/resources/post/circus.gif" width="180" height="240">
		 	<input type="checkbox" id="prefer" name="prefer" value="5">
		 	<img src="${pageContext.request.contextPath}/resources/post/Jesus_Christ_Super_Star.jpg" width="180" height="240">
		 	<input type="checkbox" id="prefer" name="prefer" value="1">
		 	<img src="${pageContext.request.contextPath}/resources/post/fanletter.png" width="180" height="240">
		 	<input type="checkbox" id="prefer" name="prefer" value="3">
		 	<img src="${pageContext.request.contextPath}/resources/post/The Lion King.gif" width="180" height="240">
		 	<input type="checkbox" id="prefer" name="prefer" value="2">
		 	<br><br><br>

			<img src="${pageContext.request.contextPath}/resources/post/duet.jpeg" width="180" height="240">
		 	<input type="checkbox" id="prefer" name="prefer" value="1">
		 	<img src="${pageContext.request.contextPath}/resources/post/Cats.gif" width="180" height="240">
		 	<input type="checkbox" id="prefer" name="prefer" value="2">
		 	<img src="${pageContext.request.contextPath}/resources/post/thosedays.png" width="180" height="240">
		 	<input type="checkbox" id="prefer" name="prefer" value="3">
		 	<img src="${pageContext.request.contextPath}/resources/post/dodo.gif" width="180" height="240">
		 	<input type="checkbox" id="prefer" name="prefer" value="4">
		 	<img src="${pageContext.request.contextPath}/resources/post/fuerza.gif" width="180" height="240">
		 	<input type="checkbox" id="prefer" name="prefer" value="5">

		 	<br><br><br>
		 	<img src="${pageContext.request.contextPath}/resources/post/chef.gif" width="180" height="240">
		 	<input type="checkbox" id="prefer" name="prefer" value="5">
		 	<img src="${pageContext.request.contextPath}/resources/post/shadow.png" width="180" height="240">
		 	<input type="checkbox" id="prefer" name="prefer" value="3">
		 	<img src="${pageContext.request.contextPath}/resources/post/Notre Dame de Paris.gif" width="180" height="240">
		 	<input type="checkbox" id="prefer" name="prefer" value="2">
		 	<img src="${pageContext.request.contextPath}/resources/post/The_Man_of_La_Mancha.jpeg" width="180" height="240">
		 	<input type="checkbox" id="prefer" name="prefer" value="1">
		 	<img src="${pageContext.request.contextPath}/resources/post/alcandy.gif" width="180" height="240">
		 	<input type="checkbox" id="prefer" name="prefer" value="4">
			<br><br><br>		 	
		 </div>
	
		<div class="align-center">
			<input type="submit" value="변경하기" class="submit">
			<input type="button" value="홈으로" class="button"
			    onclick="location.href='${pageContext.request.contextPath}/main/musMain.do'"> 
		</div>
	</form:form>
</div>