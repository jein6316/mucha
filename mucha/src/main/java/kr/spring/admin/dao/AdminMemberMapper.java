package kr.spring.admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.spring.member.vo.MemberVO;

public interface AdminMemberMapper {

	// 멤버 리스트
	
	//관리자 리스트
	public List<MemberVO> managerList(Map<String, Object> map);
	//관리자 갯수 구하기 
	public int selectManagerCount(Map<String, Object> map);
	//관리자 삭제
	@Delete("DELETE FROM member_detail WHERE member_detail.mem_num=#{mem_num}")
	public void deleteAdmin(int mem_num);
	//관리자 추가
	@Insert("INSERT INTO member (mem_num,email,auth) VALUES (#{mem_num},#{email},0)")
	public void adminPlusMember(MemberVO member);
	@Insert("INSERT INTO member_detail (mem_num,nickname,password,birth,phone,prefer) VALUES (#{mem_num},#{nickname},#{password},#{birth},#{phone},0)")
	public void adminPlusMember_detail(MemberVO member);
	@Select("SELECT admin_seq.nextval FROM dual")
	public int selectMem_num();
	// 회원리스트
	public List<MemberVO> selectList(Map<String, Object> map);
	// 글의 갯수 구하기
	public int selectRowCount(Map<String, Object> map);
	// 회원 상세 보기
	@Select("SELECT m.*,d.* FROM member m LEFT OUTER JOIN member_detail d ON m.mem_num=d.mem_num WHERE m.mem_num=#{mem_num}")
	public MemberVO selectMember(Integer mem_num);
	@Select("SELECT m.mem_num,m.email,m.auth,d.password,d.mem_imagename,d.nickname,d.mem_regdate,d.purchase_date,d.expire_date FROM member m LEFT OUTER JOIN member_detail d ON m.mem_num=d.mem_num WHERE m.email=#{email}")
	public MemberVO selectCheckMember(String email);
}
