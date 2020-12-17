package kr.spring.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.spring.member.service.MemberService;
import kr.spring.member.vo.MemberVO;


public class AuthCheckInterceptor extends HandlerInterceptorAdapter{

	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private MemberService memberService;  
	@Override
	public boolean preHandle(HttpServletRequest request,
			                 HttpServletResponse response,
			                 Object handler)throws Exception{

		if(log.isDebugEnabled()) {
			log.debug("=====AuthCheckInterceptor진입======");
		}
		//user의 auth값 구하기
		int mem_num=Integer.parseInt(request.getParameter("mem_num"));
		int auth=Integer.parseInt(request.getParameter("auth"));
		MemberVO member=memberService.selectMember(mem_num);
		//Auth 검사(0=관리자, 1=이용권 구입회원, 2=이용권 미구입회원, 3=탈퇴회원)
		HttpSession session = request.getSession();
		if(session.getAttribute("auth")=="2") {
			response.sendRedirect("이용권을 구입하세요");
			
			return false;
		}
		
		
		return true;
	}
}

