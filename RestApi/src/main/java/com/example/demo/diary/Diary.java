package com.example.demo.diary;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity // jpa table
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Diary {
	@Id // pk지정
	@SequenceGenerator(name = "seq_gen", sequenceName = "seq_diary", allocationSize = 1) 																						
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_diary")
	private int num;
	private Date wdate;
	private String title;
	private String content;
	private String fname;
	
	@PrePersist // insert문 실행전 자동 호출
	public void setDate() {
		wdate = new Date();
	}
}
