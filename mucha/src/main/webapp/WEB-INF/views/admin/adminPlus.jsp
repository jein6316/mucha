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
</style> 
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){			
		//0->1 체크한것, 0->0체크안된것
		var checkId = 0;
		
		//이메일 중복 체크
		$('#confirmEmail').click(function(){
			if($('#email').val()==''){
				$('#message_email').css('color','red').text('이메일을 입력하세요');
				$('#email').focus();
				return;
			}
			

			/* var regMsg = new RegExp('^[A-Za-z0-9+]{4,10}$'); */
		 	/* var regMsg = /^[A-Za-z0-9+]{4,10}$/; */
		 	var regMsg =  /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
			if(!regMsg.test($('#email').val())){
				$('#message_email').css('color','red').text('이메일 형식을 맞춰 입력해주세요');
				$('#email').focus();
				return;
			}
			 
			$('#message_email').text();//메시지초기화
			$('#loading').show();//로딩이미지 노출	
			
			$.ajax({
				url:'confirmEmail.do',
				type:'post',
				data:{email:$('#email').val()},
				dataType:'json',
				cache:false,
				timeout:30000,
				success:function(data){
					$('#loading').hide();//로딩 이미지 감추기
					
					if(data.result == 'emailNotFound'){
						$('#message_email').css('color','blue').text('등록가능Email');
						checkId = 1;
					}else if(data.result == 'emailDuplicated'){
						$('#message_email').css('color','red').text('중복된Email');
						$('#email').val('').focus();
						checkId = 0;
					}else{
						checkId = 0;
						alert('Email중복체크 오류');
					}					
				},
				error:function(){
					checkId = 0;
					$('#loading').hide();//로딩 이미지 감추기
					alert('네트워크 오류 발생');
				}
			});
		});
		
		//아이디 중복 안내 메세지 초기화 및 아이디 중복 값 초기화
		$('#register_form #email').keydown(function(){
			checkId = 0;
			$('#message_email').text('');
		});
		
		//submit이벤트 발생시 id 중복체크 여부 확인
		$('#register_form').submit(function(){
			
			if(checkId==0){
				$('#message_email').css('color','red').text('이메일 중복체크 필수')
				$('#email').focus();
				return false;
			}
			//생일 선택여부  체크
			var birth = $("#birth").val();
			    if( birth == ''){
			        alert("생일을 선택하세요!");
			        return false; 
			    }
		});		
	});

</script> 
<div class="page-main-style">
	<h2>관리자 추가</h2>
	<form:form id="register_form" action="adminPlus.do" commandName="memberVO">
		<form:errors element="div" cssClass="error-color"/>
		<ul>
			<li>
				<label for="email">이메일</label>
				<form:input path="email"/>
				<input type="button" id="confirmEmail" value="Email 확인" class="button">
 				<img src="${pageContext.request.contextPath}/resources/images/ajax-loader.gif" 
				      width="16" height="16" style="display:none;" id="loading">
				<span id="message_email"></span>
				<form:errors path="email" cssClass="error-color"/>        
			</li>
			<li>
				<label for="nickname">닉네임</label>
				<form:input path="nickname"/>
				<form:errors path="nickname" cssClass="error-color"/>
			</li>
			<li>
				<label for="password">비밀번호</label>
				<form:password path="password"/>
				<form:errors path="password" cssClass="error-color"/>
			</li>
			<li>
				<label for="confirm_password">비밀번호 확인</label>
				<input type="password" id="confirm_password">
				<span id="message_email" class="error-color"></span>
			</li>
			<li>
				<label for="birth">생년월일</label>
				<input type="date" id="birth" name="birth"/>
				<form:errors path="birth" cssClass="error-color"/>
			</li>
			<li>
				<label for="phone">연락처</label>
				<form:input path="phone"/>
				<form:errors path="phone" cssClass="error-color"/>
			</li>
		</ul>


		<div class="align-center">
			<input type="submit" value="전송" class="button">
			<input type="button" value="돌아가기" class="button"
			    onclick="location.href='${pageContext.request.contextPath}/admin/adminManagerList.do'">
		</div>
	</form:form>
</div>







