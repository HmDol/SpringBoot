package com.example.demo.board;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService service;
	
	//글목록
	@RequestMapping("/list")
	public void list(ModelMap map) {//map은 자동으로 뷰페이지로 전달됨
		ArrayList<Board> list = service.getAll();
		map.addAttribute("list", list);
		//뷰 페이지 경로: /board/list.jsp
	}
	
	//글작성폼
	@GetMapping("/add")
	public void addForm() {}
	
	//글작성
	@PostMapping("/add")
	public String add(Board b) {
		service.addBoard(b);
		return "redirect:/board/list";
	}
	
	//글번호로검색(수정폼)
	@GetMapping("/edit")
	public void editForm(int num, ModelMap map) {
		Board b = service.getBoard(num);
		map.addAttribute("b", b);
	}
	
	//수정완료
	@PostMapping("/edit")
	public String edit(Board b) {
		service.editBoard(b);
		return "redirect:/board/list";
	}
	
	//삭제
	@RequestMapping("/del")
	public String del(int num) {
		service.delBoard(num);
		return "redirect:/board/list";
	}
}
