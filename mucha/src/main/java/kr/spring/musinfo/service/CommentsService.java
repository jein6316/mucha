package kr.spring.musinfo.service;

import java.util.List;
import java.util.Map;

import kr.spring.musinfo.vo.CommentsVO;

public interface CommentsService {
	public List<CommentsVO> selectList(Map<String,Object> map);
	public int selectRowCount(Map<String,Object> map);
	public void insertComments(CommentsVO commentsVO);
	public CommentsVO selectComments(int rev_num);
	public void updateComments(CommentsVO commentsVO);
	public void deleteComments(int rev_num);
	public int selectReviewCount(int mus_num);
	public int selectReviewRatings(int mus_num, int mem_num);
}
