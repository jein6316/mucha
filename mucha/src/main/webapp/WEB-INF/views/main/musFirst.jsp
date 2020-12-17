<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">
   <!--  <link rel="stylesheet" href="CSS/style.css"> -->
<!--     <style>
    body{
         background: url(https://img3.akspic.com/image/672-photograph-blue-kiss-emotion-interaction-1920x1080.jpg?attachment=1) no-repeat center center fixed; 
        -webkit-background-size: cover;
        -moz-background-size: cover;
        -o-background-size: cover;
        background-size: cover;
        overflow-y: scroll;
  		scroll-behavior: smooth;
    }   
    </style> -->
    <title>뮤챠</title>
</head>

<body>

<!-- ========================== swiper start=========================== -->
<!-- Swiper -->
<div class="header-top">
	<div class="top_header">
		<div class="header-logo">
			<a href="${pageContext.request.contextPath}/main/musFirst.do">
				<img src="${pageContext.request.contextPath}/resources/css/admin/MUCHA.png" alt="mucha">
			</a>
		</div>
		<div class="index-startButton">
			<a href="${pageContext.request.contextPath}/member/login.do">
				<span class="top-start_button1">시작하기</span>
			</a>
		</div>
	</div>
</div>

<div class="swiper-container">
	<div class="swiper-wrapper">
	
		<div class="swiper-slide">		
			<div src="${pageContext.request.contextPath}/resources/images/first5.jpg" class="wallpaper1">
				<div class="main_promotion">
					<span class="main_promotion-one">
						매주 5백 편 신작 업데이트, 뮤지컬 무제한 감상
					</span>
					<span class="main_promotion-two">
						Apple 앱스토어 "2018 올해를 빛낸 최고작" 선정
					</span>
					<a href="signUp.html">
						<span class="main_promotion-three">
							시작하기
						</span>
					</a>
				</div>
			</div>
		</div>		
		
		<div class="swiper-slide">
			<div class="main_promotion">
				<span class="main_promotion-one">
					PC, 스마트폰, 태블릿, 크롬캐스트,TV에서
				</span>
				<span class="main_promotion-two">
					1만 편의 작품을 언제 어디서나 감상
				</span>
				<a href="signUp.html">
					<span class="main_promotion-three">
						시작하기
					</span>
				</a>
			</div>
		</div>
		
		<div class="swiper-slide">
			<div class="main_promotion">
				<span class="main_promotion-one">
					최고의 화질
				</span>
				<span class="main_promotion-two">
					HD부터 Full-HD까지
				</span>
				<a href="signUp.html">
					<span class="main_promotion-three">
						시작하기
					</span>
				</a>
			</div>
		</div>
		
		<div class="swiper-slide">
			<div class="main_promotion">
				<span class="main_promotion-one">
					2억개 평가 기반 최고의 추천 엔진
				</span>
				<span class="main_promotion-two">
					  소중한 2시간을 낭비할 순 없으니까
				</span>
				<a href="signUp.html">
					<span class="main_promotion-three">
						시작하기
					</span>
				</a>
			</div>
		</div>
	</div>
    
    <!-- Add Pagination -->
    <div class="swiper-pagination"></div>
    <!-- Add Arrows -->
    <div class="swiper-button-next"></div>
    <div class="swiper-button-prev"></div>
</div>  

<!-- Initialize Swiper -->
<script>
     var swiper = new Swiper('.swiper-container', {
         direction: 'vertical',
         slidesPerView: 1,
         spaceBetween: 30,
         mousewheel: true,
         pagination: {
             el: '.swiper-pagination',
             clickable: true,
         },
     });
</script>

<!-- ========================== swiper end =========================== -->

  <section class="bottom">
      <span class="arrow_down">
        <a href="startPage2.html">
          <i class="fa fa-arrow-circle-o-down" aria-hidden="true"></i>
        </a>
      </span>
  </section>

  
</body>
</html>