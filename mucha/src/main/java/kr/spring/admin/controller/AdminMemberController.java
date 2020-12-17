package kr.spring.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.spring.admin.service.AdminMemberService;
import kr.spring.member.service.MemberService;
import kr.spring.member.vo.MemberVO;
import kr.spring.util.PagingUtil;

@Controller
public class AdminMemberController {
	private Logger log = Logger.getLogger(this.getClass());

	//객체 주입
	@Resource
	AdminMemberService adminMemberService;
	
	@Resource
	MemberService memberService;
	
	//자바빈 초기화
	@ModelAttribute
	public MemberVO initCommand() {
		System.out.println("//멤버자바빈 초기화");
		return new MemberVO();
	}
	//관리자 관리
	
	//관리자 목록
	@RequestMapping("/admin/adminManagerList.do")
	public ModelAndView managerList(
			@RequestParam(value = "pageNum", defaultValue = "1") int currentPage,
			@RequestParam(value = "keyfield", defaultValue = "") String keyfield,
			@RequestParam(value = "keyword", defaultValue = "") String keyword) {
		System.out.println("//****관리자 목록**************");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);
		System.out.println("//map: " + map);

		// 총 글의 갯수 또는 검색된 글의 갯수 구하기
		int count = adminMemberService.selectManagerCount(map);
		System.out.println("//count: " + count);
		if (log.isDebugEnabled()) {
			log.debug("<<count>> : " + count);
		}
		System.out.println("//" + currentPage + "//" + keyfield + "//" + keyword);
		PagingUtil page = new PagingUtil(keyfield, keyword, currentPage, count, 10, 10, "list.do");
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		System.out.println("//page :" + page);
		System.out.println("//map: " + map);
		List<MemberVO> list = null;
		if (count > 0) {
			list = adminMemberService.managerList(map);
			System.out.println("//list : " + list);

			if (log.isDebugEnabled()) {
				log.debug("<<글목록>> : " + list);
			}
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("adminManagerList");
		mav.addObject("list", list);
		mav.addObject("count", count);
		mav.addObject("pagingHtml", page.getPagingHtml());
		
		return mav;
	}
	//관리자 상세보기
	@RequestMapping("/admin/adminManagerDetail.do")
	public String managerDetail(HttpSession session,@RequestParam int mem_num,
			Model model) {
	System.out.println("//*******관리자 상세 보기");
	
	MemberVO vo = adminMemberService.selectMember(mem_num);
	model.addAttribute("memberVO",vo);
	MemberVO user = (MemberVO) session.getAttribute("user");
	MemberVO admin= memberService.selectMember(user.getMem_num());
	model.addAttribute("admin", admin);
	System.out.println("//model: " + model);
	return "adminManagerDetail";
	}
	
	//관리자 삭제
	@RequestMapping("/admin/adminDelete.do")
	public String adminDelete(@RequestParam int mem_num,Model model) {
		adminMemberService.deleteAdmin(mem_num);
		return "redirect:adminManagerList.do";
	}


	//관리자 추가
	@RequestMapping(value = "/admin/adminPlus.do", method = RequestMethod.GET)
	public String form() {
		return "adminPlus";
	}
	
	
	
	// 관리자 추가 처리
	@RequestMapping(value = "/admin/adminPlus.do", method = RequestMethod.POST)
	public String submit(@Valid MemberVO memberVO, BindingResult result) {
		if (log.isDebugEnabled()) {
			log.debug("<<회원 가입>> : " + memberVO);
		}
		// 유효성 체크 결과 오류가 있으면 폼 호출
		if (result.hasErrors()) {
			return form();
		}
		// 관리자 추가 메소드
		adminMemberService.adminPlusMember(memberVO);
		return "redirect:/admin/adminManagerList.do";
	}
	
	@RequestMapping("/admin/confirmEmail.do")
	@ResponseBody
	public Map<String,String>process(@RequestParam("email") String email){
		
		if(log.isDebugEnabled()) {
			log.debug("<<이메일중복 체크>> : " + email);
		}
		
		Map<String,String> map = new HashMap<String,String>();
		
		//null값을 이용해 체크
		MemberVO member = adminMemberService.selectCheckMember(email);
		if(member!=null) {
			//아이디 중복
			map.put("result", "emailDuplicated");
		}else {
			//아이디 미중복
			map.put("result", "emailNotFound");
		}	
		return map;
	}
	
	//관리자 회원 정보 수정
	// 관리자 회원 정보 수정 폼
		@RequestMapping(value = "/admin/adminMemberModify.do", method = RequestMethod.GET)
		public String formUpdate(HttpSession session, Model model) {
			// 회원 번호를 구하기 위해 세션에 저장된 회원 정보 반환
			MemberVO vo = (MemberVO) session.getAttribute("user");

			MemberVO memberVO = memberService.selectMember(vo.getMem_num());

			model.addAttribute("memberVO", memberVO);

			return "adminMemberModify";
		}
	
	// 관리자 정보 수정 처리
	@RequestMapping(value = "/admin/adminMemberModify.do", method = RequestMethod.POST)
	public String submitUpdate(@Valid MemberVO memberVO, BindingResult result, HttpSession session) {

		if (log.isDebugEnabled()) {
			log.debug("<<회원 정보 수정 처리>> : " + memberVO);
		}

		// 유효성 체크 결과 오류가 있으면 폼 호출
		if (result.hasErrors()) {
			return "adminMemberModify";
		}

		// 회원 번호를 얻기 위해 세션에 저장된 회원 정보 반환
		MemberVO vo = (MemberVO) session.getAttribute("user");
		// 전송된 데이터가 저장된 자바빈에 회원 번호를 저장
		memberVO.setMem_num(vo.getMem_num());
		// 현재 비밀번호와 변경할 비밀번호가 전송됐는지 여부를 체크
		if (result.hasFieldErrors("now_password") || result.hasFieldErrors("password")) {
			return "adminMemberModify";
		}

		// 회원 번호를 통해서 회원 정보를 DB로부터 읽어와서 입력한 현재 비밀번호와
		// DB에서 읽어온 현재 비밀번호가 일치하는지 여부 체크
		MemberVO member = memberService.selectMember(memberVO.getMem_num());
		if (!member.getPassword().equals(memberVO.getNow_password())) {
			result.rejectValue("now_password", "invalidPassword");
			return "adminMemberModify";
		}
		
		// 회원 정보 수정
		memberService.updateMember(memberVO);
		// 비밀번호 수정 처리
		memberService.updatePassword(memberVO);

		return "redirect:/admin/adminMain.do";
	}
	
	//회원 관리
	//회원 목록
	@RequestMapping("/admin/adminMemberList.do")
	public ModelAndView process(
			@RequestParam(value = "pageNum", defaultValue = "1") int currentPage,
			@RequestParam(value = "keyfield", defaultValue = "") String keyfield,
			@RequestParam(value = "keyword", defaultValue = "") String keyword) {
		System.out.println("//**********회원 목록**************");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);
		System.out.println("//map: " + map);

		// 총 글의 갯수 또는 검색된 글의 갯수 구하기
		int count = adminMemberService.selectRowCount(map);
		System.out.println("//count: " + count);
		if (log.isDebugEnabled()) {
			log.debug("<<count>> : " + count);
		}
		System.out.println("//" + currentPage + "//" + keyfield + "//" + keyword);
		PagingUtil page = new PagingUtil(keyfield, keyword, currentPage, count, 10, 10, "list.do");
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		System.out.println("//page :" + page);
		System.out.println("//map: " + map);
		List<MemberVO> list = null;
		if (count > 0) {
			list = adminMemberService.selectList(map);
			System.out.println("//list : " + list);

			if (log.isDebugEnabled()) {
				log.debug("<<글목록>> : " + list);
			}
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("adminMemberList");
		mav.addObject("list", list);
		mav.addObject("count", count);
		
		mav.addObject("pagingHtml", page.getPagingHtml());
		System.out.println("//mav: " + mav);
		return mav;
	}
	//회원 상세보기
	@RequestMapping("/admin/adminMemberDetail.do")
	public String form(@RequestParam int mem_num,
			Model model) {
	System.out.println("//*******회원 상세 보기");
	MemberVO vo = adminMemberService.selectMember(mem_num);
	System.out.println("//MemberVO : " + vo);
	model.addAttribute("memberVO",vo);
	
	return "adminMemberDetail";
	}
	
	
	
}