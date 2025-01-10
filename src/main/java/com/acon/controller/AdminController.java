package com.acon.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acon.domain.Member;
import com.acon.service.MemberService;

import jakarta.validation.Valid;

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
		return "admin/list";
	}
	
	@PostMapping("/adminLogin")
	public void adminLogin(@RequestParam("userid") String userid,
							@RequestParam("password") String password,
							Model model) {
//		String msg = memberService.passwordConform(userid, password);
//		model.addAttribute("msg", msg);
	}
	
//	@PostMapping("/passwordConform")
//	public void passwordConform(@RequestBody Map<String, String> request,
//			@RequestParam("password") String password,
//			@RequestParam("passwordConform") String passwordConform,
//			Model model) {
//		boolean result = memberService.passwordConform(password, passwordConform);
//		if(result) {
//			model.addAttribute("passwordConform", true);
//			model.addAttribute("msg", "비밀번호가 일치합니다.");
//		}
//		else {
//			model.addAttribute("msg", "비밀번호가 일치하지 않습니다.");
//			model.addAttribute("msg", false);
//		}
//	}
	
	@PostMapping("/passwordConform")
    public ResponseEntity<Map<String, Object>> validatePassword(@RequestBody Map<String, String> request,
    													@RequestBody @Valid Member member) {
		
        // 비밀번호 확인 (비밀번호 일치 여부만 체크)
        String password = request.get("password");
        String passwordConfirm = request.get("passwordConfirm");
        Map<String, Object> response = new HashMap<>();
        if (password.equals(passwordConfirm)) {
            response.put("success", true);
            response.put("message", "비밀번호가 확인되었습니다.");
        } else {
            response.put("success", false);
            response.put("message", "비밀번호가 일치하지 않습니다.");
        }

        return ResponseEntity.ok(response); // 결과 응답
    }
	
	@GetMapping("/adminRegister")
	public String adminRegister() {
		return "admin/adminRegister";
	}
	
	@PostMapping("/adminRegister")
	public void domainRegister(@Valid @ModelAttribute Member member, Errors errors,
								Model model) {
		System.out.println(member);
		System.out.println(errors.getFieldErrors().size());
		
		model.addAttribute("msg");
	}
}