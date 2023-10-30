package com.example.demo.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member") //이 컨트롤러의 기본 url 설정
public class MemberController {
	@Autowired
	private MemberService service;

	@GetMapping("/join") // get방식으로 /member/join 요청오면 /member/join.jsp 뷰 페이지 실행
	public void joinForm() {
	}

	@PostMapping("/join")
	public String join(MemberDto m) {
		service.save(m);
		return "redirect:/";
	}

	@GetMapping("/get")
	public ModelAndView get(String id) {
		MemberDto m = service.getMember(id);
		ModelAndView mav = new ModelAndView("member/detail");
		mav.addObject("m", m);
		return mav;
	}

	@PostMapping("/edit")
	public String edit(MemberDto m) {
		service.save(m);
		return "redirect:/"; // 뷰 경로 앞에 'redirect:' 를 붙이면 redirect로 이동
	}

	@RequestMapping("/del")
	public String del(String id) {
		service.delMember(id);
		return "redirect:/";
	}

	@GetMapping("/login")
	public void loginForm() {
	}

	@PostMapping("/login")
	public String login(String id, String pwd, HttpSession session) {
		String path = "member/login";
		MemberDto m = service.getMember(id);
		if (m != null && pwd.equals(m.getPwd())) {
			session.setAttribute("loginId", id);
			path = "redirect:/data/list";
		}
		return path;
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
