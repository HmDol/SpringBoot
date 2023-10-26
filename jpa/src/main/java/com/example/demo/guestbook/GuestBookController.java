package com.example.demo.guestbook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.member.Member2;

@Controller
@RequestMapping("/guestbook")
public class GuestBookController {
	@Autowired
	private GuestBookService service;
	
	@RequestMapping("")
	public String GuestBookHome(Model m) {
		ArrayList<GuestBookDto> list = service.getAll();
		m.addAttribute("list", list);
		return "guestbook/list";
	}
	
	@PostMapping("/save")
	@ResponseBody
	public Map save(GuestBookDto b, int type) {
		if(type==2) {
			GuestBookDto bb = service.getGuestBook(b.getNum());
			b.setWriter(new Member2(bb.getWriter().getId(), "", "", ""));
			b.setWdate(bb.getWdate());
		}
		Map map = new HashMap();
		GuestBookDto b2 = service.saveGuestBook(b);
		map.put("num", b2.getNum());
		map.put("writer", b2.getWriter().getId());
		map.put("wdate", b2.getWdate());
		map.put("content", b2.getContent());
		return map;
	}
	
	@RequestMapping("/get")
	@ResponseBody
	public Map get(int num) {
		Map map = new HashMap();
		GuestBookDto b2 = service.getGuestBook(num);
		map.put("num", b2.getNum());
		map.put("writer", b2.getWriter().getId());
		map.put("wdate", b2.getWdate());
		map.put("content", b2.getContent());
		return map;
	}
	
	@RequestMapping("/del")
	@ResponseBody
	public Map del(int num) {
		Map map = new HashMap();
		service.delGuestBook(num);
		map.put("num", num);
		return map;
	}
}






