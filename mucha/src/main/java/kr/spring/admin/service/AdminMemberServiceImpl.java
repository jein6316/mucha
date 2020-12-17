package kr.spring.admin.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.admin.dao.AdminMemberMapper;
import kr.spring.member.vo.MemberVO;

@Service("AdminMemberService")
public class AdminMemberServiceImpl implements AdminMemberService{
	
	@Resource
	AdminMemberMapper mapper;

	@Override
	public List<MemberVO> selectList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return mapper.selectList(map);
	}

	@Override
	public int selectRowCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return mapper.selectRowCount(map);
	}

	@Override
	public MemberVO selectMember(Integer mem_num) {
		// TODO Auto-generated method stub
		return mapper.selectMember(mem_num);
	}

	
	@Override
	public List<MemberVO> managerList(Map<String, Object> map) {
		
		return mapper.managerList(map);
	}

	@Override
	public int selectManagerCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return mapper.selectManagerCount(map);
	}

	@Override
	public void adminPlusMember(MemberVO member) {
		member.setMem_num(mapper.selectMem_num());
		mapper.adminPlusMember_detail(member);
		mapper.adminPlusMember(member);
		
	}

	@Override
	public MemberVO selectCheckMember(String email) {
		return mapper.selectCheckMember(email);
	}

	@Override
	public void deleteAdmin(int mem_num) {
		mapper.deleteAdmin(mem_num);
		
	}



	
}
