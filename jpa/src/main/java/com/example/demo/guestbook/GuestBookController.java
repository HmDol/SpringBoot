package com.example.demo.guestbook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/guestbook")
public class GuestBookController {
	@Autowired
	private GuestBookService service;
	
	//추가 수정
	@GetMapping("/add")
	public void addForm() {
		
	}
	@PostMapping("/save")
	@ResponseBody
	public Map add(GuestBookDto gb) {
		Map map = new HashMap();
		GuestBookDto gb2 = service.saveGuestBook(gb);
		map.put("num", gb2.getNum());
		map.put("writer", gb2.getWriter());
		map.put("wdate", gb2.getWdate());
		map.put("content", gb2.getContent());
		return map;
		
	}
	//목록
	@RequestMapping("/list")
	public String list (Model map){
		ArrayList<GuestBookDto> list = service.getAll();
		map.addAttribute("list",list);
		return "guestbook/list";
	}
	
	//삭제
	@RequestMapping("/save")
	@ResponseBody
	public Map save(GuestBookDto gb) {
		Map map = new HashMap();
		GuestBookDto gb2 = service.saveGuestBook(gb);
		map.put("num", gb2.getNum());
		map.put("writer", gb2.getWriter());
		map.put("wdate", gb2.getWdate());
		map.put("content", gb2.getContent());
		return map;
	}
	
	@RequestMapping("/get")
	@ResponseBody
	public Map get(int num) {
		Map map = new HashMap();
		GuestBookDto gb2 = service.getGuestBook(num);
		map.put("num", gb2.getNum());
		map.put("writer", gb2.getWriter());
		map.put("wdate", gb2.getWdate());
		map.put("content", gb2.getContent());
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
