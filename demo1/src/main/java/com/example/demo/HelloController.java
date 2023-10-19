package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HelloController {
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/join")
	public void joinForm() {
		
	}
	@PostMapping("/join")
	public String join(Member m) { // m: 커맨드 객체. 자동으로 뷰 페이지로 전달(뷰에서는 member)
		System.out.println("id: " + m.getId());
		System.out.println("pwd: " + m.getPwd());
		System.out.println("name: " + m.getName());
		System.out.println("id: " + m.getEmail());
		return "result";
	}
	
	
}
