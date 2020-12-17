package kr.spring.main.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.main.dao.MusMainMapper;
import kr.spring.main.vo.MusMainVO;

@Service("MusMainService")
public class MusMainServiceImpl implements MusMainService{
	
	@Resource
	MusMainMapper musMainMapper;
	
	@Override
	public List<MusMainVO> selectMusMainList(Map<String, Object> map) {
		return musMainMapper.selectMusMainList(map);
	}

	@Override
	public int selectMusMainCount(Map<String, Object> map) {
		return musMainMapper.selectMusMainCount(map);
	}
	
	@Override
	public MusMainVO selectMusMain(int mus_num) {
		return musMainMapper.selectMusMain(mus_num);
	}

	@Override
	public List<MusMainVO> selectMusLatestList(Map<String, Object> map) {
		return musMainMapper.selectMusLatestList(map);
	}

	@Override
	public List<MusMainVO> selectMusPopularList(Map<String, Object> map) {
		return musMainMapper.selectMusPopularList(map);
	}

	@Override
	public List<MusMainVO> selectMusPreferList(Map<String, Object> map) {
		return musMainMapper.selectMusPreferList(map);
	}

	@Override
	public int selectMusPreferCount(Map<String, Object> map) {
		return musMainMapper.selectMusPreferCount(map);
	}

	/*@Override
	public List<MusMainVO> selectMusPickList(Map<String, Object> map) {
		return musMainMapper.selectMusPickList(map);
	}

	@Override
	public int selectMusPickCount(Map<String, Object> map) {
		return musMainMapper.selectMusPickCount(map);
	}*/

	//카테고리 갯수
	@Override
	public int selectLicenseCount(Map<String, Object> map) {
		return musMainMapper.selectLicenseCount(map);
	}

	@Override
	public int selectOriginalCount(Map<String, Object> map) {
		return musMainMapper.selectOriginalCount(map);
	}

	@Override
	public int selectCreationCount(Map<String, Object> map) {
		return musMainMapper.selectCreationCount(map);
	}

	@Override
	public int selectFamilyCount(Map<String, Object> map) {
		return musMainMapper.selectFamilyCount(map);
	}

	@Override
	public int selectPerformanceCount(Map<String, Object> map) {
		return musMainMapper.selectPerformanceCount(map);
	}
	
	//카테고리 리스트 
	@Override
	public List<MusMainVO> selectLicense(Map<String, Object> map) {
		return musMainMapper.selectLicense(map);
	}

	@Override
	public List<MusMainVO> selectOriginal(Map<String, Object> map) {
		return musMainMapper.selectOriginal(map);
	}

	@Override
	public List<MusMainVO> selectCreation(Map<String, Object> map) {
		return musMainMapper.selectCreation(map);
	}

	@Override
	public List<MusMainVO> selectFamily(Map<String, Object> map) {
		return musMainMapper.selectFamily(map);
	}

	@Override
	public List<MusMainVO> selectPerformance(Map<String, Object> map) {
		return musMainMapper.selectPerformance(map);
	}

	
}
