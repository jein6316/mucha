package kr.spring.musinfo.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.spring.musinfo.vo.CommentsVO;
import kr.spring.musinfo.vo.ContentsVO;

public interface ContentsMapper {
	@Select("select * from musical where mus_num=#{mus_num}")
	public ContentsVO selectContents(int mus_num);
	@Select("select mus_actor from musical where mus_num=#{mus_num}")
	public List<String> actorList(Map<String,Object> map);
	@Select("select rev_num,review, nickname, rev_rate,mem_image,MEM_NUM.nextval from (select * from reviews r, member_detail m where r.mem_num=m.mem_num and mus_num=#{mus_num} order by rev_regdate desc)where rownum<=2")
	public List<ContentsVO> selectNewest(int mus_num);
	@Select("select avg(rev_rate) from reviews where mus_num=#{mus_num}")
	public double selectAvg(int mus_num);
	@Select("select count(rev_rate) from reviews where mus_num=#{mus_num}")
	public int selectNum(int mus_num);
	@Update("UPDATE musical SET mus_hit=mus_hit+1 WHERE mus_num=#{mus_num}")
	public void updateHit(ContentsVO contentsVO);
}
