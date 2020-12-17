package kr.spring.main.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.main.service.MusMainService;
import kr.spring.main.vo.MusMainVO;
import kr.spring.member.vo.MemberVO;
import kr.spring.musinfo.service.PickService;
import kr.spring.util.PagingUtil;

@Controller
public class MusMainController {
	private Logger log = Logger.getLogger(this.getClass());

	@Resource
	private MusMainService musMainService;
	@Resource
	private PickService pickService;

	// 자바빈 초기화
	@ModelAttribute
	public MusMainVO initCommand() {
		return new MusMainVO();
	}	
	
	// 첫 화면
	@RequestMapping(value="/main/musFirst.do")
	public String form() {
		return "musFirst";
	}
	
	
	// 메인 목록
	@RequestMapping("/main/musMain.do")
	public ModelAndView process1(@RequestParam(value="pageNum", defaultValue="1") int currentPage,
								@RequestParam(value="keyfield",defaultValue="") String keyfield,
								@RequestParam(value="keyword",defaultValue="") String keyword,
								HttpSession session){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);
		
		// 뮤지컬 총 레코드 수
		int count = musMainService.selectMusMainCount(map);
		System.out.println("//count: " + count);
		if (log.isDebugEnabled()) {
			log.debug("<<count>> : " + count);
		}

		// 페이징 처리 - 검색
		PagingUtil page = new PagingUtil(keyfield, keyword, currentPage, count, 20, 10, "musMain.do");
		
		// 페이지 시작 숫자, 끝 숫자
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		/*// 검색 목록 호출
		List<MusMainVO> list = null;
		if(count > 0) {
			list = musMainService.selectMusMainList(map);
			
			if(log.isDebugEnabled()) {
				log.debug("<<글 목록>> : " + list );
			}
		}	*/
		
		
		// 신작순 목록 호출
		List<MusMainVO> latestList = null;
		
		if(count > 0) {
			latestList = musMainService.selectMusLatestList(map);
			
			if(log.isDebugEnabled()) {
				log.debug("<<신작 목록>> 출력됨 ");
			}
			
		}
		
		// 인기순 목록 호출
		List<MusMainVO> popularList = null;
		if(count > 0) {
			popularList = musMainService.selectMusPopularList(map);
			if(log.isDebugEnabled()) {
				log.debug("<<인기순 목록>>출력됨 ");
			}
		}
		
		// 선호장르 목록 호출
		MemberVO memberVO1 = (MemberVO)session.getAttribute("user");
		map.put("mem_num", memberVO1.getMem_num());	
		
		int prefer = musMainService.selectMusPreferCount(map);
		map.put("prefer", prefer);
		System.out.println("<<prefer>> 번호 : " + prefer);
		
		List<MusMainVO> preferList = null;		
		if(count > 0) {
			System.out.println("<<preferList if문으로 들어옴>>");
			preferList = musMainService.selectMusPreferList(map);
			if(log.isDebugEnabled()) {
				log.debug("<<선호장르 목록>>출력 ");
			}
		}
		
		
		// 찜한 목록 호출	
		MemberVO memberVO2 = (MemberVO)session.getAttribute("user");
		map.put("mem_num", memberVO2.getMem_num());	
		
		int pick_count = pickService.selectRowCount(map);		
		map.put("pick_count", pick_count);
		System.out.println("<<pick_count>> : " + pick_count);
		
		List<MusMainVO> pickList = null;		
		if(count > 0) {
			System.out.println("//map : "+map);
			pickList = pickService.selectMusPickList(map);
			if(log.isDebugEnabled()) {
				log.debug("<<찜한 목록>>출력 ");
			}
		}
	
		ModelAndView mav = new ModelAndView();
		// 뷰 이름 설정 - ""에 tiles 명 넣기
		mav.setViewName("main");
		// 데이터 저장
		mav.addObject("count", count);
		mav.addObject("pick_count", pick_count);
		mav.addObject("prefer", prefer);
		//mav.addObject("list", list);
		mav.addObject("latestList", latestList);
		mav.addObject("popularList", popularList);
		mav.addObject("preferList", preferList);
		mav.addObject("pickList", pickList);
		mav.addObject("pagingHtml", page.getPagingHtml());

		return mav;
	}
	
	// 메인 검색 목록
	@RequestMapping("/main/musMainSearch.do")
	public ModelAndView process(@RequestParam(value="pageNum", defaultValue="1") int currentPage,
								@RequestParam(value="keyfield",defaultValue="") String keyfield,
								@RequestParam(value="keyword",defaultValue="") String keyword){
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);
		
		// 뮤지컬 총 레코드 수
		int count = musMainService.selectMusMainCount(map);
		System.out.println("//count: " + count);
		if (log.isDebugEnabled()) {
			log.debug("<<count>> : " + count);
		}

		// 페이징 처리 - 검색
		PagingUtil page = new PagingUtil(keyfield, keyword, currentPage, count, 20, 10, "musMainSearch.do");
		
		// 페이지 시작 숫자, 끝 숫자
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		// 검색 목록 호출
		List<MusMainVO> list = null;
		if(count > 0) {
			list = musMainService.selectMusMainList(map);
			
			if(log.isDebugEnabled()) {
				log.debug("<<글 목록>> 출력됨");
			}
		}		
		
		ModelAndView mav = new ModelAndView();
		// 뷰 이름 설정 - ""에 tiles 명 넣기
		mav.setViewName("mainSearch");
		// 데이터 저장
		mav.addObject("count", count);
		mav.addObject("list", list);
		mav.addObject("pagingHtml", page.getPagingHtml());

		return mav;
	}
	
	//DB에 저장된 포스터 이미지를 view에 출력
	@RequestMapping("/main/postView.do")
	public ModelAndView viewImage(@RequestParam int mus_num) {

		MusMainVO musMainVO = musMainService.selectMusMain(mus_num);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("imageView");
		//bite[]타입의 데이터
		mav.addObject("imageFile",musMainVO.getMus_post());
		mav.addObject("filename",musMainVO.getMus_postname());

		return mav;	
	}
}



