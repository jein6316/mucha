package kr.spring.admin.service;

import java.util.List;
import java.util.Map;

import kr.spring.member.vo.MemberVO;

public interface AdminMemberService {
	// 멤버 리스트
	// 관리자 리스트
	public List<MemberVO> managerList(Map<String, Object> map);
	//관리자 삭제
	public void deleteAdmin(int mem_num);
	//관리자 추가 관련
	public void adminPlusMember(MemberVO member);
	// 관리자 갯수 구하기
	public int selectManagerCount(Map<String, Object> map);
	// 회원 리스트
	public List<MemberVO> selectList(Map<String, Object> map);
	// 글의 갯수 구하기
	public int selectRowCount(Map<String, Object> map);
	// 회원 상세 보기
	public MemberVO selectMember(Integer mem_num);
	public MemberVO selectCheckMember(String email);	

	
}
