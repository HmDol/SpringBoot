package com.example.demo.imgboard;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.member.Member2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ImgArticleDto {

	private int num;
	private Member2 writer;
	private Date wdate;
	private String title;
	private String content;
	private String fname;
	private MultipartFile f;

}
