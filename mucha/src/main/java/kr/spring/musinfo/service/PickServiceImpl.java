package kr.spring.musinfo.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.main.vo.MusMainVO;
import kr.spring.musinfo.dao.PickMapper;
import kr.spring.musinfo.vo.PickVO;

@Service("pickService")
public class PickServiceImpl implements PickService{
	@Resource
	PickMapper pickMapper;

	@Override
	public void insertPick(PickVO pickVO) {
		pickMapper.insertPick(pickVO);
	}

	@Override
	public void deletePick(PickVO pickVO) {
		pickMapper.deletePick(pickVO);
	}
	
	@Override
	public List<MusMainVO> selectMusPickList(Map<String, Object> map) {
		return pickMapper.selectMusPickList(map);
	}

	@Override
	public int selectRowCount(Map<String, Object> map) {
		return pickMapper.selectRowCount(map);
	}

	@Override
	public int selectPickCount(Map<String, Object> map) {
		return pickMapper.selectPickCount(map);
	}

	
}
