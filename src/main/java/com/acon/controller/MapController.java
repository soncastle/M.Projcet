package com.acon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.acon.service.ServiceService;

@Controller
@RequestMapping("/map")
public class MapController {
	
	@GetMapping("/map")
	public String map(Model model) {
		String serviceKey = ServiceService.key("map");
		model.addAttribute("serviceKey", serviceKey);
		return "map/map4";
	}
	
	@PostMapping("/map")
	public String map(Model model) {
		String serviceKey = ServiceService.key("map");
		model.addAttribute("serviceKey", serviceKey);
		return "map/map";
	}
	
	@GetMapping("/weather")
	public String weather(Model model) {
		String serviceKey = ServiceService.key("weather");
		model.addAttribute("serviceKey", serviceKey);
		return "map/weather";
	}
	
	@GetMapping("/weather2")
	public String weather2(Model model) {
		String serviceKey = ServiceService.key("weather");
		model.addAttribute("serviceKey", serviceKey);
		return "map/weather2";
	}
	
	@GetMapping("/address")
	public String address() {
		return "member/address";
	}
	

}
