package com.acon.domain;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;

@Data
public class Member {
	private int id; 
	private String userid;
	private String name;
	private String birth;
	private String password;
	private String gender;
	private String address;
	private String phone;
	private LocalDateTime create_at; 
	private String role;
}