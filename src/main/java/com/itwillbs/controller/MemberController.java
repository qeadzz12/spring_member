package com.itwillbs.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService service;
	
	//회원가입 -------------------------------------
	@GetMapping(value = "/insert")
	public String insertMemberGET() {
		logger.debug("insertMemberGET() 호출");
		
		return "/member/memberJoin";
	}//insertMemberGET()
	
	@PostMapping(value = "/insert")
	public String insertMemberPOST(MemberVO vo) {
		logger.debug("insertMemberPOST() 호출");
		logger.debug("userInfo: "+vo);
		
		int result = service.memberJoin(vo);
		logger.debug("회원가입 동작 끝");
		
		if(result == 1) {
			return "redirect:/member/login";
		}else {
			return "/member/memberJoin";
		}
	}//insertMemberPOST(MemberVO vo)

	//로그인 -------------------------------------
	@GetMapping(value = "/login")
	public String loginGET() {
		logger.debug("loginGET() 호출");
		
		return "/member/memberLogin";
	}//loginGET()
	
	@PostMapping(value = "/login")
	public String logintPOST(MemberVO vo, HttpSession session) {
		logger.debug("loginPOST() 호출");
		logger.debug("userInfo: "+vo);
		
		MemberVO resultVO = service.memberLogin(vo);
		
		if(resultVO == null) {
			logger.debug("로그인 실패");
			return "redirect:/member/memberLogin";
		}
		session.setAttribute("id", vo.getUserid());
		logger.debug("로그인 성공");
		
		return "redirect:/";
	}//logintPOST(MemberVO vo)
	
	// 로그아웃 ----------------------------------------
	@RequestMapping(value = "/logout", method = {RequestMethod.GET,RequestMethod.POST})
	public String logout(HttpSession session) {
		logger.debug("logout() 호출");
		session.invalidate();
		
		return "redirect:/";
	}//logout(HttpSession session)
	
	//회원정보 조회 ------------------------------------------
	@GetMapping(value = "/info")
	public String infoGET(HttpSession session, Model model) {
		logger.debug("infoGET() 호출");
		
		String id = (String)session.getAttribute("id");
		MemberVO vo = service.getMemberInfo(id);
		
		model.addAttribute(vo);
		
		return "/member/memberInfo";
	}

	
	
}//controller
