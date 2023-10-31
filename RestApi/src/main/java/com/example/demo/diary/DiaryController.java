package com.example.demo.diary;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile; 


@RestController // return 값을 json으로 줌
@CrossOrigin(origins="*") // 정보를 받을 ip를 정함, *는 모든 ip에서 다 받음
@RequestMapping("/diary")
public class DiaryController {
	@Autowired
	private DiaryService service;

	@Value("${spring.servlet.multipart.location}")
	private String path;
	
	
	//전체 출력
	@GetMapping("")
	public Map getAll() {
		ArrayList<DiaryDto> list = service.getAll();
		Map map = new HashMap();
		map.put("list", list);
		return map;
	}

	//추가
	@PostMapping("")
	public Map add(DiaryDto dto) {
		Map map = new HashMap();
		boolean flag = true;
		DiaryDto res = null;
		MultipartFile f = dto.getF();
		
		try {
			String fname = f.getOriginalFilename();
			System.out.println("파일명: " + fname);
			File newFile = new File(path + fname);
			f.transferTo(newFile);
			dto.setFname(fname);
			res = service.save(dto);
		}catch(Exception e){
			flag = false;
			e.printStackTrace();
		}
		map.put("flag", flag);
		map.put("dto", dto);
		return map;
		
	}

	// pk 검색
	@GetMapping("/{num}") 
	public Map get(@PathVariable("num") int num) {
		DiaryDto dto = service.getDiary(num);
		Map map = new HashMap();
		map.put("dto", dto);
		return map;
	}
	
	//수정
	@PutMapping("")
	public Map edit(DiaryDto dto) {
		DiaryDto origin = service.getDiary(dto.getNum());
		origin.setContent(dto.getContent());
		origin.setTitle(dto.getTitle());
		boolean flag = true;
		DiaryDto res = null;
		try {
			res = service.save(origin);
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
			service.delDiary(num);
			
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
