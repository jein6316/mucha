package kr.spring.musinfo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.spring.main.vo.MusMainVO;
import kr.spring.musinfo.vo.PickVO;

public interface PickMapper {
	@Insert("INSERT INTO pick VALUES(pick_num.nextVal, #{mem_num}, #{mus_num})")
	public void insertPick(PickVO pickVO);	
	
	@Delete("DELETE FROM pick WHERE mem_num=#{mem_num} AND mus_num=#{mus_num}")
	public void deletePick(PickVO pickVO);
	
	// 회원 찜한 작품 리스트
	@Select("SELECT * FROM musical m  JOIN pick p ON m.mus_num=p.mus_num WHERE mem_num=#{mem_num} ORDER BY mus_regdate DESC")
	public List<MusMainVO> selectMusPickList(Map<String, Object> map);
	
	// 회원이 찜한 작품 갯수
	@Select("SELECT COUNT(*) FROM pick WHERE mem_num=#{mem_num}")
	public int selectRowCount(Map<String, Object> map);
	
	// 뮤지컬 찜 여부 카운트
	@Select("SELECT COUNT(*) FROM pick WHERE mem_num=#{mem_num} AND mus_num=#{mus_num}")
	public int selectPickCount(Map<String, Object> map);
}
