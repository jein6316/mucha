package kr.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.spring.member.vo.MemberVO;

public class adminCheckInterceptor extends HandlerInterceptorAdapter {
	private Logger log = Logger.getLogger(this.getClass());
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		if (log.isDebugEnabled()) {
			log.debug("=====LoginCheckInterceptor진입======");
		}

		// 로그인 여부 검사
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("user");
		if (session.getAttribute("user") == null) {// 로그인이 되지 않은 상태
			response.sendRedirect(request.getContextPath() + "/member/login.do");
			return false;
		} else if (memberVO.getAuth() != 0) {// 일반회원의 접근
			response.sendRedirect(request.getContextPath() + "/member/memberWarning.do");
		}
		return true;
	}
}
