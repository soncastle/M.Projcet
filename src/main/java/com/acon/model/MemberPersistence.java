package com.acon.model;



import com.acon.domain.MemberRequest;
import com.acon.domain.MemberRespone;


public interface MemberPersistence {
	public void insertMember(MemberRequest dto);
	public MemberRespone responeMember();
	public Integer checkUserid(String userid);
	public Integer login(String userid, String password);
	public String findPassword(String userid);
	public void delete(String userid, String password);
}
