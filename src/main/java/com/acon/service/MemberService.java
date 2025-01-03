package com.acon.service;

import com.acon.domain.MemberRequest;
import com.acon.domain.MemberRespone;

public interface MemberService {
		public String insertMember(MemberRequest dto, String password, String passwordConform, String userid);
		public MemberRespone responeMember();
		public MemberRespone correctPassword();
	
}