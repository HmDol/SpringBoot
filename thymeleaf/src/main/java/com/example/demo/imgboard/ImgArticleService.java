package com.example.demo.imgboard;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImgArticleService {
	@Autowired
	private ImgArticleDao dao;
	
	//추가, 수정
	public ImgArticleDto save(ImgArticleDto dto) {
		ImgArticle a = dao.save(new ImgArticle(dto.getNum(), dto.getWriter(), dto.getWdate(), dto.getTitle(),
				dto.getContent(), dto.getFname()));
		return new ImgArticleDto(a.getNum(), a.getWriter(), a.getWdate(), a.getTitle(), a.getContent(), 
				a.getFname(), null);
	}
	
	//pk로 검색
	public ImgArticleDto getArticle(int num) {
		ImgArticle a = dao.findById(num).orElse(null);
		return new ImgArticleDto(a.getNum(), a.getWriter(), a.getWdate(), a.getTitle(), a.getContent(), 
				a.getFname(), null);
	}
	
	//전체검색
	public ArrayList<ImgArticleDto> getAll(){
		List<ImgArticle> l = dao.findAll();
		ArrayList<ImgArticleDto> list = new ArrayList<>();
		for(ImgArticle a: l) {
			list.add(new ImgArticleDto(a.getNum(), a.getWriter(), a.getWdate(), a.getTitle(), a.getContent(), 
				a.getFname(), null));
		}
		return list;
	}
	
	//pk로 삭제
	public void delArticle(int num) {
		dao.deleteById(num);
	}
}






