package com.example.demo;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller // 어노테이션으로 프로토타입 지정
public class HelloController {

	// url별 작업 맵핑.

	@RequestMapping("/hello")
	public void hello() {// return type string:뷰 페이지 경로
//		return "hello";  //뷰 페이지 경로: "/WEB-INF/views/hello.jsp"
	}

	@GetMapping("/join")
	public void joinForm(String pwd) {

	}

	@PostMapping("/join")
	public String join(@ModelAttribute("m")Member m) {//m:커맨드 객체. 자동으로 뷰페이지로 전달(뷰페이지에서이름:소문자클래스명(member))
		System.out.println("id:" + m.getId());
		System.out.println("pwd:" + m.getPwd());
		System.out.println("name:" + m.getName());
		System.out.println("email:" + m.getEmail());
		return "result";
	}
	
	@GetMapping("/demo/paramtest")
	public String param(HttpServletRequest req, HttpServletResponse res, HttpSession session) {
		String id = req.getParameter("id");
		res.setCharacterEncoding("utf-8");
		session.setAttribute("loginId", id);
		return "";
	}
	
	@GetMapping("/demo/param-map")
	public String paramMap(Map<String, String> map, ModelMap modelmap) {
		map.put("key1", "val1");  //${key1}
		map.put("key2", "val2");
		map.put("key3", "val3");
		
		modelmap.put("key4", "val4");
		modelmap.put("key5", "val5");
		modelmap.put("key6", "val6");
		return "demo/paramtest";
	}

	@GetMapping("/demo/mav")
	public ModelAndView mav() {
		ModelAndView model = new ModelAndView("demo/mav");//생성자에 뷰 페이지 경로 지정
		//뷰 페이지에 전달할 값을 저장
		model.addObject("name", "aaa");
		model.addObject("age", 12);
		return model;
	}
	
	@GetMapping("/demo/modelmap")//뷰 페이지 경로는 url과 동일
	public ModelMap modelmap() {
		ModelMap map = new ModelMap();
		map.addAttribute("name", "aaa");
		map.addAttribute("age", 12);
		return map;
	}
}








