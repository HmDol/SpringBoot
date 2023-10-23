package com.example.demo;

import org.springframework.stereotype.Repository;

@Repository
public class DemoDao {
	public void insert() {
		System.out.println("insert");
	}
	
	public void select() {
		System.out.println("select");
	}
	
	public void update() {
		System.out.println("update");
	}
	
	public void delete() {
		System.out.println("delete");
	}
}
