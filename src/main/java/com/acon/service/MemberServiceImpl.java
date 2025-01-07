package com.acon.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acon.domain.Member;
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
			return "비밀번호가 일치하지 않습니다.";
		}
		else if(password.equals(passwordConform) && memberPersistence.checkUserid(userid)>0) {
			return "아이디가 중복되었습니다.";
		}
		else if(password!=passwordConform && memberPersistence.checkUserid(userid)>0) {
			return "이미 가입된 아이디가 있으며, 비밀번호가 일치하지 않습니다.";
		}
		else {
			return "잘못된 접근입니다.";
		}
	}
	@Override
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
	
	public List<Member> list(){
		return memberPersistence.list();
		
	}
	
	@Override
	public boolean passwordConform(String password, String passwordConform) {
		if(password!=passwordConform) {
			return false;
		}
		else {
			return true;
		}
	}
}
