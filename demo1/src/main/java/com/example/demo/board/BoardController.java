package com.example.demo.board;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	//글목록
	@RequestMapping("/list")
	public ModelAndView listForm() {
		ArrayList<Board> list = service.getAll();
		ModelAndView mav = new ModelAndView("board/list");
		mav.addObject("list",list);
		return mav;
	}
	
	
	//글 작성폼
	@GetMapping("/add")
	public void add() {
		
	}
	
	//글작성
	@PostMapping("/add")
	public String add(Board b) {
		service.addBoard(b);
		return "redirect:/board/list";
	}
	
	//글번호로 검색(수정폼)
	@GetMapping("/edit")
	public ModelAndView get(int num) {
		Board b = service.getBoard(num);
		ModelAndView mav = new ModelAndView("board/detail");
		mav.addObject("b",b);
		return mav;
	}
	
	//수정
	@PostMapping("/edit")
	public String eidt(Board b) {
		service.editBoard(b);
		return "redirect:/board/list";
	}
	
	//삭제
	@GetMapping("/del")
	public String del(int num) {
		service.delBoard(num);
		return "redirect:/board/list";
	}
}
