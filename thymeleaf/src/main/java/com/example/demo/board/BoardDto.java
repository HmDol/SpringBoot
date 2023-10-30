package com.example.demo.board;

import java.util.Date;

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
public class BoardDto {
	private int num;
	private Date wdate;
	private Member2 writer;
	private String title;
	private String content;
}
