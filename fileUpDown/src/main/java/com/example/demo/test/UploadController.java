package com.example.demo.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/test")
public class UploadController {
	@Value("${spring.servlet.multipart.location}") // 밑의 변수에 값을 할당
	private String path;
	
	@RequestMapping("")
	public String form() {
		return "test/form";
	}
	
	@PostMapping("/upload")
	public String upload(MultipartFile f, String title) {
		String fname=f.getOriginalFilename();
		File newFile = new File(path + fname);
		System.out.println("title:" + title);
		System.out.println("newFile:" + newFile.getAbsolutePath());
		try {
			f.transferTo(newFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/test/list";
		
	}
	
	   @RequestMapping("/list")
	   public void flist(Model m) {
	      File dir = new File(path);
	      String[] files = dir.list();
	      m.addAttribute("files",files);
	   }
	   
	   //파일명을 파람으로 받아서 파일 내용을 복사하여 바이너리 형태의 응답으로 보내줌
	   @RequestMapping("/read-img")
	   public ResponseEntity<byte[]> read_img(String fname){ // fname: 파일명
		  File f = new File(path+fname); // 파일 객체 생성
		  
		  //응답의 헤더. 응답 페이지의 크기, 마임타입, 첨부파일..등의 정보를 갖는다.
		  HttpHeaders header = new HttpHeaders();
		  
		  //ResponseEntity:응답을 데이터로 보냄
		  ResponseEntity<byte[]> result = null;
		  try {
			header.add("Content-Type", Files.probeContentType(f.toPath()));
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
