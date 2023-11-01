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

	public BookDto saveBook(BookDto b) {
		Book2 b2 = dao.save(new Book2(b.getNum(), b.getWriter(), b.getWdate(), b.getContent()));
		return new BookDto(b2.getNum(), b2.getWriter(), b2.getWdate(), b2.getContent());
	}

	public BookDto getBook(int num) {
		Book2 b = dao.findById(num).orElse(null);
		if (b == null) {
			return null;
		}
		return new BookDto(b.getNum(), b.getWriter(), b.getWdate(), b.getContent());
	}

	public ArrayList<BookDto> getAll() {
		List<Book2> l = dao.findAll(Sort.by(Sort.Direction.DESC, "num"));//전체 검색에 정렬 추가
		ArrayList<BookDto> list = new ArrayList<>();
		for (Book2 b : l) {
			list.add(new BookDto(b.getNum(), b.getWriter(), b.getWdate(), b.getContent()));
		}
		return list;
	}
	
	public void delBook(int num) {
		dao.deleteById(num);
	}
}





