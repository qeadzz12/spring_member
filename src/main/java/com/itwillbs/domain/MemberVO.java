package com.itwillbs.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Data
public class MemberVO { /*MemberDTO*/
	
	private String userid;
	private String userpw;
	private String username;
	private String useremail;
	
	private Timestamp regdate;
	private Timestamp updatedate;
	
	// get/set메서드
	// toString메서드	
	

}
