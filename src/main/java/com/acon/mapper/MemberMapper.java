package com.acon.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.acon.domain.MemberRequest;

@Mapper
public interface MemberMapper {
	
	@Insert("INSERT INTO users(userid, name, birth, password, gender, address, phone, create_at, role) "
			+ "VALUES (#{userid}, #{name}, #{birth}, #{password}, #{gender}, #{address}, #{phone}, NOW(), 'user')")
	public void insertMember(MemberRequest dto);

	@Select("SELECT id FROM users WHERE userid=#{userid}")
	public Integer checkUserid(String userid);
	
	@Select("SELECT id FROM users WHERE userid=#{userid} and password=#{password}")
	public Integer login(String userid, String password);
	
	@Select("SELECT password FROM users WHERE userid=#{userid}")
	public String findPassword(String userid);
	
	@Delete("DELETE FROM users WHERE userid=#{userid} AND password=#{password}")
	public void delete(String userid, String password);
}
