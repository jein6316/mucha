package kr.spring.main.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import kr.spring.main.vo.MusMainVO;


public interface MusMainMapper {
	// 뮤지컬 검색 리스트
	public List<MusMainVO> selectMusMainList(Map<String, Object> map);

	// 뮤지컬 리스트 갯수 구하기
	@Select("SELECT COUNT(*) FROM musical")
	public int selectMusMainCount(Map<String, Object> map);
	
	// 뮤지컬 컬럼 한 줄 구하기
	@Select("SELECT * FROM musical WHERE mus_num=#{mus_num}")
	public MusMainVO selectMusMain(int mus_num);
	
	// 신작품순 리스트
	@Select("SELECT * FROM musical ORDER BY mus_regdate DESC")
	public List<MusMainVO> selectMusLatestList(Map<String, Object> map);
	
	// 신작품순 리스트 갯수 구하기
	//public int selectMusLatestCount(Map<String, Object> map);
	
	// 인기순 리스트
	@Select("SELECT * FROM musical ORDER BY mus_hit DESC")
	public List<MusMainVO> selectMusPopularList(Map<String, Object> map);
	
	// 인기순 리스트 갯수 구하기
	//public int selectMusPopularCount(Map<String, Object> map);
	
	// 회원 선호 장르 리스트
	@Select("SELECT * FROM musical WHERE gen_num=(SELECT prefer FROM member_detail WHERE mem_num=#{mem_num})")
	public List<MusMainVO> selectMusPreferList(Map<String, Object> map);
	
	// 회원 선호 장르 번호 구하기
	@Select("SELECT prefer FROM member_detail WHERE mem_num=#{mem_num}")
	public int selectMusPreferCount(Map<String, Object> map);
	
	/*// 회원 찜한 작품 리스트
	@Select("SELECT * FROM pick p JOIN musical m ON p.mus_num=m.mus_num WHERE mem_num=#{mem_num}")
	public List<MusMainVO> selectMusPickList(Map<String, Object> map);
	
	// 회원 찜한 작품 갯수 구하기
	@Select("SELECT COUNT(*) FROM pick WHERE mem_num=#{mem_num}")
	public int selectMusPickCount(Map<String, Object> map);*/
	
	
	//카테고리별 갯수 구하기
	@Select("SELECT COUNT(*) FROM musical WHERE musical.gen_num =1")
	public int selectLicenseCount(Map<String, Object> map);
	@Select("SELECT COUNT(*) FROM musical WHERE musical.gen_num =2")
	public int selectOriginalCount(Map<String, Object> map);
	@Select("SELECT COUNT(*) FROM musical WHERE musical.gen_num =3")
	public int selectCreationCount(Map<String, Object> map);
	@Select("SELECT COUNT(*) FROM musical WHERE musical.gen_num =4")
	public int selectFamilyCount(Map<String, Object> map);
	@Select("SELECT COUNT(*) FROM musical WHERE musical.gen_num =5")
	public int selectPerformanceCount(Map<String, Object> map);
	
	//카테고리별 리스트 구하기
	public List<MusMainVO> selectLicense(Map<String, Object> map);
	public List<MusMainVO> selectOriginal(Map<String, Object> map);
	public List<MusMainVO> selectCreation(Map<String, Object> map);
	public List<MusMainVO> selectFamily(Map<String, Object> map);
	public List<MusMainVO> selectPerformance(Map<String, Object> map);
}
