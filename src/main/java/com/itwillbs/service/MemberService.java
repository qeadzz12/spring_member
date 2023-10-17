package com.itwillbs.service;

import com.itwillbs.domain.MemberVO;

public interface MemberService {
	
	//회원가입
	public int memberJoin(MemberVO vo);
	
	//로그인
	public MemberVO memberLogin(MemberVO vo);
	
	//회원정보 조회
	public MemberVO getMemberInfo(String id);
	
}
