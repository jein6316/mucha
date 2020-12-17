package kr.spring.musinfo.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.musinfo.dao.ContentsMapper;
import kr.spring.musinfo.vo.CommentsVO;
import kr.spring.musinfo.vo.ContentsVO;

@Service("contentsService")
public class ContentsServiceImpl implements ContentsService{
	@Resource
	ContentsMapper contentsMapper; 


 
	@Override
	public List<String> actorList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return contentsMapper.actorList(map);
	}



	@Override
	public ContentsVO selectContents(int mus_num) {
		// TODO Auto-generated method stub
		return contentsMapper.selectContents(mus_num);
	}



	@Override
	public List<ContentsVO> selectNewest(int mus_num) {
		// TODO Auto-generated method stub
		return contentsMapper.selectNewest(mus_num);
	}



	@Override
	public double selectAvg(int mus_num) {
		// TODO Auto-generated method stub
		return contentsMapper.selectAvg(mus_num);
	}



	@Override
	public int selectNum(int mus_num) {
		// TODO Auto-generated method stub
		return contentsMapper.selectNum(mus_num);
	}



	@Override
	public void updateHit(ContentsVO contentsVO) {
		// TODO Auto-generated method stub
		contentsMapper.updateHit(contentsVO);
	}

}
