package kr.spring.member.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberMainController {
	@RequestMapping("/member/memberMain.do")
	public String make(HttpServletResponse response) {
		
	
		return "memberMain";
		}
}