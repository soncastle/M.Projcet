package com.acon.model;



import com.acon.domain.MemberRequest;
import com.acon.domain.MemberRespone;


public interface MemberPersistence {
	public void insertMember(MemberRequest dto);
	public MemberRespone responeMember();
	public MemberRespone correctPassword();
	int checkUserid(String userid);
}
