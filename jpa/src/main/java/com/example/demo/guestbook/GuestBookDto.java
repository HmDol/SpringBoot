package com.example.demo.guestbook;

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
public class GuestBookDto {
	private int num;
	private Member2 writer;
	private Date wdate;
	private String content;
	
}
