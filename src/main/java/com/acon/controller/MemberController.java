package com.acon.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.acon.domain.MemberRequest;
import com.acon.model.MemberPersistence;
import com.acon.service.MemberService;

import jakarta.servlet.http.HttpSession;
@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/login")
	public String Login() {
		return "/member/login";
	}
	@PostMapping("/login")
	public String LoginRequest(@RequestParam("userid") String userid,
			@RequestParam("password") String password,
			Model model,
			HttpSession session) {
		Integer result = memberService.login(userid, password);
		if(result==100) {
			session.setAttribute("userid", userid);
			return "member/main";
		}
		else {
			model.addAttribute("msg", "비밀번호 및 패스워드가 틀렸습니다.");
			return "member/login";
		}
	}
	@GetMapping("findPassword")
	public String findPassword() {
		return "member/findPassword";
	}
	
	@PostMapping("/findPassword")
	public String findPassword(@RequestParam("userid") String userid,
								Model model) {
		String result = memberService.findPassword(userid);
		if(result.equals("wrong")) {
			model.addAttribute("msg", "가입된 id가 없습니다.");
			return "member/findPassword";
		}
		else{
			model.addAttribute("msg", result);
			return"member/findPassword";
		}
	}
	
	@GetMapping("/register")
	public String Register(@ModelAttribute("MemberRequest") MemberRequest memberRequest,
							Model model) {
		model.addAttribute("memberRequest", memberRequest);
		return "member/register";
	}
	
	
	@PostMapping("/register")
	public String RegisterRequest(@RequestParam("password") String password,
								@RequestParam("passwordConform") String passwordConform,
								@RequestParam("userid") String userid,
								@ModelAttribute MemberRequest memberRequest,
								Model model) {
			String result = memberService.insertMember(memberRequest, password, passwordConform, userid);
			System.out.println(1+password);
			System.out.println(2+passwordConform);
			System.out.println(3+userid);
			System.out.println(memberRequest);
			if(result.equals("password")) {
				model.addAttribute("msg", "비밀번호와 패스워드가 일치하지 않습니다.");
				return "member/register";
		}
		else if(result.equals("userid")){
			model.addAttribute("msg", "아이디가 중복되었습니다.");
			return "member/register";
		}
		else if(result.equals("good")){
			return "member/registerConform";
		}
		else if(result.equals("allfulse")) {
			return "member/register";
		}
		else {
			model.addAttribute("msg", "잘못된 접근입니다.");
			return "member/register";
		}
	}
	
	@PostMapping("/delete")
	public String delete(@RequestParam("userid") String userid,
						@RequestParam("password") String password,
						Model model) {
		Integer memberConfrom = memberService.login(userid, password);
		if(memberConfrom==100) {
			memberService.delete(userid, password);
			model.addAttribute("msg", "회원탈퇴가 완료되었습니다.");
			return "redirect:/";
		}
		else {
			model.addAttribute("msg", "회원정보가 일치하지 않습니다.");
			return "member/main";
		}
	}
	
//	@PostMapping("/update")
//	public String update(@RequestParam("userid") String userid,
//						@RequestParam("password") String password,
//						@RequestParam("updatPassword") String updatePassword,
//			Model model) {
//		Integer memberConfrom = memberService.login(userid, password);
//		if(memberConfrom==100) {
//			memberService.updatePassword(userid, updatePassword);
//			model.addAttribute("msg", "비밀번호가 변경되었습니다.");
//			return "member/main";
//		}
//		else {
//			model.addAttribute("msg", "회원정보가 일치하지 않습니다.");
//			return "member/main";
//		}
//	}
}
