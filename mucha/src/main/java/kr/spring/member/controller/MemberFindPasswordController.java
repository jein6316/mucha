package kr.spring.member.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.spring.member.email.Email;
import kr.spring.member.email.EmailSender;
import kr.spring.member.service.MemberService;
import kr.spring.member.vo.MemberVO;

@Controller
public class MemberFindPasswordController {

	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private EmailSender emailSender;
	@Autowired
	private Email email;

	@Resource
	private MemberService memberService;

	//자바빈 초기화
	@ModelAttribute
	public MemberVO initCommand(){
		return new MemberVO();
	}

	@RequestMapping(value="/member/findPassword.do",method=RequestMethod.GET)
	public String form(){
		return "findPassword";
	}

	@RequestMapping(value="/member/findPassword.do",method=RequestMethod.POST)
	public String sendEmailAction(@Valid MemberVO memberVO,
			BindingResult result) throws Exception{

		if(log.isDebugEnabled()){
			log.debug("<<비밀번호 찾기>> : " +memberVO);
		}
			log.debug("<<분기체크--1>>");
		//유효성 체크
		if(result.hasFieldErrors("email")){
			return form();
		}
		if(log.isDebugEnabled()){
			log.debug("<<분기체크--2>>");
		}
		/*MemberVO member = memberService.checkEmail(memberVO.getEmail());*/
		MemberVO member = memberService.selectCheckMember(memberVO.getEmail());
		if(log.isDebugEnabled()){
			log.debug("<<분기체크--3>>" + member);
		}
		if(member!=null) {
			//기본비밀번호를 임시비밀번호로 변경
			String password = randomPassword(10);
			member.setPassword(password);
			//변경된 임시비밀번호를 DB에 저장
			memberService.updateRandomPassword(member);
			
			email.setContent("임시 비밀번호는 " + password +" 입니다. \n 로그인 후 비밀번호를 꼭 변경해 주세요");
			email.setReceiver(member.getEmail());
			email.setSubject(member.getEmail()+" 님 비밀번호 찾기 메일입니다.");
			
			if(log.isDebugEnabled()){
				log.debug("<<임시 비밀번호>> : " +password);
			}
			
			emailSender.sendEmail(email);

			return "findPasswordCom";
		}else {
			result.reject("invalidEmail");
			return form();
		}
	}

	//비밀번호 보안을 위한 난수 발생 메소드
	public String randomPassword(int length){
		int index = 0;
		char[] charSet = new char[]{
				'0','1','2','3','4','5','6','7','8','9'
				,'A','B','C','D','E','F','G','H','I','J','K','L','M'
				,'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'
				,'a','b','c','d','e','f','g','h','i','h','k','l','m'
				,'n','o','p','q','r','s','t','u','v','w','x','y','z'
		};

		StringBuffer sb = new StringBuffer();

		for(int i=0;i<length;i++){
			index = (int)(charSet.length * Math.random());
			sb.append(charSet[index]);
		}

		return sb.toString();
	}
}