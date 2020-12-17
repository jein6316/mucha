package kr.spring.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.admin.service.NoticeService;
import kr.spring.admin.vo.NoticeVO;
import kr.spring.util.PagingUtil;
@Controller
public class MemberNoticeController {
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	NoticeService noticeService;
	
	//자바빈(VO) 초기화
	@ModelAttribute
	public NoticeVO initCommand() {
		return new NoticeVO();
	}
	
	//회원 공지사항 보기
	// 게시판 목록
	@RequestMapping("/member/memberNoticeList.do")
	public ModelAndView memberNoticeList(@RequestParam(value = "pageNum", defaultValue = "1") int currentPage,
			@RequestParam(value = "keyfield", defaultValue = "") String keyfield,
			@RequestParam(value = "keyword", defaultValue = "") String keyword) {
		System.out.println("//회원 공지사항 보기");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);
		System.out.println("//map: " + map);

		// 총 글의 갯수 또는 검색된 글의 갯수 구하기
		int count = noticeService.selectMemberNoitceRowCount(map);
		System.out.println("//count: " + count);
		if (log.isDebugEnabled()) {
			log.debug("<<count>> : " + count);
		}
		System.out.println("//" + currentPage + "//" + keyfield + "//" + keyword);
		PagingUtil page = new PagingUtil(keyfield, keyword, currentPage, count, 10, 10, "memberNoticeList.do");
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		System.out.println("//page :" + page);
		System.out.println("//map: " + map);
		List<NoticeVO> list = null;
		if (count > 0) {
			list = noticeService.selectMemberNoticeList(map);
			System.out.println("//list : " + list);

			if (log.isDebugEnabled()) {
				log.debug("<<글목록>> : " + list);
			}
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("memberNoticeList");
		mav.addObject("list", list);
		mav.addObject("count", count);
		mav.addObject("pagingHtml", page.getPagingHtml());
		System.out.println("//mav: " + mav);
		return mav;
	}
	//공자사항 상세
		@RequestMapping("/member/memberNoticeView.do")
		public ModelAndView memberNoticeView(@RequestParam int no_num) {
			System.out.println("//공지사항 상세 보기 ");
			if(log.isDebugEnabled()) {
				log.debug("<<글 상세>> : " + no_num);
			}
			//해당 글의 조회수 증가
			noticeService.updateNoticeHit(no_num);
			
			NoticeVO notice = noticeService.selectNotice(no_num);
			
			return new ModelAndView("memberNoticeView","notice",notice);
		}
	
}
