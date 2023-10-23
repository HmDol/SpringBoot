package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
	@Autowired  //의존성 자동 주입
	private DemoDao dao;
	
	public void add() {
		System.out.println("service / add");
		dao.insert();
	}
	
	public void get() {
		System.out.println("service / get");
		dao.select();
	}
	
	public void edit() {
		System.out.println("service / edit");
		dao.update();
	}
	
	public void del() {
		System.out.println("service / del");
		dao.delete();
	}
}
