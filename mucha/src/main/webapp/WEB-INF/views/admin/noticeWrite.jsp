<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
/*ck에디터 사용시 입력 박스의 높이 지정*/
.ck-editor__editable_inline {
    min-height: 450px;
    min-width: 950px;
    color:#000000;
}
#notice_form{
	width:1000px;
}
#no_title{
	width:500px;
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
<script src="https://cdn.ckeditor.com/ckeditor5/23.1.0/classic/ckeditor.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/uploadAdapter.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/videoAdapter.js"></script>
<script type="text/javascript">
	$(document).ready(
		function() {
			$("#no_title").focus();
			//제목 글자수 제한
			$(document).ready(function(){
				$('#no_title').on('keyup',function(){
					if($(this).val().length>50){
						$(this).val($(this).val().substring(0,50));
						alert("제목은 50자 이하로 입력하세요.");
						}
					});
				});
			//제목 입력 체크
			$('#notice_form').submit(
				function(event) {
					var no_title = $("#no_title").val();
					var no_content = $("#no_content").val();
					if (no_title == '' || no_title.trim() == '') {
						alert("제목을 입력하세요.");
						$("#no_title").focus();
						return false;
					}
		//게시 종료일 입력 체크
		var date = new Date(); 
		var year = date.getFullYear(); 
		var month = new String(date.getMonth()+1); 
		var day = new String(date.getDate()); 
		// 한자리수일 경우 0을 채워준다. 
		if(month.length == 1){ 
		  month = "0" + month; 
		} 
		if(day.length == 1){ 
		  day = "0" + day; 
		} 
	
		var getToday = year + month + day;
		if ($("#noticeDate").val() == '') {
			alert("게시물 공개 종료일을 선택하세요");
			return false;
			}
		var noticeDate=$("#noticeDate").val().split("-");
		var noticeYear=noticeDate[0];
		var noticeMonth=noticeDate[1];
		var noticeDay=noticeDate[2];
		noticeDate= noticeYear+noticeMonth+noticeDay;
		if (getToday >= noticeDate) {
			alert("게시물 공개 종료일은 내일 날짜부터 가능합니다.");
			return false;
			}
		});
	});
</script>
<div >
	<h2>공지사항 작성</h2>
	<form:form commandName="noticeVO" action="noticeWrite.do" id="notice_form">
		<div>
			<div>
				<label for="no_title">제목</label>
			</div>
			<form:input path="no_title"/>
		</div>
		<hr>
          <div class="col_c" style="margin-bottom: 30px">
                <div class="input-group">                 
                  <form:textarea path="no_content" />
                  <%-- (주의)uploadAdapter.js에 업로드 경로가 명시되어 있음. 주소가 변경되면 수정할 것 --%>
                   <script>
				 function MyCustomUploadAdapterPlugin(editor) {
					    editor.plugins.get('FileRepository').createUploadAdapter = (loader) => {
					        return new UploadAdapter(loader);
					    }
					}
				 
				 ClassicEditor
		            .create( document.querySelector( '#no_content' ),{
		            	extraPlugins: [MyCustomUploadAdapterPlugin]
		            })
		            .catch( error => {
		                console.error( error );
		            } );
			    </script>          
                </div>
            </div> 
         <hr>
         	<div>
         		<label for="noticeDate">게시물 공개 종료일</label>
         		<input type="date" id="noticeDate" name="noticeDate"/>
         	</div> 
         <br>
	  <div class="align-center">
			<input type="submit" value="작성" class="button">
			<input type="button" value="목록" class="button" onclick="location.href='noticeList.do'">
	  </div>
	</form:form>
</div>







