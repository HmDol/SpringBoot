package com.example.demo.board;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.member.Member2;

@Service
public class BoardService {
	@Autowired
	private BoardDao dao;
	
	//DTO로 받고 ,전달하고 해야함
	
	//추가, 수정. dao.save()
	public BoardDto saveBoard(BoardDto b) {
		Board2 b2 = dao.save(new Board2(b.getNum(), b.getWdate(), b.getWriter(), b.getTitle(), b.getContent()));
		return new BoardDto(b2.getNum(), b2.getWdate(), b2.getWriter(), b2.getTitle(), b2.getContent()); // DTO로 변환
	}
	
	//pk로 검색. dao.findById()
	public BoardDto getBoard(int num) {
		Board2 b = dao.findById(num).orElse(null); // 없으면 NULL 반환
		return new BoardDto(b.getNum(), b.getWdate(), b.getWriter(), b.getTitle(), b.getContent());
	}
	
	//전제검색. dao.findAll()
	public ArrayList<BoardDto> getAll(){
		List<Board2> list = dao.findAll();
		ArrayList<BoardDto> list2 = new ArrayList<>();
		for(Board2 b : list) { 
			list2.add(new BoardDto(b.getNum(), b.getWdate(), b.getWriter(), b.getTitle(), b.getContent()));
		}
		return list2;
	}
	
	//pk 기준 삭제. dao.deleteById()
	public void delBoard(int num) {
		dao.deleteById(num);
	}
	
	//작성자로 검색
	public ArrayList<BoardDto> getByWriter(String writer){
		List<Board2> list = dao.findByWriter(new Member2(writer,"","",""));
		ArrayList<BoardDto> list2 = new ArrayList<>();
		for(Board2 b : list) {
			list2.add(new BoardDto(b.getNum(), b.getWdate(), b.getWriter(), b.getTitle(), b.getContent()));
		}
		return list2;
	}
	
	//제목으로 검색
	public ArrayList<BoardDto> getByTitle(String title){
		List<Board2> list = dao.findByTitleLike("%"+title+"%");
		ArrayList<BoardDto> list2 = new ArrayList<>();
		for(Board2 b : list) {
			list2.add(new BoardDto(b.getNum(), b.getWdate(), b.getWriter(), b.getTitle(), b.getContent()));
		}
		return list2;
	}
}
