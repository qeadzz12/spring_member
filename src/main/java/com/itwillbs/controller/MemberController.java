package com.itwillbs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;
import com.itwillbs.persistence.MemberDAOImpl;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	MemberDAO dao = new MemberDAOImpl();
	
	@GetMapping(value = "MemberJoin")
	public void insertMember() {
		logger.debug("insertMember 페이지 호출");
	}//
	
	@GetMapping(value = "MemberJoinAction")
	public void insertMemberPro() {
		logger.debug("insertMemberPro 페이지 호출");
		
		MemberVO vo = new MemberVO();
		vo.setUserid("test3");
		vo.setUserpw("1234");
		
//		logger.debug("getTime 출력: "+dao.getTime());
		
//		return "/member/MemberJoin";
	}//

	
	
	
}//controller
