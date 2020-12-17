<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<style>

.triangle-right {
      width: 0;
      height: 0;
      border-top: 3px solid transparent;
      border-left: 6px solid pink;
      border-bottom: 3px solid transparent;
}
.star-five {
     margin: 5px 0;
     position: relative;
     display: block;
     color: pink;
     width: 0px;
     height: 0px;
     border-right: 10px solid transparent;
     border-bottom: 7px solid pink;
     border-left: 10px solid transparent;
     transform: rotate(35deg);
}
.star-five:before {
  border-bottom: 8px solid pink;
  border-left: 3px solid transparent;
  border-right: 3px solid transparent;
  position: absolute;
  height: 0;
  width: 0;
  top: -4.5px;
  left: -6.5px;
  display: block;
  content: '';
  transform: rotate(-35deg);
}
.star-five:after {
  position: absolute;
  display: block;
  color: pink;
  top: 3px;
  left: -10.5px;
  width: 0px;
  height: 0px;
  border-right: 10px solid transparent;
  border-bottom: 7px solid pink;
  border-left: 10px solid transparent;
  transform: rotate(-70deg);
  content: '';
}
.heart {
      position: relative;
      width: 20px;
      height: 18px;
}
.heart:before,
.heart:after {
  position: absolute;
  content: "";
  left: 10px;
  top: 0;
  width: 10px;
  height: 16px;
  background: pink;
  border-radius: 10px 10px 0 0;
  transform: rotate(-45deg);
  transform-origin: 0 100%;
}
.heart:after {
  left: 0;
  transform: rotate(45deg);
  transform-origin: 100% 100%;
}

</style>
<!-- 메뉴바 밑에 콘텐츠 썸네일 -->
    <div class="thumbnail"></div>
    <!-- 여기까지 썸네일 -->

    <!-- 썸네일 밑에 겹쳐있는 콘텐츠 정보들입니다. -->
    <div class="content_info-box">

        <!-- 왼쪽 포스터입니다. -->
        <div class="left-column">
            <img src="img/ironrain.jpg" alt="강철비2: 정상회담">
        </div>
        <!-- 여기까지 왼쪽 포스터 -->

        <!-- 포스터 오른쪽 정보들 입니다. -->
        <div class="right-column">

            <!-- 첫번째 줄 작품명 -->
            <div class="content_info">
                <span class="content_title"><input type="text" name="name" id="name"></span>
            </div>
            <!-- 첫번째 줄 작품명 끝 -->

            <!-- 두번째 줄 년도, 장르, 나라-->
            <div class="content_info">
                <span class="content_type"><input type="text" name="genreNtime" id="name"></span>
            </div>
            <!-- 두번째 줄 년도, 장르, 나라 끝 -->

            <!-- 세번째 줄 평점 -->
            <div class="content_info">
                <span class="content_star">평점 ★$(review.sum) ($(review.length )명)</span>
            </div>
            <!-- 세번째 줄 평점 끝 -->

            <!-- 마지막 바로보기, 별점 평가하기, 찜하기 -->
            <div class="content_info">
                <!-- 바로보기 버튼 -->
                	<span class="triangle-right"></span>
                   	<span class="content_watch">바로보기</span>
                <!-- 바로보기 버튼 끝 -->

                <!-- 별점 평가하기 -->
                	<span class="star-five"></span>
                    <span class="js-leaveStar">평가하기</span>
                <!-- 별점 평가하기 끝 -->
                
                <!-- 찜 -->
                	<span class="heart"></span>
                    <span class="wishList">찜하기</span>
                <!-- 찜 끝 -->

            </div>
            <!-- 여기까지가 마지막 줄에 보고싶어요, 별점 평가하기 끝 -->

        </div>
        <!-- 여기까지 오른쪽 정보들 -->
    </div>
    <!-- 여기까지 영화 정보들 입니다 -->

    <!-- 여기서부터 메인 컨텐츠 박스입니다 -->
    <main class="contents_main-box">
        <div class="contents_middle-box">
            <div>
                <div class="leave-comment-box">
                    <span class="go-leave-comment">
                        이 작품에 대한 준혁 님의 평가를 글로 남겨보세요.
                    </span>
                    <span class="leave-comment">코멘트 남기기</span>
                </div>
                <div class="contents_contents-box">
                    <!-- 첫번째(기본정보) 박스입니다 -->
                    <div class="contents_contents_column">
                        <div>
                            <span class="contents_contents_title">기본 정보</span>
                        </div>
                        <!-- 기본정보 더보기 링크 -->
                            <a href="">
                                <span class="contents_contents_more">더보기</span>
                            </a>
                        <!-- 더보기 링크 끝 -->   
                        <span class="contents_contents_summary contents_info">
                            <textarea name="contents" id="contents" cols="40" rows="8"></textarea>
                        </span>
                    </div>
                    <!-- 첫번째(기본정보) 끝입니다 -->

                    <!-- 두번째(출연/제작) 시작 -->
                    <div class="contents_contents_column">
                        <span class="contents_contents_title">출연/제작</span>
                        <div class="contents_contents_container">
                            <div class="contents_contents_content">
                                <div class="contents_contents_profile">
                                    <div>
                                        <span class="profile_name"><input type="text" name="actor1" id="actor1"></span>
                                        <span class="profile_job"><input type="text" name="role_actor1" id="role_actor1"></span>
                                        <span class="profile_name"><input type="text" name="actor2" id="actor2"></span>
                                        <span class="profile_job"><input type="text" name="role_actor2" id="role_actor2"></span>
                                        <span class="profile_name"><input type="text" name="actor3" id="actor3"></span>
                                        <span class="profile_job"><input type="text" name="role_actor3" id="role_actor3"></span>
                                        <span class="profile_name"><input type="text" name="actor4" id="actor4"></span>
                                        <span class="profile_job"><input type="text" name="role_actor4" id="role_actor4"></span>
                                        <span class="profile_name"><input type="text" name="actor5" id="actor5"></span>
                                        <span class="profile_job"><input type="text" name="role_actor5" id="role_actor5"></span>
                                        <span class="profile_name"><input type="text" name="actor6" id="actor6"></span>
                                        <span class="profile_job"><input type="text" name="role_actor6" id="role_actor6"></span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- 두번째(출연/제작) 끝 -->
                    
                    <!-- 세번째(하이라이트) 시작 -->
                    <div class="contents_contents_column">
                        <div>
                            <span class="contents_contents_title">하이라이트</span>
                        </div>
                        <div class="contents_contents_highlight">
                            <a href="https://www.youtube.com/watch?v=YtpFzT1dfrE"></a>
                        </div>
                    </div>
                    <!-- 세번째(하이라이트) 끝 -->

                    <!-- 네번째(별점 그래프) 시작 -->
                    <div class="contents_contents_column">
                        <div>
                            <span class="contents_contents_title">별점 그래프</span>
                            <div>
                                <span class="star_average">평균 ★0</span>
                                <span class="star_people">(0명)</span>
                            </div>
                        </div>
                        <div class="contents_contents_star-box">
                            <img src="img/star_graph.png" alt="별점 그래프" class="star-graph">
                        </div>
                    </div>
                    <!-- 네번째(별점 그래프) 끝 -->
                    
                    <!-- 다섯번째(코멘트) 시작 -->
			<div class="contents_contents_column">
				<div class="column_column">
					<div>
						<span class="contents_contents_title">코멘트</span> <span
							class="contents_contents_title-number">0+</span>
					</div>



				</div>
				<div class="contents_contents_comment-container">
					<div class="comment-nemo">
						<div class="comment_user">
							<img src="img/user_profile.jfif" class="comment_user-img">
							<span class="user_name">sample</span>
						</div>
						<div class="comment_comment">sample</div>
						<div class="comment_feel">
							<span class="comment_feel-good"> <i
								class="fas fa-thumbs-up"></i> 0
							</span> <span class="comment_feel-comment"> <i
								class="fas fa-comment"></i> 0
							</span>
						</div>
						<div class="content_info_star">
							<div class="star_box star1" value="0.5"></div>
							<i class="far fa-star real-star1 real-star"></i>
							<div class="star_box star2" value="1"></div>
							<div class="star_box star3" value="1.5"></div>
							<i class="far fa-star real-star2 real-star"></i>
							<div class="star_box star4" value="2"></div>
							<div class="star_box star5" value="2.5"></div>
							<i class="far fa-star real-star3 real-star"></i>
							<div class="star_box star6" value="3"></div>
							<div class="star_box star7" value="3.5"></div>
							<i class="far fa-star real-star4 real-star"></i>
							<div class="star_box star8" value="4"></div>
							<div class="star_box star9" value="4.5"></div>
							<i class="far fa-star real-star5 real-star"></i>
							<div class="star_box star10" value="5"></div>
						</div>
					</div>
					<div class="comment-nemo">
						<div class="comment_user">
							<img src="img/user_profile.jfif" class="comment_user-img">
							<span class="user_name">sample</span>
						</div>
						<div class="comment_comment">sample</div>
						<div class="comment_feel">
							<span class="comment_feel-good"> <i
								class="fas fa-thumbs-up"></i> 0
							</span> <span class="comment_feel-comment"> <i
								class="fas fa-comment"></i> 0
							</span>
						</div>
					</div>
				</div>
				<!-- 코멘트 더보기 링크 -->
				<a href="/musinfo/reviews.do"><span class="contents_contents_more">더보기</span>
				</a>
				<!-- 코멘트 더보기 링크 끝 -->
			</div>
			<!-- 다섯번째(코멘트) 끝 -->

			<!-- <div class="contents_contents_column">
                        <div>
                            <span class="contents_contents_title">이 작품이 담긴 컬렉션</span>
                            <span class="contents_contents_title-number">143</span>
                        </div>
                    </div>
                    <div class="contents_contents_column">
                        <span class="contents_contents_title">비슷한 작품</span>
                    </div> -->
                </div>
            </div>
            <div class="contents_side-box"></div>
        </div>
    </main>
    <!-- 여기까지 메인 컨텐츠 박스였습니다 -->
