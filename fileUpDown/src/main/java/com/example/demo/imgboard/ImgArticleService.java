package com.example.demo.imgboard;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImgArticleService {
	@Autowired
	private ImgArticleDao dao;
	
	public ImgArticleDto save(ImgArticleDto dto) {
		ImgArticle a = dao.save(new ImgArticle(dto.getNum(),dto.getWriter(),dto.getWdate(),dto.getTitle(),
				dto.getContent(),dto.getFname()));
		return new ImgArticleDto(a.getNum(), a.getWriter(),a.getWdate(),a.getTitle(),a.getContent(),a.getFname(),null);
	}
	
	public ImgArticleDto getArticle(int num) {
		ImgArticle a = dao.findById(num).orElse(null);
		return new ImgArticleDto(a.getNum(), a.getWriter(),a.getWdate(),a.getTitle(),a.getContent(),a.getFname(),null);	
	}
	
	public ArrayList<ImgArticleDto> getAll(){
		List<ImgArticle> list = dao.findAll();
		ArrayList<ImgArticleDto> list2 = new ArrayList<>();
		for(ImgArticle i : list) {
			list2.add(new ImgArticleDto(i.getNum(), i.getWriter(),i.getWdate(),i.getTitle(),i.getContent(),i.getFname(),null));
		}
		return list2;
	}
	
	public void Delete(int num) {
		dao.deleteById(num);
		
	}
	
}
