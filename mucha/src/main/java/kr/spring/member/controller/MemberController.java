package kr.spring.member.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
import org.springframework.web.servlet.ModelAndView;

import kr.spring.member.service.MemberService;
import kr.spring.member.vo.MemberVO;
import kr.spring.util.LoginCheckException;

@Controller
public class MemberController {
	private Logger log = Logger.getLogger(this.getClass());

	@Resource
	private MemberService memberService;

	// 자바빈(VO) 초기화
	@ModelAttribute
	public MemberVO initCommand() {
		return new MemberVO();
	}

	// 회원가입 폼
	@RequestMapping(value = "/member/join.do", method = RequestMethod.GET)
	public String form() {
		return "join";
	}

	// 회원가입 처리
		@RequestMapping(value = "/member/join.do", method = RequestMethod.POST)
		public String submit(@Valid MemberVO memberVO, BindingResult result, HttpServletRequest request, HttpSession session) {
			if (log.isDebugEnabled()) {
				log.debug("<<회원 가입>> : " + memberVO);
			}
			
			
		
		//가장 많이 선택된 선호 장르 고르기
		String[] prefer = request.getParameterValues("prefer");

		if(prefer != null) {
		//체크된 갯수를 더해줄 배열 생성
		int[] index = {0,0,0,0,0,0};
		//갯수 ++
		for(int i=0;i<prefer.length;i++) {
			
			if(prefer[i].equals("1")) {
				index[1]++;
			}else if(prefer[i].equals("2")) {
				index[2]++;
			}else if(prefer[i].equals("3")) {
				index[3]++;
			}else if(prefer[i].equals("4")) {
				index[4]++;
			}else if(prefer[i].equals("5")) {
				index[5]++;
			}
		}
		//가장 많이 선택된 값 찾기
		int max = index[0]; //=0
		int maxIndex = 0;
		for(int j=0; j<index.length; j++) {
			if(index[j]> max) {
				maxIndex = j;
				max = j;
			}
		}
		memberVO.setPrefer(max);	
		
			//콘솔 확인용
			/*		log.debug("<< P R E F E R>> prefer : " + prefer);
					log.debug("<< P R E F E R>> max : " + max);
					log.debug("<< P R E F E R>> maxIndex :" + maxIndex );*/
		
		}else {//선택한 장르가 없는 경우 코드 0
			int noChoice = 0;
			memberVO.setPrefer(noChoice);
		}
		
		
		// 유효성 체크 결과 오류가 있으면 폼 호출
		if (result.hasErrors()) {
			return form();
		}

		// 회원 가입
		memberService.joinMember(memberVO);

		return "joinCom";
	}

	// 로그인 폼
	@RequestMapping(value = "/member/login.do", method = RequestMethod.GET)
	public String formLogin() {
		return "login";
	}

	// 로그인 처리
	@RequestMapping(value = "/member/login.do", method = RequestMethod.POST)
	public String submitLogin(@Valid MemberVO memberVO, BindingResult result, HttpSession session) {
		if (log.isDebugEnabled()) {
			log.debug("<<MemberVO>> : " + memberVO);
		}

		// email와 password 필드만 체크
		if (result.hasFieldErrors("email") || result.hasFieldErrors("password")) {
			return formLogin();
		}
		
		//password 암호화
		//import kr.spring.util.SecurityUtil; memberVO의 isCheckedPassword; controller의 password암호화 ___
		/*SecurityUtil securityUtil = new SecurityUtil();
		String Spass = (String) session.getAttribute("password");
		String userSpass = securityUtil.encryptSHA256(Spass);
		
		//변경하여 다시 세션에 저장
		session.setAttribute("password",userSpass);*/
		
		// 로그인 체크(email와 비밀번호 일치 여부 체크)
		try {
			MemberVO member = memberService.selectCheckMember(memberVO.getEmail());
			boolean check = false;

			if (member != null) {
				// 비밀번호 일치 여부 체크
				check = member.isCheckedPassword(memberVO.getPassword());
			}

			if (check) {//비밀번호 일치 하는 경우
				
					
				// 인증 성공, 로그인 처리
				session.setAttribute("user", member);
				MemberVO vo = (MemberVO) session.getAttribute("user");
				if (log.isDebugEnabled()) {
					log.debug("<<auth수정 전 VO>> : " + vo);
				}
				/////
				if(vo.getExpire_date()!=null) {
							//오늘 날짜와 만료일 체크하여 auth 수정
							SimpleDateFormat sdf = new SimpleDateFormat();
							Calendar cal = new GregorianCalendar();
							//오늘날짜
							Date date = cal.getTime();
							String today = sdf.format(date);
							
							//Expire_date
							String exDate = sdf.format(vo.getExpire_date());
							
							
							if(exDate.compareTo(today) < 0) {
								//exDate < today 인 경우 결제권 만료. auth값 2로 변경
								if (log.isDebugEnabled()) {
									log.debug("<<compareTo 결과>> : " + exDate.compareTo(today));
								}
								
								//전송된 데이터가 저장된 자바빈에 회원 번호를 저장
								memberVO.setMem_num(vo.getMem_num());
								
								memberService.setTicketAuth(memberVO);
								memberService.resetTicketDate(memberVO);
								
								vo.setExpire_date(null);
								
								session.invalidate();
								return "expireCom";
							}
					}
				/////	
				
				return "redirect:/index.jsp";
			} else {
				// 인증 실패
				throw new LoginCheckException();
			}

		} catch (LoginCheckException e) {
			// 인증 실패로 로그인폼 호출
			result.reject("invalidEmailOrPassword");

			return formLogin();
		}
	}

	// 로그아웃
	@RequestMapping("/member/logout.do")
	public String processLogout(HttpSession session) {
		// 로그아웃
		session.invalidate();

		return "redirect:/index.jsp";
	}

	/*// 회원 상세 정보
	@RequestMapping("/member/memberMain.do")
	public String process(HttpSession session, Model model) {
		// 회원번호를 얻기위해 세션에 저장된 회원 정보를 반환
		MemberVO vo = (MemberVO) session.getAttribute("user");

		MemberVO member = memberService.selectMember(vo.getMem_num());

		if (log.isDebugEnabled()) {
			log.debug("<<회원 상세 정보>> : " + member);
		}

		model.addAttribute("member", member);

		return "memberView";
	}*/

	// 회원 정보 수정 폼
	@RequestMapping(value = "/member/modifyMember.do", method = RequestMethod.GET)
	public String formUpdate(HttpSession session, Model model) {
		// 회원 번호를 구하기 위해 세션에 저장된 회원 정보 반환
		MemberVO vo = (MemberVO) session.getAttribute("user");

		MemberVO memberVO = memberService.selectMember(vo.getMem_num());

		model.addAttribute("memberVO", memberVO);

		return "modifyMember";
	}

	// 회원 정보 수정 처리
	@RequestMapping(value = "/member/modifyMember.do", method = RequestMethod.POST)
	public String submitUpdate(@Valid MemberVO memberVO, BindingResult result, HttpSession session) {

		if (log.isDebugEnabled()) {
			log.debug("<<회원 정보 수정 처리>> : " + memberVO);
		}

		// 유효성 체크 결과 오류가 있으면 폼 호출
		if (result.hasErrors()) {
			return "modifyMember";
		}

		// 회원 번호를 얻기 위해 세션에 저장된 회원 정보 반환
		MemberVO vo = (MemberVO) session.getAttribute("user");
		// 전송된 데이터가 저장된 자바빈에 회원 번호를 저장
		memberVO.setMem_num(vo.getMem_num());

		// 회원 정보 수정
		memberService.updateMember(memberVO);

		return "modifyMemberCom";
	}
	
	
	//선호장르 수정 폼
	@RequestMapping(value = "/member/modifyPrefer.do", method = RequestMethod.GET)
	public String formUpdatePrefer(HttpSession session, Model model) {
		// 회원 번호를 구하기 위해 세션에 저장된 회원 정보 반환
		MemberVO vo = (MemberVO) session.getAttribute("user");

		MemberVO memberVO = memberService.selectMember(vo.getMem_num());

		model.addAttribute("memberVO", memberVO);

		return "modifyPrefer";
	}
	//선호장르 수정 처리
	@RequestMapping(value = "/member/modifyPrefer.do", method = RequestMethod.POST)
	public String submitUpdatePrefer(MemberVO memberVO, BindingResult result,HttpServletRequest request, HttpSession session) {

		if (log.isDebugEnabled()) {
			log.debug("<<선호도 수정 처리>> : " + memberVO);
		}

		
		//가장 많이 선택된 선호 장르 고르기
				String[] prefer = request.getParameterValues("prefer");

				if(prefer != null) {
				//체크된 갯수를 더해줄 배열 생성
				int[] index = {0,0,0,0,0,0};
				//갯수 ++
				for(int i=0;i<prefer.length;i++) {
					
					if(prefer[i].equals("1")) {
						index[1]++;
					}else if(prefer[i].equals("2")) {
						index[2]++;
					}else if(prefer[i].equals("3")) {
						index[3]++;
					}else if(prefer[i].equals("4")) {
						index[4]++;
					}else if(prefer[i].equals("5")) {
						index[5]++;
					}
				}
				//가장 많이 선택된 값 찾기
				int max = index[0]; //=0
				int maxIndex = 0;
				for(int j=0; j<index.length; j++) {
					if(index[j]> max) {
						maxIndex = j;
						max = j;
					}
				}
				memberVO.setPrefer(max);	
				
				}else {//선택한 장르가 없는 경우 코드 0
					int noChoice = 0;
					memberVO.setPrefer(noChoice);
				}

		// 회원 번호를 얻기 위해 세션에 저장된 회원 정보 반환
		MemberVO vo = (MemberVO) session.getAttribute("user");
		// 전송된 데이터가 저장된 자바빈에 회원 번호를 저장
		memberVO.setMem_num(vo.getMem_num());

		// 선호장르 수정
		memberService.updatePrefer(memberVO);
		
		return "modifyPreferCom";
	}
	
	
	
	// 비밀번호 변경 폼
	@RequestMapping(value = "/member/changePassword.do", method = RequestMethod.GET)
	public String formChangePassword() {
		return "changePassword";
	}

	// 비밀번호 변경 처리
	@RequestMapping(value = "/member/changePassword.do", method = RequestMethod.POST)
	public String submitChangePassword(@Valid MemberVO memberVO, BindingResult result, HttpSession session) {
		if (log.isDebugEnabled()) {
			log.debug("<<비밀번호 변경 처리>> : " + memberVO);
		}

		// 현재 비밀번호와 변경할 비밀번호가 전송됐는지 여부를 체크
		if (result.hasFieldErrors("now_password") || result.hasFieldErrors("password")) {
			return "changePassword";
		}

		// 회원 번호를 얻기 위해서 세션에 저장된 회원 정보 반환
		MemberVO vo = (MemberVO) session.getAttribute("user");
		
		// 현재 비밀번호와 변경할 비밀번호가 저장된 자바빈에 회원 번호 저장
		memberVO.setMem_num(vo.getMem_num());

		// 회원 번호를 통해서 회원 정보를 DB로부터 읽어와서 입력한 현재 비밀번호와
		// DB에서 읽어온 현재 비밀번호가 일치하는지 여부 체크
		MemberVO member = memberService.selectMember(memberVO.getMem_num());
		if (!member.getPassword().equals(memberVO.getNow_password())) {
			result.rejectValue("now_password", "invalidPassword");
			return "changePassword";
		}

		// 비밀번호 수정 처리
		memberService.updatePassword(memberVO);

		return "changePasswordCom";
	}
	
	// 회원 탈퇴 폼
	@RequestMapping(value = "/member/deleteMember.do", method = RequestMethod.GET)
	public String formDelete() {
		return "deleteMember";
	}

	// 회원 탈퇴 처리   -- 입력값 | 세션에 저장된 값 | 데이터베이스에 저장된 값
	@RequestMapping(value = "/member/deleteMember.do", method = RequestMethod.POST)
	public String submitDelete(@Valid MemberVO memberVO, BindingResult result, HttpSession session) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<회원탈퇴>> : " + memberVO);
		}
		
		//email,password 필드의 에러만 체크
		if(result.hasFieldErrors("email") || result.hasFieldErrors("password")) {
			return "deleteMember";
		}
		
		//회원번호를 얻기 위해 세션에 저장된 회원 정보 반환
		MemberVO vo = (MemberVO) session.getAttribute("user");
		
		//
		memberVO.setMem_num(vo.getMem_num());
		
		//비밀번호 일치 여부 체크
		//회원번호를 이용해 회원 정보를 읽기
		MemberVO member = memberService.selectMember(memberVO.getMem_num());
		
		boolean check = false;
						  //입력한 아이디.equals(세션에 저장된 아이디)
		if(member!=null && memberVO.getEmail().equals(vo.getEmail())) {
				//비밀번호 일치여부 체크
				check = member.isCheckedPassword(memberVO.getPassword());
		}
		
		if(check) {
			//인증성공
			memberService.deleteMember(memberVO.getMem_num());
			//로그아웃
			session.invalidate();
			return "deleteMemberCom";
			
		}else {
			//인증실패
			result.reject("invalidEmailOrPassword");
			return "deleteMember";
		}
	}
	//이미지 변경 폼
	@RequestMapping(value="/member/myImage.do", method=RequestMethod.GET)
	public String formImage() {
		return "myImage";
	}
	
	//이미지 변경 처리
	@RequestMapping(value = "/member/myImage.do", method = RequestMethod.POST)
	public String submitImage(@Valid MemberVO memberVO, BindingResult result, HttpSession session) {
		return "myImage";
	}
	
	
	//이미지출력
	@RequestMapping("/member/imageView.do")
	public ModelAndView viewImage(HttpSession session) {
		
		MemberVO user = (MemberVO) session.getAttribute("user");
		MemberVO memberVO = memberService.selectMember(user.getMem_num());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("imageView");
		mav.addObject("imageFile",memberVO.getMem_image());
		mav.addObject("filename",memberVO.getMem_imagename());
		
		return mav;
		
	}
	
	//이용권 구매하기 폼
	@RequestMapping(value ="/member/ticket.do", method=RequestMethod.GET)
	public String formticket(HttpSession session, Model model) {
		//회원번호 구하기
		MemberVO vo = (MemberVO)session.getAttribute("user");
		
		MemberVO memberVO = memberService.selectMember(vo.getMem_num());
		
		model.addAttribute("memberVO",memberVO);
		
		return "ticket";
	}
	
	//이용권 구매 처리
	@RequestMapping(value="/member/ticket.do", method=RequestMethod.POST)
	public String SubmitTicket(MemberVO memberVO, BindingResult result, HttpSession session) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<티켓구매처리>>" + memberVO);
		}
		//회원 번호를 얻기 위해 세션에 저장된 회원 정보 반환
		MemberVO vo = (MemberVO) session.getAttribute("user");
		//전송된 데이터가 저장된 자바빈에 회원 번호를 저장
		memberVO.setMem_num(vo.getMem_num());
		
		//회원 정보 수정
		memberService.updateTicket(memberVO);
		memberService.updateTicketAuth(memberVO);
		session.invalidate();

		return "ticketCom";
		
	}
	
}
