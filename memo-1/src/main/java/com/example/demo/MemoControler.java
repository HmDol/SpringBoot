package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/memo")
public class MemoControler {
	@Autowired
	private MyMemoService service;
	
	//추가
	@PostMapping("")
	public Map add(MyMemoDto d) {
		MyMemoDto d2 = service.save(d);
		Map map = new HashMap();
		map.put("dto", d2);
		return map;
	}
	
	//검색
	@GetMapping("/{num}")
	public Map get(@PathVariable("num") int num) {
		MyMemoDto d2 = service.getMyMemo(num);
		Map map = new HashMap();
		map.put("dto", d2);
		return map;
		
	}
	//전체 검색
	@GetMapping("")
	public Map getAll() {
		ArrayList<MyMemoDto> list = service.getAll();
		Map map = new HashMap();
		map.put("list",list);
		return map;
	}
	
	//수정
	@PutMapping("")
	public Map edit(MyMemoDto d) {
		MyMemoDto d2 = service.save(d);
		Map map = new HashMap();
		map.put("dto", d2);
		return map;
	}
	
	//삭제
	@DeleteMapping("/{num}")
	public Map delete(@PathVariable("num") int num) {
		service.delMyMemo(num);
		Map map = new HashMap();
		map.put("num", num);
		return map;
	}
}
