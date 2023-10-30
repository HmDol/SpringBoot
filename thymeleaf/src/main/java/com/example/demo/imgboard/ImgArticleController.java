package com.example.demo.imgboard;

import java.io.File;
import java.io.IOException;
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
@RequestMapping("/imgboard")
public class ImgArticleController {
	@Autowired
	private ImgArticleService service;

	@Value("${spring.servlet.multipart.location}")
	private String path;

	@RequestMapping("/list")
	public void list(Model m) {
		ArrayList<ImgArticleDto> list = service.getAll();
		m.addAttribute("list", list);
	}

	@GetMapping("/add")
	public void addForm() {
	}

	@PostMapping("/add")
	public String add(ImgArticleDto dto) {
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
		return "redirect:/imgboard/list";
	}

	@GetMapping("/edit")
	public void editForm(int num, Model m) {
		ImgArticleDto dto = service.getArticle(num);
		m.addAttribute("dto", dto);
	}

	@PostMapping("/edit")
	public String edit(ImgArticleDto dto) {
		MultipartFile f = dto.getF();
		ImgArticleDto origin = service.getArticle(dto.getNum());
		if (f != null && f.getSize() > 0) {//업로드 했을때
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
		} else {
			System.out.println("원본파일:" + origin.getFname());
			dto.setFname(origin.getFname());
		}
		dto.setWdate(origin.getWdate());
		service.save(dto);
		return "redirect:/imgboard/list";
	}

	@GetMapping("/del")
	public String del(int num) {
		ImgArticleDto origin = service.getArticle(num);
		File delFile = new File(path + origin.getFname());
		delFile.delete();
		service.delArticle(num);
		return "redirect:/imgboard/list";
	}
	
	@RequestMapping("/read-img")
	public ResponseEntity<byte[]> read_img(String fname) {// fname: 파일명
		File f = new File(path + fname);// 파일 객체 생성

		// 응답의 헤더. 응답 페이지의 크기, 마임타입, 첨부파일.. 정보를 갖는다
		HttpHeaders header = new HttpHeaders();

		// ResponseEntity: 응답 데이터
		ResponseEntity<byte[]> result = null;
		try {
			header.add("Content-Type", Files.probeContentType(f.toPath()));
			result = new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(f), header, HttpStatus.OK);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
