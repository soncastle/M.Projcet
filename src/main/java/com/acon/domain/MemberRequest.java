package com.acon.domain;




import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class MemberRequest {
	private String userid;
	private String name;
	private String birth;
	private String password;
	private String gender;
	private String address;
	private String phone;
}