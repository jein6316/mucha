package kr.spring.admin.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.spring.admin.service.AdminMemberService;
import kr.spring.member.service.MemberService;
import kr.spring.member.vo.MemberVO;

@Controller
public class AdminMainController {

	@Resource
	AdminMemberService adminMemberService;

	@Resource
	MemberService memberService;

	// 자바빈 초기화
	@ModelAttribute
	public MemberVO initCommand() {
		System.out.println("//멤버자바빈 초기화");
		return new MemberVO();
	}

	@RequestMapping("/admin/adminMain.do")
	public String make(	HttpSession session,
						HttpServletResponse response) {
		MemberVO vo = (MemberVO) session.getAttribute("user");

		MemberVO memberVO = memberService.selectMember(vo.getMem_num());
		
		if(memberVO.getAuth()!=0) {
			return "redirect:/member/memberMain.do";
		}
		
		return "adminMain";
	}
	
	@RequestMapping("/member/memberWarning.do")//관리자외 일반회원이 관리자 페이지 접근시
	public String memberWarning() {
		
		return "memberWarning";
	}
}