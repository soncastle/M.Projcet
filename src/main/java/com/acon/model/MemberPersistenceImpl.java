package com.acon.model;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.acon.domain.MemberRequest;
import com.acon.domain.MemberRespone;

@Repository
public class MemberPersistenceImpl implements MemberPersistence {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertMember(MemberRequest dto) {
		sqlSession.insert("com.acon.Weatherapp.insertMember", dto);
	}

	@Override
	public MemberRespone responeMember() {
		return null;
	}

	@Override
	public MemberRespone correctPassword() {
		return null;
	}

	@Override
	public int checkUserid(String userid) {
	Integer result = sqlSession.selectOne("com.acon.Weatherapp.checkUserid", userid);
	if(result==null) {
		return 0;
	}
	else return result;
	}

}
