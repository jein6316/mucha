package kr.spring.musinfo.service;

import java.util.List;
import java.util.Map;

import kr.spring.main.vo.MusMainVO;
import kr.spring.musinfo.vo.PickVO;

public interface PickService {
	
	public void insertPick(PickVO pickVO);	
	
	public void deletePick(PickVO pickVO);
	
	public List<MusMainVO> selectMusPickList(Map<String, Object> map);
	
	public int selectRowCount(Map<String, Object> map);
	
	public int selectPickCount(Map<String, Object> map);
}

