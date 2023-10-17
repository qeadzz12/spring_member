package com.itwillbs.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {
	
	
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Autowired
	private MemberDAO dao;
	
	@Override
	public int memberJoin(MemberVO vo) {
		logger.debug("memberJoin() 호출");
		return dao.insertMember(vo);
	}//
	
	@Override
	public MemberVO memberLogin(MemberVO vo) {
		logger.debug("memberLogin() 호출");
		return dao.loginMember(vo);
	}
	
	@Override
	public MemberVO getMemberInfo(String id) {
		logger.debug("getMemberInfo() 호출");
		return dao.getMember(id);
	}

	
	
}///////
