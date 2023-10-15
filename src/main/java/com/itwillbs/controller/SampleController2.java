package com.itwillbs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;
import com.itwillbs.persistence.MemberDAOImpl;

@Controller
public class SampleController2 {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController2.class);
	
	@Autowired
	MemberDAO dao;
	
	@RequestMapping("/doB")
	public int doB() {
		logger.debug("dob실행");
		return 0;
	}
	
	@GetMapping(value = "/doB2")
	public String doB2(Model mo, RedirectAttributes rttr) {
		logger.debug("doB2실행");
		String msg = "hello";
		
		mo.addAttribute("msg", msg);
		rttr.addFlashAttribute("msg2","@@@@@@" );
		mo.addAttribute("msg3", "msg3@@");
		
		return "redirect:doB1";
	}
	
//	@RequestMapping(value = "/doB1",method = RequestMethod.GET)
	@GetMapping(value = "/doB1")
	public String doB1( MemberVO vo, Model m,
					@ModelAttribute("msg")	String msg,
					@ModelAttribute("msg2") String msg2,
					@ModelAttribute("msg3") String msg3
					
			) {
		logger.debug("doB1실행");
		logger.debug("doB1실행"+vo);
		
		MemberVO dbvo = new MemberVO();
		
		
		dbvo = dao.loginMember(vo);
		
		if(dbvo !=null) {
			m.addAttribute("dbvo",dbvo);
		}else {
			m.addAttribute("dbvo", null);
		}
		
		m.addAttribute("msg", msg);
		m.addAttribute("msg2", msg2);
		
		
		logger.debug("msg : "+msg);
		logger.debug("msg2 : "+msg2);
		logger.debug("msg3 : "+msg3);
		logger.debug("vo : "+vo);
		logger.debug("id : "+vo.getUserid());
		logger.debug("pw : "+vo.getUserpw());
		
		return "itwill";
	}
	
	@GetMapping(value = "/doF")
	public @ResponseBody String doF(){
		logger.debug("doF실행");
		
		return "hahahahahah";
	}
	
	
}
