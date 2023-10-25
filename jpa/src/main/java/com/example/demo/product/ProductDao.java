package com.example.demo.product;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.member.Member2;
@Repository
public interface ProductDao extends JpaRepository<Product2, Integer> {
	//상품명 검색
	ArrayList<Product2> findByNameLike(String name);
	
	//가격대로 검색
	ArrayList<Product2> findByPriceBetween(int p1, int p2 );
	
	//판매자로 검색
	ArrayList<Product2> findBySeller(Member2 seller);
}
