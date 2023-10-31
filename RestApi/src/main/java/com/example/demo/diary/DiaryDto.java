package com.example.demo.diary;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

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
public class DiaryDto {
	private int num;
	private Date wdate;
	private String title;
	private String content;
	private String fname;
	private MultipartFile f;
}
