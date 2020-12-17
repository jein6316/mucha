<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<style>
#musical_form{
	height: 800px;
    width: 900px;
}
.info{
	 min-width: 800px;
}
.link{
	min-width: 670px;
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
.button2:hover {
	background-color: #d9534f;
	color: #fff;
}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	/* 요약정보 글자 수 제한*/
	
	$('#mus_summary').on('keyup',function(){
		if($(this).val().length>50){
			$(this).val($(this).val().substring(0,500));
			alert("요약 내용은 500자 이하로 입력하세요.");
			}
		});
	$('#mus_detail').on('keyup',function(){
		if($(this).val().length>50){
			$(this).val($(this).val().substring(0,2000));
			alert("상세 내용은 2000자 이하로 입력하세요.");
			}
		});
	
	$('#mus_name').focus();
	
	$('#musical_form').submit(function(event){
		var check = 0;
		var blank_pattern = /^\s+|\s+$/g;
		var fileCheck = document.getElementById("upload").value;
		var mus_name = $("#mus_name").val();
		var mus_summary = $("#mus_summary").val();
		var mus_detail = $("#mus_detail").val();
		var mus_video = $("#mus_video").val();
		var mus_time = $("#mus_time").val();
			if(mus_name==''||mus_name.replace(blank_pattern,'')==""){
		       alert("제목을 입력하세요.");
		       return false;
		   }else if(!fileCheck){
		       alert("파일을 첨부해 주세요");		      
		       return false;
		   }else if(mus_summary==''||mus_summary.replace(blank_pattern,'')==""){
		       alert("요약 내용을 입력하세요.");		     
		       return false;
		   }else if(mus_detail==''||mus_detail.replace(blank_pattern,'')==""){
		       alert("상세 내용을 입력하세요.");		       
		       return false;
		   }else if(mus_video==''||mus_video.replace(blank_pattern,'')==""){
		       alert("스트리밍 링크를 입력하세요.");		       
		       return false;
		   }else if( mus_time == '' || mus_time <= 0){
	        alert("재생 시간을 입력하세요!");
	        $("#mus_time").focus();	       
	        return false; 
	  	  }
	    $('.actor_box').each(function(index,item){
			if($(this).val()==''||$(this).val().replace(blank_pattern,'')==''){
				check = 1;
				alert('배우 이름을 입력하세요!');
				$(this).focus();
				return false;
			}
			
		});
	    
		if(check == 1) return false;
	
	});
});

function addBox (x) {
    var actors = '<input type="text" name="mus_actor' + '" placeholder="배우 이름 입력" size="10" class="actor_box">';
    $('#mus_actor').append(actors);

  }
function deleteBox (x) {
    var actors = '<input type="text" name="mus_actor' + '" placeholder="배우 이름 입력" size="10" class="actor_box">';
    $('#mus_actor').empty();
    $('#mus_actor').append(actors);
  }
  


</script>
<div class="page-main-style">
	<h2>뮤지컬 등록</h2>
	<form:form commandName="adminMusicalVO" action="adminMusicalRegister.do"
								enctype="multipart/form-data" id="musical_form">
		<form:errors element="div" cssClass="error-color"/>

		<ul>
			<li>
				<label for="mus_name">뮤지컬 제목</label>
				<form:input path="mus_name"/>
				<form:errors path="mus_name" cssClass="error-color"/>
			</li>
			<li>
			<label for="gen_num">뮤지컬 장르</label>
			<select name="gen_num" id="gen_num">
				<option value="1">라이선스</option>
				<option value="2">오리지널</option>
				<option value="3">창작</option>
				<option value="4">어린이/가족</option>
				<option value="5">퍼포먼스</option>
			</select>
			</li>
			<li style="clear:both;">
			<label for="mus_age">등급</label>
			<select name="mus_age" id="mus_age">
				<option value="7">7</option>
				<option value="12">12</option>
				<option value="15">15</option>
				<option value="19">19</option>
			</select>
			</li>
			<li style="clear:both;">
				<label for="upload">포스터</label>
				<input type="file" name="upload" id="upload"
											accept="image/gif,image/png,image/jpeg" class="button2">
			</li>
			<li style="clear:both;">
				<label for="mus_summary">요약 정보</label>
				<form:textarea path="mus_summary" cols="50" rows="7" style="clear:both;" class="info"/>
				<form:errors path="mus_summary" cssClass="error-color"/>
				<br>
				<span id="limit"></span>			
			</li>
			<li>
				<label for="mus_detail">상세 정보</label>
				<form:textarea path="mus_detail" cols="50" rows="10" class="info"/>
				<form:errors path="mus_detail" cssClass="error-color"/>
				<br><br>
			</li>
			
			<li>
				<label for="mus_actor">출연 배우</label>
				<input type="button" value="배우추가" onclick="addBox(this.form)" class="button"/>
				<input type="button" value="초기화" onclick="deleteBox(this.form)" class="button"/>
				<br>
				<div id="mus_actor">
				 <input type="text" name="mus_actor" placeholder="배우 이름 입력" size="10" class="actor_box">
				</div>
				<br>
			</li>
			<li>
				<label for="mus_video">스트리밍 링크</label>
				<form:textarea path="mus_video" cols="50" class="link"/>
				<form:errors path="mus_video" cssClass="error-color"/>
				<br>
			</li>
			<li>
				<label for="mus_time">뮤지컬 재생 시간</label>
				<input type = "number" name="mus_time" id="mus_time" min="0" max="999"/>
				<form:errors path="mus_time" cssClass="error-color"/>
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="등록" class="button">
			<input type="button" value="목록" class="button" onclick="location.href='adminMusicalList.do'">
		</div>
	</form:form>
</div>