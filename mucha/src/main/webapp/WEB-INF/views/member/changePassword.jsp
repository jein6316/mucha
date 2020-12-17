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
		var chk = 1;
		//비밀번호 변경 체크
		//변경 비밀번호 입력시 변경 비밀번호 확인과 일치여부 체크
		$('#password').keyup(function(){
			if($('#confirm_password').val()!='' &&
					 $('#confirm_password').val()!=$(this).val()){
				$('#message_password').text('비밀번호 불일치').css('color','red');
			}else if($('#confirm_password').val()!='' &&
					$('#confirm_password').val()==$(this).val()){
				$('#message_password').text('비밀번호 일치').css('color','blue');
			}
		});
 		//변경 비밀번호 확인 입력시 변경 비밀번호와 일치여부 체크
		$('#confirm_password').keyup(function(){
			if($('#password').val()!='' &&
					 $('#password').val()!=$(this).val()){
				$('#message_password').text('비밀번호 불일치').css('color','red');
			}else if($('#password').val()!='' &&
					$('#password').val()==$(this).val()){
				$('#message_password').text('비밀번호 일치').css('color','blue');
			}
		});
		
		$('#change_form').submit(function(){
			if($('#now_password').val()==''){
				chk=0;
				alert('현재 비밀번호를 입력하세요');
				$('#now_password').focus();
				return false;
			}
			if($('#password').val()==''){
				chk=0;
				alert('변경 비밀번호를 입력하세요');
				$('#password').focus();
				return false;
				
			}
			if($('#confirm_password').val()==''){
				chk=0;
				alert('변경 비밀번호 확인을 입력하세요');
				$('#confirm_password').focus();
				return false;
				
			}
			if($('#password').val()!=$('#confirm_password').val()){
				chk=0;
				alert('새 비밀번호와 확인이 불일치합니다');
				return false;
				
			}
			if(($('#now_password').val()).equals($('#password').val())){
				chk=0;
				alret('현재 비밀번호와 새 비밀번호가 동일합니다');
				return false;
			}
		});
	});
</script>

<div class="page-main-style">
	<h2>비밀번호 변경</h2>
	<form:form id="change_form" action="changePassword.do" commandName="memberVO">
		<form:errors element="div" cssClass="error-color"/>
		<ul>
			<li>
				<label for="now_password">현재 비밀번호</label>
				<form:password path="now_password"/><br>
				<form:errors path="now_password" cssClass="error-color"/>
			</li>
			<li>
				<label for="password">변경할 비밀번호</label>
				<form:password path="password"/><br>
				<form:errors path="password" cssClass="error-color"/>
			</li>
			<li>
				<label for="confirm_password">변경 비밀번호 확인</label>
				<input type="password" id="confirm_password"><br>
				<span id="message_password" class="error-color"></span>
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="변경" class="submit">
 			<input type="button" value="홈으로" class="button"
			    onclick="location.href='${pageContext.request.contextPath}/main/musMain.do'"> 
		</div>
	</form:form>
</div>







