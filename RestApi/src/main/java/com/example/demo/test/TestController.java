package com.example.demo.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // return 값을 json으로 줌
@CrossOrigin(origins="*") // 정보를 받을 ip를 정함, *는 모든 ip에서 다 받음
@RequestMapping("/books")
public class TestController {
	
	@Autowired
	private BookService service;
	
	// 추가
	@PostMapping("")
	public Map add(BookDto dto) {
		boolean flag = true;
		BookDto res = null;
		try {
			res = service.saveBook(dto);
		}catch(Exception e) {
			flag = false;
		}
		Map map = new HashMap();
		map.put("flag", flag);
		map.put("dto", res);
		return map;
	}
	
	// pk 검색
	@GetMapping("/{num}") // ex. books/3  ==> PathVariable : 파람을 일반 URL처럼 준다
	public Map get(@PathVariable("num") int num) {
		BookDto dto = service.getBook(num);
		Map map = new HashMap();
		map.put("dto", dto);
		return map;
	}
	
	// 전체 검색 
	@GetMapping("")
	public Map getAll() {
		ArrayList<BookDto> list = service.getAll();
		Map map = new HashMap();
		map.put("list", list);
		return map;
	}
	
	// 수정
	@PutMapping("")
	public Map edit(BookDto dto) {
		BookDto origin = service.getBook(dto.getNum());
		origin.setContent(dto.getContent());
		boolean flag = true;
		BookDto res = null;
		try {
			res = service.saveBook(origin);
		}catch(Exception e) {
			flag = false;
		}
		Map map = new HashMap();
		map.put("flag", flag);
		map.put("dto", res);
		return map;
	}
	
	// 삭제
	@DeleteMapping("/{num}")
	public Map del(@PathVariable("num") int num) {
		boolean flag = true;
		try {
			service.delBook(num);
			
		}catch(Exception e) {
			System.out.println(e);
			flag = false;
		}
		Map map = new HashMap();
		map.put("flag", flag);
		map.put("num", num);
		return map;
	}
}
