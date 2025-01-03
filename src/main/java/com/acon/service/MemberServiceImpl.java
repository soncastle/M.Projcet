package com.acon.service;


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

	@Override
	public MemberRespone responeMember() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberRespone correctPassword() {
		// TODO Auto-generated method stub
		return null;
	}

}
