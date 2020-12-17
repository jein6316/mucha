package kr.spring.admin.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Update;

import kr.spring.admin.vo.AdminMusicalVO;
import kr.spring.musinfo.vo.CommentsVO;

public interface AdminMusicalService {
	// 뮤지컬 등록 페이지
	public void insertMusical(AdminMusicalVO adminMusical);

	// 뮤지컬 리스트
	// 리스트
	public List<AdminMusicalVO> selectList(Map<String, Object> map);

	// 글의 갯수 구하기
	public int selectRowCount(Map<String, Object> map);

	// 뮤지컬 수정폼 보기
	public AdminMusicalVO selectMusical(Integer mus_num);

	// 뮤지컬 수정하기
	public void updateMusical(AdminMusicalVO adminMusical);

	// 뮤지컬 삭제
	public void deleteMusical(Integer mus_num);

	// 리뷰 갯수 구하기
	public int selectReviewsRowCount(Map<String, Object> map);

	// 리뷰 리스트
	public List<CommentsVO> selectReviewsList(Map<String, Object> map);

	//가려진 리뷰 리스트 갯수
	public int selectHiddenReviewsRowCount(Map<String, Object> map);
	
	//가려진 리뷰 리스트
	public List<CommentsVO> selectHiddenReviewsList(Map<String, Object> map);
	
	// 숨길 리뷰 저장
	public void saveReview(Integer rev_num);

	// 뮤지컬 리뷰 숨기기
	public void hideReview(Integer rev_num);

	// 리뷰 되돌리기
	public void returnReview(Integer rev_num);
	
	

}
