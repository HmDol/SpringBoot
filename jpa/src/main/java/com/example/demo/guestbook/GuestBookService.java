package com.example.demo.guestbook;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;



@Service
public class GuestBookService {
	
	@Autowired
	private GuestBookDao dao;
	
	//작성 및 수정
	public GuestBookDto saveGuestBook(GuestBookDto gb) {
		GuestBook2 gb2 = dao.save(new GuestBook2(gb.getNum(), gb.getWriter(), gb.getWdate(), gb.getContent()));
		return new GuestBookDto(gb2.getNum(), gb2.getWriter(), gb2.getWdate(), gb2.getContent()); // DTO로 변환
	}
	//자기글 삭제
	public void delGuestBook(int num) {
		dao.deleteById(num);
	}
	
	public GuestBookDto getGuestBook(int num) {
		GuestBook2 gb = dao.findById(num).orElse(null);
		if(gb == null) {
			return null;
		}
		return new GuestBookDto(gb.getNum(), gb.getWriter(), gb.getWdate(), gb.getContent());
	}
	
	//글 목록
	public ArrayList<GuestBookDto> getAll(){
		List<GuestBook2> list = dao.findAll(Sort.by(Sort.Direction.DESC,"num"));
		ArrayList<GuestBookDto> list2 = new ArrayList<>();
		for(GuestBook2 gb : list) {
			list2.add(new GuestBookDto(gb.getNum(),gb.getWriter(), gb.getWdate(),gb.getContent()));
		}
		return list2;
	}
}
