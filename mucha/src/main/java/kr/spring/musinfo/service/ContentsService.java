package kr.spring.musinfo.service;



import java.util.List;
import java.util.Map;

import kr.spring.musinfo.vo.CommentsVO;
import kr.spring.musinfo.vo.ContentsVO;

public interface ContentsService {
	public ContentsVO selectContents(int mus_num);
	public List<String> actorList(Map<String,Object> map);
	public List<ContentsVO> selectNewest(int mus_num);
	public double selectAvg(int mus_num);
	public int selectNum(int mus_num);
	public void updateHit(ContentsVO contentsVO);
}
