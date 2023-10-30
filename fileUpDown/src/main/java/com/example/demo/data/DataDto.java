package com.example.demo.data;





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
public class DataDto {
	private int num;
	private String title;
	private Member2 writer;
	private Date wdate;
	private String content;
	private String fname;
	private int cnt;
	private MultipartFile f;

}
