package kr.spring.interceptor;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


import kr.spring.member.vo.MemberVO;
import kr.spring.musinfo.service.CommentsService;
import kr.spring.musinfo.vo.CommentsVO;

public class ReviewCheckInterceptor extends HandlerInterceptorAdapter{
	private Logger log=Logger.getLogger(this.getClass());
	@Resource
	private CommentsService commentsService;
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception{
		if(log.isDebugEnabled()) {
			log.debug("<<로그인 아이디와 작성자 아이디 일치 여부 체크>>");
		}
		//작성자의 회원번호 구하기
		int rev_num=Integer.parseInt(request.getParameter("rev_num"));
		CommentsVO commentsVO=commentsService.selectComments(rev_num);
		
		HttpSession session=request.getSession();
		MemberVO member=(MemberVO)session.getAttribute("user");
		if(log.isDebugEnabled()) {
			log.debug("<<로그인 회원 번호>>: "+member.getMem_num()+"<br><<작성자 회원 번호>>: "+commentsVO.getMem_num());
			
		}
		//로그인 회원번호와 작성자 회원번호 일치 여부 체크
		if(member==null || member.getMem_num()!=commentsVO.getMem_num()) {
			if(log.isDebugEnabled()) {
				log.debug("<<로그인 아이디와 작성자 아이디 불일치>>");
			}
		//불일치할 경우 경고 페이지 호출	
			RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/common/notice.jsp");
			dispatcher.forward(request, response);
			return false;	//페이지가 나오지 않음
		}
		if(log.isDebugEnabled()) {
			log.debug("<<로그인 아이디와 작성자 아이디 일치>>");
		}
		return true;	//페이지가 나옴
		
	}
	}

