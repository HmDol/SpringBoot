package com.example.demo.member;

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
public class MemberDto {//값 전달 용도 클래스
	private String id;
	private String pwd;
	private String name;
	private String email;
}
