package com.example.demo.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService service;
	
	@RequestMapping("/list")
	public void list(Model model) {
		ArrayList<ProductDto> list = service.getAll();
		model.addAttribute("list", list);
	}
	
	@GetMapping("/add")
	public void addForm() {}
	
	@PostMapping("/add")
	public String add(ProductDto p) {
		service.saveProduct(p);
		return "redirect:/product/list";
	}
	
	@RequestMapping("/get")
	public String detail(int num, ModelMap m) {
		ProductDto p = service.getProduct(num);
		m.addAttribute("p", p);
		return "product/detail";
	}
	
	@ResponseBody  //맵핑 메서드의 리턴값이 뷰 페이지 경로가 아니라 값이다
	@RequestMapping("/getjson")
	public Map getjson(int num) {
		Map<String, String> map = new HashMap<>();
		ProductDto p = service.getProduct(num);
		map.put("num", p.getNum()+"");
		map.put("seller", p.getSeller().getId());
		map.put("name", p.getName());
		map.put("price", p.getPrice()+"");
		map.put("amount", p.getAmount()+"");
		return map;
	}
	
	@ResponseBody
	@PostMapping("/edit")
	public Map edit(ProductDto p) {
		ProductDto res = service.saveProduct(p);
		Map<String, String> map = new HashMap<>();
		map.put("num", res.getNum()+"");
		map.put("seller", res.getSeller().getId());
		map.put("name", res.getName());
		map.put("price", res.getPrice()+"");
		map.put("amount", res.getAmount()+"");
		return map;
	}
	
	//상품명으로 검색(like 패턴으로 여러개 검색)
	@RequestMapping("/getbyname")
	public String getByName(String name, Model map) {
		ArrayList<ProductDto> list = service.getByName(name);
		map.addAttribute("list", list);
		return "/product/list";
	}
	
	//가격대로 검색(1000~2000)
	@RequestMapping("/getbyprice")
	public String getByPrice(int p1, int p2, Model map) {
		ArrayList<ProductDto> list = service.getByPrice(p1, p2);
		map.addAttribute("list", list);
		return "/product/list";
	}
	
	//판매자로 검색
	@RequestMapping("/getbyseller")
	public String getBySeller(String seller, Model map) {
		ArrayList<ProductDto> list = service.getBySeller(seller);
		map.addAttribute("list", list);
		return "/product/list";
	}
}








