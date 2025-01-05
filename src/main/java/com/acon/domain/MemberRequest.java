package com.acon.domain;


import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class MemberRequest {
	private int id; 
	private String userid;
	private String name;
	
	private String birth;
	
	private String password;
	private String gender;
	private String address;
	private String phone;
}