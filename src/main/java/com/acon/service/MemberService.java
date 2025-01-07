package com.acon.service;


import java.util.List;

import com.acon.domain.Member;
import com.acon.domain.MemberRequest;
import com.acon.domain.MemberRespone;

public interface MemberService {
		public String insertMember(MemberRequest dto, String password, String passwordConform, String userid);
		public Integer login(String userid, String password);
		public String findPassword(String phone);
		public void delete(String userid, String password);
		public MemberRespone oneList(String userid);
		public void update(String userid, MemberRequest dto);
		public List<Member> list();
		public boolean passwordConform(String password, String passwordConform);
}