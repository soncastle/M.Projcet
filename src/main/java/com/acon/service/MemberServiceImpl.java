package com.acon.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acon.domain.MemberRequest;
import com.acon.domain.MemberRespone;
import com.acon.model.MemberPersistence;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberPersistence memberPersistence;
	
	@Override
	public String insertMember(MemberRequest dto, String password, String passwordConform, String userid) {
		System.out.println(dto);
		if(passwordConform.equals(password) && memberPersistence.checkUserid(userid)==0) {
			memberPersistence.insertMember(dto);
			return "good";
		}
		else if(password!=passwordConform && memberPersistence.checkUserid(userid)==0){
			return "password";
		}
		else if(password.equals(passwordConform) && memberPersistence.checkUserid(userid)>0) {
			return "userid";
		}
		else if(password!=passwordConform && memberPersistence.checkUserid(userid)>0) {
			return "allfulse";
		}
		else {
			return "false";
		}
	}
	
	public String findPassword(String userid) {
		String result = memberPersistence.findPassword(userid);
		return (result!=null) ? result : "wrong";
	}
	
	@Override
	public Integer login(String userid, String password) {
		Integer result = memberPersistence.login(userid, password);
			return (result != null) ? 100 : 0;
	}

	@Override
	public void delete(String userid, String password) {
		memberPersistence.delete(userid, password);
	}
	
	@Override
	public MemberRespone oneList(String userid) {
		return memberPersistence.oneList(userid);
	}
	
	@Override
	public void update(String userid, MemberRequest dto) {
		memberPersistence.update(userid, dto);
	}

}
