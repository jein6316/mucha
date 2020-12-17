package kr.spring.member.service;

import kr.spring.member.vo.MemberVO;

public interface MemberService {
	public void joinMember(MemberVO member);
	public MemberVO selectCheckMember(String id);
	public MemberVO selectMember(Integer mem_num);
	public void updateMember(MemberVO member);
	public void updatePrefer(MemberVO member);
	public void updatePassword(MemberVO member);
	public void deleteMember(Integer mem_num);
	public void updateProfile(MemberVO member);
	public void updateTicket(MemberVO member);
	public void updateTicketAuth(MemberVO member);
	public void updateRandomPassword(MemberVO member);
	public void setTicketAuth(MemberVO member);
	public void resetTicketDate(MemberVO member);
	public MemberVO checkEmail(String email);
}