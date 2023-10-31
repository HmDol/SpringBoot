package com.example.demo.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;



@Service
public class BookService {
	
	@Autowired
	private BookDao dao;
	
	//작성 및 수정
	public BookDto saveBook(BookDto gb) {
		Book2 gb2 = dao.save(new Book2(gb.getNum(), gb.getWriter(), gb.getWdate(), gb.getContent()));
		return new BookDto(gb2.getNum(), gb2.getWriter(), gb2.getWdate(), gb2.getContent()); // DTO로 변환
	}
	//자기글 삭제
	public void delBook(int num) {
		dao.deleteById(num);
	}
	
	public BookDto getBook(int num) {
		Book2 gb = dao.findById(num).orElse(null);
		if(gb == null) {
			return null;
		}
		return new BookDto(gb.getNum(), gb.getWriter(), gb.getWdate(), gb.getContent());
	}
	
	//글 목록
	public ArrayList<BookDto> getAll(){
		List<Book2> list = dao.findAll(Sort.by(Sort.Direction.DESC,"num"));
		ArrayList<BookDto> list2 = new ArrayList<>();
		for(Book2 gb : list) {
			list2.add(new BookDto(gb.getNum(),gb.getWriter(), gb.getWdate(),gb.getContent()));
		}
		return list2;
	}
}
