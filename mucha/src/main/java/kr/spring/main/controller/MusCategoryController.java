package kr.spring.main.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.main.service.MusMainService;
import kr.spring.main.vo.MusMainVO;
import kr.spring.member.vo.MemberVO;
import kr.spring.util.PagingUtil;

@Controller
public class MusCategoryController {
	private Logger log = Logger.getLogger(this.getClass());

	@Resource
	private MusMainService musMainService;

	// 자바빈 초기화
	@ModelAttribute
	public MusMainVO initCommand() {
		return new MusMainVO();
	}	
	

	// 카테고리별 목록
	@RequestMapping("/main/musCategory.do")
	public ModelAndView process1(@RequestParam int gen_num,
								@RequestParam(value="pageNum", defaultValue="1") int currentPage,
								@RequestParam(value="keyfield",defaultValue="") String keyfield,
								@RequestParam(value="keyword",defaultValue="") String keyword){
		Map<String,Object> map = new HashMap<String,Object>();
		
		
		int count = 0;
		// 페이징 처리 - 검색
		PagingUtil page = new PagingUtil(keyfield, keyword, currentPage, count, 20, 10, "musMain.do");
		
		// 페이지 시작 숫자, 끝 숫자
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		

		// 신작순 목록 호출
		
		List<MusMainVO> list = null;
		//갯수 , 리스트 구하기
		if (gen_num == 1) {
			count = musMainService.selectLicenseCount(map);
			if (log.isDebugEnabled()) {
				log.debug("<<count>> : " + count);
			}
			list = musMainService.selectLicense(map);
			if (log.isDebugEnabled()) {
				log.debug("<<라이선스 목록>> 출력됨 ");
			}
		} else if (gen_num == 2) {
			count = musMainService.selectOriginalCount(map);
			if (log.isDebugEnabled()) {
				log.debug("<<count>> : " + count);
			}
			list = musMainService.selectOriginal(map);
			if (log.isDebugEnabled()) {
				log.debug("<<오리지널 목록>> 출력됨 ");
			}
		} else if (gen_num == 3) {
			count = musMainService.selectCreationCount(map);
			if (log.isDebugEnabled()) {
				log.debug("<<count>> : " + count);
			}
			list = musMainService.selectCreation(map);
			if (log.isDebugEnabled()) {
				log.debug("<<창작 목록>> 출력됨 ");
			}
		} else if (gen_num == 4) {
			count = musMainService.selectFamilyCount(map);
			if (log.isDebugEnabled()) {
				log.debug("<<count>> : " + count);
			}
			list = musMainService.selectFamily(map);
			if (log.isDebugEnabled()) {
				log.debug("<<가족 목록>> 출력됨 ");
			}
		} else if (gen_num == 5) {
			count = musMainService.selectPerformanceCount(map);
			if (log.isDebugEnabled()) {
				log.debug("<<count>> : " + count);
			}
			list = musMainService.selectPerformance(map);
			if (log.isDebugEnabled()) {
				log.debug("<<퍼포먼스 목록>> 출력됨 ");
			}
		}
		ModelAndView mav = new ModelAndView();
		// 뷰 이름 설정 - ""에 tiles 명 넣기
		mav.setViewName("musCategory");
		// 데이터 저장
		mav.addObject("count", count);
		mav.addObject("list", list);
		mav.addObject("gen_num", gen_num);
		mav.addObject("pagingHtml", page.getPagingHtml());

		return mav;
	}
}



