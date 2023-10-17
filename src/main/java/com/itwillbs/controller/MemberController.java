package com.itwillbs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;
import com.itwillbs.persistence.MemberDAOImpl;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	MemberDAO dao;
	
	@GetMapping(value = "/insert")
	public String insertMemberGET() {
		logger.debug("insertMemberGET() 호출");
//		logger.debug("getTime 출력: "+dao.getTime());
		
		return "/member/memberJoin";
	}//
	
	@PostMapping(value = "/insert")
	public String insertMemberPOST(MemberVO vo) {
		logger.debug("insertMemberPOST() 호출");
		logger.debug("userInfo: "+vo);
		
		int result = dao.insertMember(vo);
		logger.debug("회원가입 동작 끝");
		
		if(result == 1) {
			return "/member/memberLogin";
		}else {
			return "/member/memberJoin";
		}
	}//

	
	
	
}//controller
