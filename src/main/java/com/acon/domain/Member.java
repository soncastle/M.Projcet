package com.acon.domain;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.Data;


@Data
public class Member {
	@Pattern(regexp = "^[a-zA-Z0-9]{5,20}$", message = "아이디는 5글자 이상의 영문과 숫자로 구성되어야 합니다.")
	private String userid;
	@Pattern(regexp = "^[가-힣]{2,20}$", message = "이름은 2글자 이상의 한글만 허용됩니다.")
	private String name;
	private String birth;
	@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[~!@#$%^&*()_\\-+=\\[\\]{}|;:'\",.<>?/])[a-zA-Z0-9~!@#$%^&*()_\\-+=\\[\\]{}|;:'\",.<>?/]{9,20}$", 
		    message = "숫자와 문자, 특수문자를 반드시 포함하여 9~20자의 비밀번호를 입력해야 합니다.")
	private String password;
	private String gender;
	private String address;
	@Pattern(regexp = "^[0-9]{11}$", message = "11개의 숫자를 입력해주세요.")
	private String phone;
	private LocalDateTime create_at; 
	private String role;
	

@Data
public class Response{
	private String userid;
	private String name;
	private String birth;
	private String gender;
	private String address;
	private String phone;
	private LocalDateTime create_at; 
	private String role;
}
}
