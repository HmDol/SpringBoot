package com.example.demo.member;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity  //jpa table
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Member2 {
	@Id // pk 지정
	private String id;
	private String pwd;
	private String name;
	private String email;
}
