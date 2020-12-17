package kr.spring.musinfo.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.member.service.MemberService;
import kr.spring.member.vo.MemberVO;
import kr.spring.musinfo.service.CommentsService;
import kr.spring.musinfo.service.ContentsService;
import kr.spring.musinfo.vo.CommentsVO;
import kr.spring.musinfo.vo.ContentsVO;

@Controller
public class ContentsController {
	private Logger log=Logger.getLogger(this.getClass());
	@Resource
	private ContentsService contentsService;
	@Resource
	private CommentsService commentsService;
	@Resource
	private MemberService memberService;
	
	//자바빈 초기화
	@ModelAttribute
	public ContentsVO initCommand() {
		return new ContentsVO();
	}
	//뮤지컬 소개 페이지
	@RequestMapping("/musinfo/musinfoDetail.do")
	public ModelAndView detail(int mus_num,Model model) {
		System.out.println("//*******뮤지컬상세 보기");
		if(log.isDebugEnabled()) {
			log.debug("<<뮤지컬 상세>>:"+mus_num);
		}
		
	//뮤지컬번호에서 정보 가져오기
	ContentsVO VO = contentsService.selectContents(mus_num);
	int count = commentsService.selectReviewCount(mus_num);
	System.out.println("//ContentsVO : " + VO);
	System.out.println("//avgVO : " + count);
	//평점
	if(count>0) {
	String avg =String.format("%.1f",contentsService.selectAvg(mus_num));
	System.out.println("//avg : " + avg);
	model.addAttribute("avg",avg);
	
	int num=contentsService.selectNum(mus_num);
	System.out.println("//num : " + num);
	model.addAttribute("num",num);


	}
	

	
	//최근리뷰 2개

		List<ContentsVO> newest=contentsService.selectNewest(mus_num);
		model.addAttribute("newest",newest);
		System.out.println("//최근리뷰2개"+newest);
	return new ModelAndView("musinfoMain","contentsVO",VO);

	}

	
	//출연자 이름
	@RequestMapping(value = "/musinfo/musinfoDetail.do",method=RequestMethod.POST)
	public String modifySubmit(@Valid ContentsVO contentsVO, BindingResult result, HttpServletRequest request) {
		String[] actors = request.getParameterValues("mus_actor");
		String mus_actor = "";
			for(int i=0; i<actors.length;i++) {
				if(actors[i]!=null && !actors[i].equals("")) {
					if(i !=0) {
					mus_actor += ",";	
					}
					mus_actor += actors[i];	
				}
			}
			contentsVO.setMus_actor(mus_actor);

		System.out.println("//actors"+actors);
		return null;
		
	}
	//이미지 출력
		@RequestMapping("/musinfo/imageView.do")
		public ModelAndView viewImage(@RequestParam int mus_num) {

			System.out.println("//*****영화이미지 출력*********");
			ContentsVO contentsVO = contentsService.selectContents(mus_num);
			System.out.println("//VO : "+contentsVO);

			
			ModelAndView mav = new ModelAndView();
			System.out.println("//mav : "+mav);
			
			mav.setViewName("imageView");
			mav.addObject("imageFile",contentsVO.getMus_post());
			mav.addObject("filename",contentsVO.getMus_postname());
			System.out.println("//mav : "+mav);

			
			return mav;
			
		}
/*	//프로필이미지 출력
		@RequestMapping(value="/member/imageView.do")
		public ModelAndView profile(@RequestParam int mem_num) {
			System.out.println("//*****프로필이미지 출력*********");
			MemberVO memberVO = memberService.selectMember(mem_num);
			System.out.println("//VO : "+memberVO);
			
			ModelAndView mav=new ModelAndView();
			mav.setViewName("imageView");
			mav.addObject("imageFile",memberVO.getMem_image());
			mav.addObject("filename",memberVO.getMem_imagename());
			return mav;
		}*/
		
/*		@RequestMapping("/musinfo/imageView.do")
		public ModelAndView viewImage(@RequestParam int board_num) {
			
			BoardVO board = boardService.selectBoard(board_num);
			
			ModelAndView mav = new ModelAndView();
			mav.setViewName("imageView");
			                            //byte[]타입의 데이터
			mav.addObject("imageFile", board.getUploadfile());
			mav.addObject("filename", board.getFilename());
			
			return mav;
		}*/
		
		//뮤지컬 보기
		@RequestMapping("/musinfo/musicalWatch.do")
		public ModelAndView watch(@RequestParam int mus_num,Model model,HttpServletRequest request, 
				HttpSession session) {
			ContentsVO musical = contentsService.selectContents(mus_num);
	         
	         model.addAttribute("mus_num",mus_num);
	         // 조회수 update
	         contentsService.updateHit(musical);
	         model.addAttribute("mus_hit",musical.getMus_hit());
			
			return new ModelAndView("musicalWatch","musical",musical);
		}

}
