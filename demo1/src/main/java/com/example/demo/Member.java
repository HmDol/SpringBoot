package com.example.demo;

import java.util.ArrayList;

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
public class Member {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private ArrayList<Files> list;
}
