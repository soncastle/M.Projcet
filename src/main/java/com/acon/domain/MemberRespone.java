package com.acon.domain;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class MemberRespone {
	private String userid;
	private String name;
	private String birth;
	private String password;
	private String gender;
	private String address;
	private String phone;
	private LocalDateTime timestamp; 
}