package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.MemberVO;

public interface MemberService {
	
	//회원가입
	public int memberJoin(MemberVO vo);
	
	//로그인
	public MemberVO memberLogin(MemberVO vo);
	
	//회원정보 조회
	public MemberVO getMemberInfo(String id);
	
	//회원정보 수정
	public void updateMemberInfo(MemberVO vo);
	
	//회원정보 삭제
	public int deleteMember(MemberVO vo);
	
	//회원목록 조회
	public List<MemberVO> getMemberList();
	
}
