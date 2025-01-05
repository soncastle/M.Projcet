package com.acon.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.acon.domain.MemberRequest;
import com.acon.domain.MemberRespone;

@Mapper
public interface MemberMapper {
	
	@Insert("INSERT INTO users(userid, name, birth, password, gender, address, phone, create_at, role) "
			+ "VALUES (#{userid}, #{name}, #{birth}, #{password}, #{gender}, #{address}, #{phone}, NOW(), 'user')")
	public void insertMember(MemberRequest dto);
	
	@Update("UPDATE users SET name=#{dto.name}, birth=#{dto.birth}, password=#{dto.password}, "
	        + "gender=#{dto.gender}, address=#{dto.address}, phone=#{dto.phone} "
	        + "WHERE userid=#{userid}")
	public void update(String userid, MemberRequest dto);

	@Select("SELECT id FROM users WHERE userid=#{userid}")
	public Integer checkUserid(String userid);
	
	@Select("SELECT id FROM users WHERE userid=#{userid} and password=#{password}")
	public Integer login(String userid, String password);
	
	@Select("SELECT password FROM users WHERE userid=#{userid}")
	public String findPassword(String userid);
	
	@Delete("DELETE FROM users WHERE userid=#{userid} AND password=#{password}")
	public void delete(String userid, String password);
	
	@Select("SELECT * FROM users WHERE userid=#{userid}")
	public MemberRespone oneList(String userid);
}
