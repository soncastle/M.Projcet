package com.acon.model;





import java.util.List;

import com.acon.domain.Member;
import com.acon.domain.MemberRequest;
import com.acon.domain.MemberRespone;


public interface MemberPersistence {
	public void insertMember(MemberRequest dto);
	public Integer checkUserid(String userid);
	public Integer login(String userid, String password);
	public String findPassword(String userid);
	public void delete(String userid, String password);
	public MemberRespone oneList(String userid);
	public void update(String userid, MemberRequest dto);
	public List<Member> list();
}
