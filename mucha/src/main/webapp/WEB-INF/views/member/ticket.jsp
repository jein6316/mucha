<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
		//체크한 결제수단
		//if문 아래 연결페이지 넣어서 결제 수단별 결제 기능 --------------------?
		$('input[type="radio"]').click(function(){
			if($('input[type="radio"]:checked').val() == 'card'){
				alert('신용카드로 결제합니다. \n진행하시겠습니까?');
			}else if($('input[type="radio"]:checked').val() == 'phone'){
				alert('스마트폰으로 결제합니다. \n진행하시겠습니까? ');
			}else if($('input[type="radio"]:checked').val() == 'kakao'){
				alert('카카오페이로 결제합니다. \n진행하시겠습니까?');
			}
		});
	});
	
</script>
<div>
	<h2>이용권 구매</h2>
	
		<form:errors element="div" cssClass="error-color"/>
		<form:form action="ticket.do" commandName="memberVO">			
		<div align="center">결제수단 선택 </div><br>
		<div align="center">
			<input type="radio" id="card" name="radio" value="card">&nbsp;신용카드&nbsp;&nbsp;
			<input type="radio" id="phone" name="radio" value="phone">&nbsp;스마트폰&nbsp;&nbsp;
			<input type="radio" id="kakao" name="radio" value="kakao">&nbsp;카카오페이
		</div>
		<br>
		
		<div class="align-center">
		
			<input type="submit" value="결제 진행" class="submit">
			<input type="button" value="홈으로" class="button"
			    onclick="location.href='${pageContext.request.contextPath}/main/musMain.do'"> 
		</div>
		</form:form>
		</div>	    
					    
			
	
