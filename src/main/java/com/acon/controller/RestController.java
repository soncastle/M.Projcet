package com.acon.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.web.bind.annotation.RestController("/rest")
public class RestController {
	
	@GetMapping("/address")
	  public String handleAddress() {
        return "";
    }
}