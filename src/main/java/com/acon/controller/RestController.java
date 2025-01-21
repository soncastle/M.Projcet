package com.acon.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.web.bind.annotation.RestController("/rest")
public class RestController {
	
	@GetMapping("/address")
	  public ResponseEntity<?> handleAddress(@RequestBody Map<String, String> request) {
        String address = request.get("address");

        // 서버에서 address를 처리하는 로직을 추가
        System.out.println("받은 주소: " + address);

        // 응답 데이터 보내기
        return ResponseEntity.ok("주소 처리 완료: " + address);
    }
}