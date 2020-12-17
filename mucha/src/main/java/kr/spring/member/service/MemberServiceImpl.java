package kr.spring.member.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.member.dao.MemberMapper;
import kr.spring.member.vo.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	//주입
	@Resource
	private MemberMapper memberMapper;
	
	@Override
	public void joinMember(MemberVO member) {
		//세개가 한번에 정상 작동해야하므로 트랜젝션 처리. 하나라도 안되면 롤백되어야함
		member.setMem_num(memberMapper.selectMem_num());
		memberMapper.joinMember_detail(member);
		memberMapper.joinMember(member);		
	}

	@Override
	public MemberVO selectCheckMember(String id) {
		return memberMapper.selectCheckMember(id);
	}

	@Override
	public MemberVO selectMember(Integer mem_num) {
		return memberMapper.selectMember(mem_num);
	}

	@Override
	public void updateMember(MemberVO member) {
		memberMapper.updateMember(member);
	}

	@Override
	public void updatePassword(MemberVO member) {
		memberMapper.updatePassword(member);
	}

	@Override
	public void deleteMember(Integer mem_num) {
		memberMapper.deleteMember(mem_num);
		memberMapper.deleteMember_detail(mem_num);
		
	}
	@Override
	public void updateProfile(MemberVO member) {
		memberMapper.updateProfile(member);
	}

	@Override
	public void updateTicket(MemberVO member) {
		memberMapper.updateTicket(member);
		
	}

	@Override
	public void updateTicketAuth(MemberVO member) {
		memberMapper.updateTicketAuth(member);
	}

	@Override
	public void updatePrefer(MemberVO member) {
		memberMapper.updatePrefer(member);
	}

	@Override
	public void updateRandomPassword(MemberVO member) {
		memberMapper.updatePassword(member);
	}

	@Override
	public void setTicketAuth(MemberVO member) {
		memberMapper.setTicketAuth(member);
		
	}

	@Override
	public void resetTicketDate(MemberVO member) {
		memberMapper.resetTicketDate(member);
		
	}

	@Override
	public MemberVO checkEmail(String email) {
		return memberMapper.checkEmail(email);
		
	};
	
	

}
