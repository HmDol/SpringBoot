package com.example.demo.member;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member") // url매핑하긴 위함, 기본 url 설정
public class MemberController {
	@Autowired
	private MemberService service;

	@GetMapping("/join") // get방식으로 /member/join 요청오면 /member/join.jsp 뷰 페이지 실행
	public void joinForm() {
	}

	@PostMapping("/join")
	public String join(Member m) {
		service.join(m);
		return "redirect:/member/list";
	}

	@RequestMapping("/list")
	public ModelAndView list() {
		ArrayList<Member> list = service.getAll();
		ModelAndView mav = new ModelAndView("member/list"); // /member/list.jsp
		mav.addObject("list", list);
		return mav;
	}

	@GetMapping("/get") // 
	public ModelAndView get(String id) {
		Member m = service.getMember(id);
		ModelAndView mav = new ModelAndView("member/detail");
		mav.addObject("m", m); //Modelandview를 담는 명령어
		return mav;
	}

	@PostMapping("/edit")
	public String edit(Member m) {
		service.editMember(m);
		return "redirect:/member/list"; // 뷰 경로 앞에 'redirect:' 를 붙이면 redirect로 이동
	}

	@RequestMapping("/del")
	public String del(String id) {
		service.delMember(id);
		return "redirect:/member/list";
	}

	@GetMapping("/login")
	public void loginForm() {
	}

	@PostMapping("/login")
	public String login(String id, String pwd, HttpSession session) {
		String path = "member/login";
		Member m = service.getMember(id);
		if (m != null && pwd.equals(m.getPwd())) {
			session.setAttribute("loginId", id);
			path = "member/result";
		}
		return path;
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "member/login";
	}
}
