package com.example.demo.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private ProductDao dao;

	// 추가, 수정
	public ProductDto saveProduct(ProductDto p) {
		Product2 p2 = dao.save(new Product2(p.getNum(), p.getName(), p.getPrice(), p.getAmount(), p.getSeller()));
		return new ProductDto(p2.getNum(), p2.getName(), p2.getPrice(), p2.getAmount(), p2.getSeller());
	}

	public ProductDto getProduct(int num) {
		Product2 p = dao.findById(num).orElse(null);
		if (p == null) {
			return null;
		}
		return new ProductDto(p.getNum(), p.getName(), p.getPrice(), p.getAmount(), p.getSeller());
	}

	public ArrayList<ProductDto> getAll() {
		List<Product2> l = dao.findAll();
		ArrayList<ProductDto> list = new ArrayList<>();
		for (Product2 p : l) {
			list.add(new ProductDto(p.getNum(), p.getName(), p.getPrice(), p.getAmount(), p.getSeller()));
		}
		return list;
	}

	public void delProduct(int num) {
		dao.deleteById(num);
	}
//	public ArrayList<Product> getBySeller(String seller){
//		return dao.selectBySeller(seller);
//	}
//	
//	public ArrayList<Product> getByName(String name){
//		return dao.selectByName(name);
//	}
//	
//	public ArrayList<Product> getByPrice(int p1, int p2){
//		return dao.selectByPrice(p1, p2);
//	}

}
