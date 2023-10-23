package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")  //이 컨트롤러의 기본 url 설정
public class DemoController {
	
	@Autowired
	private DemoService service;
	
	@RequestMapping("/add")
	public String add() {
		service.add(); //기능구현
		return "result";  // return "/WEB-INF/views/result.jsp";
	}
	
	@RequestMapping("/get")
	public String get() {
		service.get(); //기능구현
		return "result";  // return "/WEB-INF/views/result.jsp";
	}
	
	@RequestMapping("/edit")
	public String edit() {
		service.edit(); //기능구현
		return "result";  // return "/WEB-INF/views/result.jsp";
	}
	
	@RequestMapping("/del")
	public String del() {
		service.del(); //기능구현
		return "result";  // return "/WEB-INF/views/result.jsp";
	}
}
