package kr.spring.musinfo.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.musinfo.dao.CommentsMapper;
import kr.spring.musinfo.service.CommentsService;
import kr.spring.musinfo.vo.CommentsVO;
         //빈 이름
@Service("commentsService")
public class CommentsServiceImpl implements CommentsService{
	@Resource
	CommentsMapper commentsMapper;
			@Override
			public void insertComments(CommentsVO commentsVO) {
				// TODO Auto-generated method stub
				commentsMapper.insertComments(commentsVO);
			}
			
			@Override
			public CommentsVO selectComments(int rev_num) {
				// TODO Auto-generated method stub
				return commentsMapper.selectComments(rev_num);
			}

			@Override
			public void updateComments(CommentsVO commentsVO) {
				// TODO Auto-generated method stub
				commentsMapper.updateComments(commentsVO);
			}

			@Override
			public void deleteComments(int rev_num) {
				// TODO Auto-generated method stub
				commentsMapper.deleteComments(rev_num);
			}

			@Override
			public List<CommentsVO> selectList(Map<String, Object> map) {
				// TODO Auto-generated method stub
				return commentsMapper.selectList(map);
			}

			@Override
			public int selectRowCount(Map<String, Object> map) {
				// TODO Auto-generated method stub
				return commentsMapper.selectRowCount(map);
			}

			@Override
			public int selectReviewCount(int mus_num) {
				// TODO Auto-generated method stub
				return commentsMapper.selectReviewCount(mus_num);
			}

			@Override
			public int selectReviewRatings(int mus_num,int mem_num ) {
				// TODO Auto-generated method stub
				return commentsMapper.selectReviewRatings(mus_num,mem_num);
			}

/*			@Override
			public List<CommentsVO> selectReviewRatings(Map<String, Object> map) {
				// TODO Auto-generated method stub
				return commentsMapper.selectReviewRatings(map);
			}
*/



			


}
