package com.example.demo.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.auth.JwtTokenProvider;
import com.example.demo.auth.SecurityMember;

@RestController // rest api controller
@CrossOrigin(origins = "*") // 모든 ip로부터 요청 받기 허용
public class MemberController {
	@Autowired
	private MemberService service;

	@Autowired
	private JwtTokenProvider tokenprovider;

	@Autowired
	private AuthenticationManagerBuilder authenticationManagerBuilder;

	@PostMapping("/login")
	public Map login(String id, String pwd) {
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(id, pwd);
	    Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
	    System.out.println(authentication.isAuthenticated());
	    
	    Map map = new HashMap();
		boolean flag = authentication.isAuthenticated();
		
		if (flag) {
			String token = tokenprovider.generateJwtToken(new MemberDto(id, "","",""));
			flag = true;
			map.put("token", token);
		}
		map.put("flag", flag);
		return map;
	}

	@GetMapping("/auth/info")
	public Map myinfo() {
		Map map = new HashMap();
		boolean flag = true;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String id = authentication.getName();
		MemberDto m = service.getMember(id);
		System.out.println(m);
		if (m == null) {
			flag = false;
		} else {
			map.put("m", m);
		}
		map.put("flag", flag);
		return map;
	}

	@PutMapping("/members")
	public Map myinfo(@RequestHeader("token") String token, MemberDto dto) {
		Map map = new HashMap();
		boolean flag = false;
		String id = tokenprovider.getUsernameFromToken(token);
		if (id.equals(dto.getId())) {
			flag = true;
			service.save(dto);
		}
		map.put("flag", flag);
		return map;
	}
}
