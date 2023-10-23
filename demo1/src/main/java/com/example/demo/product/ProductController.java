package com.example.demo.product;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	//상품 목록
	@RequestMapping("/list")
	public ModelAndView listForm() {
		ArrayList<Product> list = service.getAll();
		ModelAndView mav = new ModelAndView("product/list");
		mav.addObject("list",list);
		return mav;
	}
	
	//상품등록
	@GetMapping("/add")
	public void add() {
		
	}
	
	//상품등록완료
	@PostMapping("/add")
	public String add(Product p ) {
		service.addProduct(p);
		return "redirect:/product/list";
	}
	
	//번호 검색
	@RequestMapping("/get")
	public ModelAndView getbynum(int num) {
		Product p = service.getProduct(num);
		ModelAndView mav = new ModelAndView("product/detail");
		mav.addObject("p",p);
		return mav;
	}
	
	//이름 검색
	@RequestMapping("/getbyname")
	public ModelAndView getbyname(String name) {
		ArrayList<Product> list = service.getByName(name);
		ModelAndView mav = new ModelAndView("product/list");
		mav.addObject("list",list);
		return mav;
	}
	
	//가격 검색
	@RequestMapping("/getbyprice")
	public ModelAndView getbyprice(int price1, int price2) {
		ArrayList<Product> list = service.getByPrice(price1, price2);
		ModelAndView mav = new ModelAndView("product/list");
		mav.addObject("list",list);
		return mav;
	}
	
	//판매자 검색
	@RequestMapping("/getbyseller")
	public ModelAndView getbyprice(String seller) {
		ArrayList<Product> list = service.getBySeller(seller);
		ModelAndView mav = new ModelAndView("product/list");
		mav.addObject("list",list);
		return mav;
	}
	
	//수정
	@GetMapping("/edit")
	public ModelAndView editForm(int num) {
		Product p = service.getProduct(num);
		ModelAndView mav = new ModelAndView("product/edit");
		mav.addObject("p",p);
		return mav;
	}
	
	@PostMapping("/edit")
	public String edit(Product p) {
		service.editProduct(p);
		return "redirect:/product/list";
	}
	
	//삭제
	@GetMapping("/del")
	public String del(int num) {
		service.delProduct(num);
		return "redirect:/product/list";
	}

}
