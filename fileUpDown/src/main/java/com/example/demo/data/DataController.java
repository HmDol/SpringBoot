package com.example.demo.data;


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
import org.springframework.ui.ModelMap;
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
	
	@Value("${spring.servlet.multipart.location}")
	private String path;
	
	@RequestMapping("/list")
	public void list(Model m) {
		ArrayList<DataDto> list = service.getAll();
		m.addAttribute("list",list);
		
	}
	
	@RequestMapping("/getbywriter")
	public String getByWriter(String writer ,Model m) {
		ArrayList<DataDto> list = service.getByWriter(writer);
		m.addAttribute("list",list);
		return "redirect:/data/list";
	}
	
	@RequestMapping("/getbytitle")
	public String getByTitle(String title ,Model m) {
		ArrayList<DataDto> list = service.getByTitle("%"+title+"%");
		m.addAttribute("list",list);
		return "redirect:/data/list";
	}
	
	@GetMapping("/add")
	public void addForm() {
		
	}
	
	@PostMapping("/add")
	public String add(DataDto dto) {
		dto.setCnt(0);
		MultipartFile f = dto.getF();
		String fname = f.getOriginalFilename();
		File newFile = new File(path + fname);
		try {
			f.transferTo(newFile);
			dto.setFname(fname);
			service.save(dto);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/data/list"; 
	}
	
	@GetMapping("/edit")
	public void detailForm(int num, ModelMap map) {
		DataDto dto = service.getData(num);
		map.addAttribute("dto",dto);
	}
	
	@PostMapping("/edit")
	public String edit(DataDto dto) {
		MultipartFile f = dto.getF();
		DataDto origin = service.getData(dto.getNum());
		if(f!=null && f.getSize() > 0) {
			String fname = f.getOriginalFilename();
			File newFile = new File(path + fname);
			try {
				f.transferTo(newFile);
				dto.setFname(fname);
				File delFile = new File(path + origin.getFname());
				delFile.delete();
				
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			dto.setFname(origin.getFname());
		}
		dto.setWdate(origin.getWdate());
		service.save(dto);
		return "redirect:/data/list";
		
	}
	@RequestMapping("/updatecnt")
	public String updateCnt(int num) {
		service.changeCnt(num);
		return "redirect:/data/edit?nem="+num;
	}
	@RequestMapping("/del")
	public String del(int num) {
		service.Delete(num);
		return "redirect:/data/list";
	}
	@RequestMapping("/down")
	public ResponseEntity<byte[]> read_img(String fname) { // fname: 파일명
		File f = new File(path + fname); // 파일 객체 생성

		// 응답의 헤더. 응답 페이지의 크기, 마임타입, 첨부파일..등의 정보를 갖는다.
		HttpHeaders header = new HttpHeaders();

		// ResponseEntity:응답을 데이터로 보냄
		ResponseEntity<byte[]> result = null;
		try {
			//헤더엗 ㅏ운로드 파일의 타입을 다킷 파일과 동일하게 설정
			header.add("Content-Type", Files.probeContentType(f.toPath()));
			//헤더에 다운로드 파일의 정보 추가. 파일명, 인코딩
			header.add(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename=\""+URLEncoder.encode(fname,"UTF-8")+"\"");
			result = new ResponseEntity<byte[]>(
					FileCopyUtils.copyToByteArray(f), header, HttpStatus.OK
					);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
