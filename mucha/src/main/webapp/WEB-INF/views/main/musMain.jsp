<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<style>
.contents_title,.type1-content-box{
padding-left:14.5px;
}
</style>
<!-- 메인 슬라이드 -->
<!-- ========================== swiper start=========================== -->
<div>
<!-- Swiper -->
  <div class="swiper-container swiper1">
    <div class="swiper-wrapper">
      <div class="swiper-slide"><img src="${pageContext.request.contextPath}/resources/images/main2.jpg" alt=""></div>
      <div class="swiper-slide"><img src="${pageContext.request.contextPath}/resources/images/main5.png" alt=""></div>
      <div class="swiper-slide"><img src="${pageContext.request.contextPath}/resources/images/main6.png" alt=""></div>
      <div class="swiper-slide"><img src="${pageContext.request.contextPath}/resources/images/main7.jpg" alt=""></div>
    </div>
    
    <!-- Add Pagination -->
    <div class="swiper-pagination"></div>
    <!-- Add Arrows -->
    <div class="swiper-button-next"></div>
    <div class="swiper-button-prev"></div>
  </div>  

  <!-- Initialize Swiper -->
  <script>
    new Swiper('.swiper1', {
      slidesPerView: 1,
      spaceBetween: 0, /* 사진과 사진 사이의 간격 */
      loop: true,
	  
	  /* 자동 넘기기 */
	  autoplay: {
        delay: 2500,
        disableOnInteraction: false,
      },
	  
	  pagination: {
        el: '.swiper-pagination',
        clickable: true,
      },
      navigation: {
        nextEl: '.swiper-button-next',
        prevEl: '.swiper-button-prev',
      },
    });
  </script>
</div>
<!-- ========================== swiper end =========================== -->



<!-- 추천 작품 목록 -->

<c:if test="${empty user}">
	<%
		response.sendRedirect(request.getContextPath()+"/member/login.do");
	%>
</c:if>

<c:if test="${!empty user}">
	<c:if test="${count == 0}">
		<div class="align-center">등록된 뮤지컬이 없습니다.</div>
	</c:if>
	<c:if test="${count > 0}">
		<div class="contents">
			
			<!-- 신작 슬라이드 -->
			<div class="contents_title">새로 올라온 작품</div>
			<div class="type1-contents_contents">	
			<!-- ========================== swiper start=========================== -->
				<!-- Swiper -->
				  <div class="swiper-container swiper2">
				    <div class="swiper-wrapper">	
						<c:forEach var="musMain" items="${latestList}">
						<div class="swiper-slide">
							<div class="type1-content-box">			
								<a href="${pageContext.request.contextPath}/musinfo/musinfoDetail.do?mus_num=${musMain.mus_num}">
									<img src="postView.do?mus_num=${musMain.mus_num}" style="max-width: 200px;">
								</a>
								<a href="${pageContext.request.contextPath}/musinfo/musinfoDetail.do?mus_num=${musMain.mus_num}">
									<span class="type1-content_title">${musMain.mus_name}</span>
								</a>
							</div>
						</div>
						</c:forEach>					
				    </div>
				    
				    <!-- Add Pagination -->
				    <div class="swiper-pagination"></div>
				    <!-- Add Arrows -->
				    <div class="swiper-button-next"></div>
				    <div class="swiper-button-prev"></div>
				  </div>  
				
				  <!-- Initialize Swiper -->
				  <script>
				    var swiper4 = new Swiper('.swiper2', {
				      slidesPerView: 5,
				      spaceBetween: 0, /* 사진과 사진 사이의 간격 */
				      loop: true,
				      slidesPerGroup : 5,
					  
				      loopFillGroupWithBlank : true,
				
				      navigation: {
				        nextEl: '.swiper-button-next',
				        prevEl: '.swiper-button-prev',
				      },
				    });
				  </script>
			<!-- ========================== swiper end =========================== -->
			</div>	
			
			
			<!-- 인기작 슬라이드 -->
			<div class="contents_title">뮤챠 최고 인기작</div>
			<div class="type1-contents_contents">	
			<!-- ========================== swiper start=========================== -->
				<!-- Swiper -->
				  <div class="swiper-container swiper3">
				    <div class="swiper-wrapper">			      
				     
				     	<c:forEach var="musMain" items="${popularList}">
						<div class="swiper-slide">
							<div class="type1-content-box">			
								<a href="${pageContext.request.contextPath}/musinfo/musinfoDetail.do?mus_num=${musMain.mus_num}">
									<img src="postView.do?mus_num=${musMain.mus_num}" style="max-width: 200px;">
								</a>
								<a href="${pageContext.request.contextPath}/musinfo/musinfoDetail.do?mus_num=${musMain.mus_num}">
									<span class="type1-content_title">${musMain.mus_name}</span>
								</a>
							</div>
						</div>
						</c:forEach>
				    </div>
				    
				    <!-- Add Pagination -->
				    <div class="swiper-pagination"></div>
				    <!-- Add Arrows -->
				    <div class="swiper-button-next"></div>
				    <div class="swiper-button-prev"></div>
				  </div>  
				
				  <!-- Initialize Swiper -->
				  <script>
				    var swiper4 = new Swiper('.swiper3', {
				      slidesPerView: 5,
				      spaceBetween: 0, /* 사진과 사진 사이의 간격 */
				      loop: true,
				      slidesPerGroup : 5,
					  
				      loopFillGroupWithBlank : true,
				
				      navigation: {
				        nextEl: '.swiper-button-next',
				        prevEl: '.swiper-button-prev',
				      },
				    });
				  </script>
			<!-- ========================== swiper end =========================== -->
			</div>
			
		</div>	
	</c:if>
</c:if>
	
	

<!-- 선호작품 슬라이드 -->	

<c:if test="${!empty user}">
	<c:if test="${user.auth == 0}">
		<c:if test="${prefer == 0}">
		</c:if>
	</c:if>
	<c:if test="${user.auth!=0 && prefer > 0}">
		<div class="contents">
			<div class="contents_title">${user.nickname}님이 선호하는 장르의 작품</div>
			<div class="type1-contents_contents">	
<!-- ========================== swiper start=========================== -->
			<!-- Swiper -->
			  <div class="swiper-container swiper4">
			    <div class="swiper-wrapper">			      
			      
			      	<c:forEach var="musMain" items="${preferList}">
			      	<div class="swiper-slide">
						<div class="type1-content-box">			
							<a href="${pageContext.request.contextPath}/musinfo/musinfoDetail.do?mus_num=${musMain.mus_num}">
								<img src="postView.do?mus_num=${musMain.mus_num}" style="max-width: 200px;">
							</a>
							<a href="${pageContext.request.contextPath}/musinfo/musinfoDetail.do?mus_num=${musMain.mus_num}">
								<span class="type1-content_title">${musMain.mus_name}</span>
							</a>
						</div>
					</div> 
					</c:forEach>		      
			          
			    </div>
			    
			    <!-- Add Pagination -->
			    <div class="swiper-pagination"></div>
			    <!-- Add Arrows -->
			    <div class="swiper-button-next"></div>
			    <div class="swiper-button-prev"></div>
			  </div>  
			
			  <!-- Initialize Swiper -->
			  <script>
			    var swiper4 = new Swiper('.swiper4', {
			      slidesPerView: 5,
			      spaceBetween: 0, /* 사진과 사진 사이의 간격 */
			      loop: true,
			      slidesPerGroup : 5,
				  
			      loopFillGroupWithBlank : true,
			
			      navigation: {
			        nextEl: '.swiper-button-next',
			        prevEl: '.swiper-button-prev',
			      },
			    });
			  </script>
<!-- ========================== swiper end =========================== -->
			</div>
		</div>
	</c:if>	
</c:if>		
	
	
	
	
<!-- 찜한 작품 슬라이드 -->	

<c:if test="${!empty user}">
	<c:if test="${user.auth == 0}">
		<c:if test="${pick_count == 0}">
		</c:if>
	</c:if>
	<c:if test="${pick_count > 0}">
		<div class="contents">
			<div class="contents_title">${user.nickname}님이 찜한 작품 작품</div>
			<div class="type1-contents_contents">	
<!-- ========================== swiper start=========================== -->
			<!-- Swiper -->
			  <div class="swiper-container swiper5">
			    <div class="swiper-wrapper">
			
					
					<c:forEach var="musMain" items="${pickList}">
					<div class="swiper-slide">
						<div class="type1-content-box">			
							<a href="${pageContext.request.contextPath}/musinfo/musinfoDetail.do?mus_num=${musMain.mus_num}">
								<img src="postView.do?mus_num=${musMain.mus_num}" style="max-width: 200px;">
							</a>
							<a href="${pageContext.request.contextPath}/musinfo/musinfoDetail.do?mus_num=${musMain.mus_num}">
								<span class="type1-content_title">${musMain.mus_name}</span>
							</a>
						</div>
					</div>
					</c:forEach>
			      
			          
			    </div>
			    
			    <!-- Add Pagination -->
			    <div class="swiper-pagination"></div>
			    <!-- Add Arrows -->
			    <div class="swiper-button-next"></div>
			    <div class="swiper-button-prev"></div>
			  </div>  
			
			  <!-- Initialize Swiper -->
			  <script>
			    var swiper4 = new Swiper('.swiper5', {
			      slidesPerView: 5,
			      spaceBetween: 0, /* 사진과 사진 사이의 간격 */
			      loop: true,
			      slidesPerGroup : 5,
				  
			      loopFillGroupWithBlank : true,
			
			      navigation: {
			        nextEl: '.swiper-button-next',
			        prevEl: '.swiper-button-prev',
			      },
			    });
			  </script>
<!-- ========================== swiper end =========================== -->
			</div>
		</div>
	</c:if>	
</c:if>		
