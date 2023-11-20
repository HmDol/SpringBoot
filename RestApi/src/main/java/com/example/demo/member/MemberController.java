package com.example.demo.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.JwtTokenProvider;

@RestController // rest api controller
@CrossOrigin(origins = "*") // 모든 ip로부터 요청 받기 허용
@RequestMapping("/member") // 기본 url: restshop
public class MemberController {
	@Autowired
	private MemberService service;
	
	@Autowired
	private JwtTokenProvider tokenprovider;
	
	//로그인
	@GetMapping("/auth")
	public Map login(String id, String pwd) {
		System.out.println("여기 들어옴");
		Map map = new HashMap();
		boolean flag = false;
		MemberDto m = service.getMember(id);
		if(m!=null && pwd.equals(m.getPwd())) {
			String token = tokenprovider.generateJwtToken(m); // 토큰 생성
			System.out.println("token: "+ token);
			flag = true;
			map.put("token", token);
		}
		map.put("flag", flag);
		return map;
	}
	
	 // 검색
    @GetMapping("")
    public Map Myinfo(@RequestHeader("token") String token) {
        boolean flag = false;
        Map map = new HashMap();
        String id = tokenprovider.getUsernameFromToken(token);
        MemberDto m = service.getMember(id);
        if(m==null) {
            flag = false;        	
        }else {
        	map.put("dto", m);	
        }
        map.put("flag", flag);
        return map;
    }
    
    @PutMapping("")
    public Map eidtInfo(@RequestHeader("token") String token, MemberDto dto) {
    	boolean flag = false;
    	Map map = new HashMap();
    	String id = tokenprovider.getUsernameFromToken(null);
    	if(id.equals(dto.getId())) {
    		flag = true;
    		service.save(dto);
    	}
    	map.put("flag", flag);
 
    	return map;
    }
	
	
}
