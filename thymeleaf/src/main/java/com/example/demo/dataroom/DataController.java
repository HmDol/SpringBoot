package com.example.demo.dataroom;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/data")
public class DataController {
	@Autowired
	private DataService service;
	
	@Value("${dataroom.path}")
	private String path;
	
	@RequestMapping("/list")
	public void list(Model m) {
		ArrayList<DataDto> list = service.getAll();
		m.addAttribute("list", list);
	}
	
	@GetMapping("/add")
	public void addForm() {
	}

	@PostMapping("/add")
	public String add(DataDto dto) {
		MultipartFile f = dto.getF();
		String fname = f.getOriginalFilename();
		File newFile = new File(path + fname);
		try {
			f.transferTo(newFile);
			dto.setFname(fname);
			service.saveData(dto);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/data/list";
	}
	
	@RequestMapping("/detail")
	public void detail(int num, Model m) {
		DataDto d = service.getData(num);
		m.addAttribute("data", d);
	}
	
	@PostMapping("/getbyfname")
	public String getbyfname(String type, Model m) {
		System.out.println(type);
		ArrayList<DataDto> list = service.getByFname(type);
		m.addAttribute("list", list);
		return "data/list";
	}
	
	@RequestMapping("/downpage")
	public String downpage(String fname, int num, Model m) {
		m.addAttribute("fname", fname);
		m.addAttribute("num", num);
		return "data/down";
	}
	@RequestMapping("/down")
	public ResponseEntity<byte[]> down(String fname, int num){//fname: 파일명
		File f = new File(path + fname);//파일 객체 생성
		
		//응답의 헤더. 응답 페이지의 크기, 마임타입, 첨부파일.. 정보를 갖는다
		HttpHeaders header = new HttpHeaders();
		
		//ResponseEntity: 응답 데이터
		ResponseEntity<byte[]> result = null;
		try {
			//헤더에 다운로드 파일의 마임 타입을 타깃 파일과 동일하게 설정 
			header.add("Content-Type", Files.probeContentType(f.toPath()));
			//헤더에 다운로드 파일의 정보 추가. 파일명, 인코딩 설정
			header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\""+URLEncoder.encode(fname, "UTF-8")+"\"");
			result = new ResponseEntity<byte[]>(
						FileCopyUtils.copyToByteArray(f), header, HttpStatus.OK
					);
			service.editCnt(num);//다운수 1증가
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
