package kr.spring.member.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.spring.member.vo.MemberVO;

public interface MemberMapper {
	@Select("SELECT mem_num.nextval FROM dual")
	public int selectMem_num();
	
	//회원가입_member
	@Insert("INSERT INTO member (mem_num,email) VALUES (#{mem_num},#{email})")
	public void joinMember(MemberVO member);
	//회원가입_member_detail
	@Insert("INSERT INTO member_detail (mem_num,nickname,password,birth,phone,prefer) VALUES (#{mem_num},#{nickname},#{password},#{birth},#{phone},#{prefer})")
	public void joinMember_detail(MemberVO member);
	@Select("SELECT m.mem_num,m.email,m.auth,d.password,d.mem_imagename,d.nickname,d.mem_regdate,d.purchase_date,d.expire_date FROM member m LEFT OUTER JOIN member_detail d ON m.mem_num=d.mem_num WHERE m.email=#{email}")
	public MemberVO selectCheckMember(String email);//누락된id(탈퇴한 회원의 id)는 검색필요 X -> JOIN
	
	//회원정보 변경
	@Update("UPDATE member_detail SET nickname=#{nickname},phone=#{phone},mem_modifydate=SYSDATE WHERE mem_num=#{mem_num}")
	public void updateMember(MemberVO member);
	
	//선호장르 변경
	@Update("UPDATE member_detail SET prefer=#{prefer} where mem_num=#{mem_num}")
	public void updatePrefer(MemberVO member);
	
	//비밀번호 변경
	@Update("UPDATE member_detail SET password=#{password} WHERE mem_num=#{mem_num}")
	public void updatePassword(MemberVO member);
	
	//mem_num을 받아 member_detail 데이터 전체를 가져오기
	@Select("SELECT * FROM member m JOIN member_detail d ON m.mem_num=d.mem_num WHERE m.mem_num=#{mem_num}")
	public MemberVO selectMember(Integer mem_num);
	
	//회원탈퇴
	@Update("UPDATE member SET auth=3 WHERE mem_num=#{mem_num}")
	public void deleteMember(Integer mem_num);

	@Delete("DELETE FROM member_detail WHERE mem_num=#{mem_num}")
	public void deleteMember_detail(Integer mem_num);
	
	//프로필이미지업데이트
	@Update("UPDATE member_detail SET mem_image=#{mem_image},mem_imagename=#{mem_imagename} WHERE mem_num=#{mem_num}")
	public void updateProfile(MemberVO member);
	
	//이용권 구매
	@Update("update member_detail SET purchase_date=SYSDATE, expire_date=SYSDATE+30 WHERE mem_num=#{mem_num}")
	public void updateTicket(MemberVO member);
	@Update("UPDATE member SET auth=1 WHERE mem_num=#{mem_num}")
	public void updateTicketAuth(MemberVO member);
	
	//이용권만료
	@Update("UPDATE member SET auth=2 WHERE mem_num=#{mem_num}")
	public void setTicketAuth(MemberVO member);
	@Update("UPDATE member_detail SET purchase_date=null, expire_date=null WHERE mem_num=#{mem_num}")
	public void resetTicketDate(MemberVO member);
	
	//비밀번호 찾기 랜덤 비밀번호로 변경
	@Update(" UPDATE ( SELECT * FROM member m JOIN member_detail d ON m.mem_num = d.mem_num) SET password = #{password} WHERE email = #{email} ")
	public void updateRandomPassword(MemberVO member);
	
	//비밀번호 찾기 시 입력한 이메일이 DB에 존재하는지 확인하기위해
	@Select("SELECT * FROM member where email=#{email}")
	public MemberVO checkEmail(String email);
}



