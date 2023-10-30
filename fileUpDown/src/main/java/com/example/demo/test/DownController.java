package com.example.demo.test;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/down")
public class DownController {
	private String downPath = "C:/down/";

	@RequestMapping("/list")
	public void list(Model m) {
		File dir = new File(downPath);
		String[] files = dir.list();
		m.addAttribute("files", files);
	}

	@RequestMapping("/down")
	public ResponseEntity<byte[]> read_img(String fname) { // fname: 파일명
		File f = new File(downPath + fname); // 파일 객체 생성

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
