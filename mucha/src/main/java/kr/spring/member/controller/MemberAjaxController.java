package kr.spring.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.spring.member.service.MemberService;
import kr.spring.member.vo.MemberVO;

@Controller
public class MemberAjaxController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private MemberService memberService;
	
	@RequestMapping("/member/confirmEmail.do")
	@ResponseBody
	public Map<String,String>process(@RequestParam("email") String email){
		
		if(log.isDebugEnabled()) {
			log.debug("<<이메일중복 체크>> : " + email);
		}
		
		Map<String,String> map = new HashMap<String,String>();
		
		//null값을 이용해 체크
		MemberVO member = memberService.selectCheckMember(email);
		if(member!=null) {
			//아이디 중복
			map.put("result", "emailDuplicated");
		}else {
			//아이디 미중복
			map.put("result", "emailNotFound");
		}	
		
		return map;
	}
	
	//프로필 사진 업데이트
	@RequestMapping("/member/updateMyImage.do")
	@ResponseBody
	public Map<String,String> processProfile(MemberVO memberVO,HttpSession session){
		Map<String,String> map = new HashMap<String,String>();
		
		MemberVO user = (MemberVO) session.getAttribute("user"); 
		
		if(user==null) {
			//로그인되지 않은 경우
			map.put("result", "logout");
		}else {
			//로그인 된 경우
			memberVO.setMem_num(user.getMem_num());
			memberService.updateProfile(memberVO);
			
			//이미지를 업로드한 후 세션에 저장된 회원 정보의 이미지 이름 구체화
			user.setMem_imagename(memberVO.getMem_imagename());
			
			map.put("result", "success");
		}
		
		return map;
	}
}
