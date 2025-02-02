package com.acon.model;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.acon.domain.Member;
import com.acon.domain.MemberRequest;
import com.acon.domain.MemberRespone;
import com.acon.mapper.MemberMapper;

@Repository
public class MemberPersistenceImpl implements MemberPersistence {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public void insertMember(MemberRequest dto) {
		memberMapper.insertMember(dto);
	}

	@Override
	public String findPassword(String userid) {
		return memberMapper.findPassword(userid);
		
	}

	@Override
	public Integer checkUserid(String phone) {
	    Integer result = memberMapper.checkUserid(phone);
	    return (result != null) ? result : 0;
	}

	@Override
	public Integer login(String userid, String password) {
		return memberMapper.login(userid, password);
	}

	@Override
	public void delete(String userid, String password) {
		memberMapper.delete(userid, password);
	}
	
	@Override
	public MemberRespone oneList(String userid) {
	    return memberMapper.oneList(userid);
	}
	
	@Override
	public void update(String userid, MemberRequest dto) {
		memberMapper.update(userid, dto);
	}
	
	public List<Member> list(){
		return memberMapper.list();
	}
}