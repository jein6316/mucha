<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

.file{
	border:0;
	outline:0;
	background-color: white;
	color: #black;
}
.file:hover{
	background-color: #d9534f;
	color: #fff;
}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#image_btn').click(function(){
			//이미지파일 선택 태그가 노출
			$('#image_choice').show();
			//수정 버튼 숨기기
			$(this).hide();
		});
		
		//변경전 이미지 보관
		var image_path;
		//변경 이미지 보관
		var my_image;
		$('#upload').change(function(){
			var upload = document.getElementById('upload');
			my_image = upload.files[0];
			if(my_image!=null){
				var reader = new FileReader();
				reader.readAsDataURL(upload.files[0]);
				
				//사진 업로드전 미리보기 처리
				reader.onload = function(){
					//변경전 이미지 보관
					image_path = $('.my-image').attr('src');
					//변경된 이미지 미리보기 세팅
					$('.my-image').attr('src',reader.result);
				};
			}
		});
		
		//이미지 초기화
		$('#image_reset').click(function(){
			$('.my-image').attr('src',image_path);
			$('#upload').val('');
			$('#image_choice').hide();
			$('#image_btn').show();
		});
		
		$('#image_submit').click(function(){
			if($('#upload').val()==''){
				alert('파일을 선택하세요');
				$('#upload').focus();
				return
			}
			//파일전송
			var form_data = new FormData();
							//파라미터네임, 파일경로
			form_data.append('upload',my_image);
			$.ajax({
				data:form_data,
				type:'post',
				url:'updateMyImage.do',
				dataType:'json',
				cache:false,
				contentType:false,
				enctype:'multipart/form-data',
				processData:false,
				success:function(data){
					if(data.result == 'logout'){
						alert('로그인 후 사용하세요');
					}else if(data.result == 'success'){
						alert('프로필 사진이 수정되었습니다 !');
						$('#upload').val('');
						$('#image_choice').hide();
						$('#image_btn').show();
					}else{
						alert('파일 전송 오류 발생..');
					}
				},
				error:function(){
					alert('네트워크 오류발생')
				}
			});			
			
		});
		
	});
</script>

	<h2>프로필 이미지 변경</h2>
<div class="page-main-style" align="center">
	<ul>
		<li>
			<c:if test="${empty user.mem_imagename}">
			<img src="${pageContext.request.contextPath}/resources/images/blank.png" width="100" height="100" class="my-image">	
			</c:if>
			<c:if test="${!empty user.mem_imagename}">
			<img src="${pageContext.request.contextPath}/member/imageView.do" width="100" height="100" class="my-image">
			</c:if>
			<br><br>
		</li>
		<li>
			<input type="button" value="수정" id="image_btn" class="button">
		<div id="image_choice" style="display:none;">
				<input type="file" id="upload" accept="image/gif,image/png,image/jpeg" class="file"><br>
				<input type="button" value="변경하기" id="image_submit" class="button" >
				<input type="button" value="취소하기" id="image_reset" class="button">      
			</div>
		</li>
	</ul>
</div>






