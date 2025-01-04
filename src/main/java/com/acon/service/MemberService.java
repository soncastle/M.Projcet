package com.acon.service;

import com.acon.domain.MemberRequest;
import com.acon.domain.MemberRespone;

public interface MemberService {
		public String insertMember(MemberRequest dto, String password, String passwordConform, String userid);
		public MemberRespone responeMember();
		public MemberRespone correctPassword();
		public Integer login(String userid, String password);
		public String findPassword(String phone);
		public void delete(String userid, String password);
}