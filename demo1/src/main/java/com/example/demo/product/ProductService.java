package com.example.demo.product;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private ProductDao dao;
	
	//상품 등록
	public void addProduct(Product p ) {
		dao.insert(p);
	}
	
	//번호로 검색
	public Product getProduct(int num) {
		return dao.select(num);
	}
	
	//이름 검색
	public ArrayList<Product> getByName(String name) {
		return dao.selectByname(name);
	}
	//가격검색
	public ArrayList<Product> getByPrice(int price1, int price2) {
		return dao.selectByprice(price1, price2);
	}
	//판매자로 검색
	public ArrayList<Product> getBySeller(String seller) {
		return dao.selectByseller(seller);
	}
	
	//수정
	public void editProduct(Product p) {
		dao.update(p);
	}
	//삭제
	public void delProduct(int num) {
		dao.delete(num);
	}
	//상품 목록
	public ArrayList<Product> getAll() {
		return dao.selectAll();
	}
	
	
}
