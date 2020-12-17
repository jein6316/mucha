package kr.spring.musinfo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.spring.member.vo.MemberVO;
import kr.spring.musinfo.service.PickService;
import kr.spring.musinfo.vo.PickVO;

@Controller
public class PickController {
	private Logger log = Logger.getLogger(this.getClass());

	@Resource
	private PickService pickService;
  
	// 찜하기 처리
	@RequestMapping(value="/musinfo/pick.do")
	@ResponseBody
	public Map<String, Object> pick(PickVO pickVO, HttpSession session) {
		Map<String, Object> mapJson = new HashMap<String, Object>();
		// 회원 번호 세팅									
		MemberVO member=(MemberVO)session.getAttribute("user");
		if(member!=null) {
			pickVO.setMem_num(member.getMem_num());		

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("mem_num", pickVO.getMem_num());
			map.put("mus_num", pickVO.getMus_num());

			// 찜 확인 - count==0 이면 찜X, count==1 이면 찜O
			int count = pickService.selectPickCount(map);
			System.out.println("//count: "+ count);

			if(count == 0) {
				pickService.insertPick(pickVO);
			}else if(count > 0) {
				pickService.deletePick(pickVO);
			}

			mapJson.put("result", "success");
		}else {
			mapJson.put("result", "logout");
		}

		return mapJson;
	}
	//찜 읽기
	@RequestMapping(value="/musinfo/getFav.do")
	@ResponseBody
	public Map<String, Object> getFav(PickVO pickVO, HttpSession session) {
		Map<String, Object> mapJson = new HashMap<String, Object>();
		// 회원 번호 세팅									
		MemberVO member=(MemberVO)session.getAttribute("user");
		if(member!=null) {
			pickVO.setMem_num(member.getMem_num());		

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("mem_num", pickVO.getMem_num());
			map.put("mus_num", pickVO.getMus_num());

			// 찜 확인 - count==0 이면 찜X, count==1 이면 찜O
			int count = pickService.selectPickCount(map);
			System.out.println("찜count : " + count);

			mapJson.put("result", "success");
			mapJson.put("count", count);
		}else {
			mapJson.put("result", "logout");
		}

		return mapJson;
	}

}
