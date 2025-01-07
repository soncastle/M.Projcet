package com.acon.controller;

import java.util.List;

import org.springframework.beans.Mergeable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonWriter.Members;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.acon.domain.Member;
import com.acon.service.MemberService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/")
	public String adminsLogin() {
		return "admin/adminLogin";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		List<Member> users = (List<Member>)memberService.list();
		model.addAttribute("users", users);
		return "/admin/list";
	}
	
	@PostMapping("/adminLogin")
	public void adminLogin(@RequestParam("userid") String userid,
							@RequestParam("password") String password,
							Model model) {
//		String msg = memberService.passwordConform(userid, password);
//		model.addAttribute("msg", msg);
	}
	
	@PostMapping("/passwordConform")
	public void passwordConform(@RequestParam("password") String password,
							@RequestParam("passwordConform") String passwordConform,
							Model model) {
		boolean result = memberService.passwordConform(password, passwordConform);
		if(result) {
			model.addAttribute("passwordConform", true);
			model.addAttribute("msg", "비밀번호가 일치합니다.");
		}
		else {
			model.addAttribute("msg", "비밀번호가 일치하지 않습니다.");
			model.addAttribute("msg", false);
		}
	}
	
	@GetMapping("/adminRegister")
	public String adminRegister() {
		return "admin/adminRegister";
	}
	
	@PostMapping("/domainRegister")
	public void domainRegister(@RequestParam("userid") String userid,
								@RequestParam("password") String password,
								@RequestParam("passwordConform") String paswordConform,
								@ModelAttribute Member member,
								Model model) {
		model.addAttribute("msg");
	}
}