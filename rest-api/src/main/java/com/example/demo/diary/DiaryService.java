package com.example.demo.diary;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiaryService {
	@Autowired
	private DiaryDao dao;
	
	public DiaryDto save(DiaryDto dto) {
		Diary entity = dao.save(new Diary(dto.getNum(), dto.getWdate(), dto.getTitle(), dto.getContent(), dto.getFname()));
		return new DiaryDto(entity.getNum(), entity.getWdate(), entity.getTitle(), entity.getContent(), entity.getFname(), null);
	}
	
	public DiaryDto get(int num) {
		Diary entity = dao.findById(num).orElse(null);
		return new DiaryDto(entity.getNum(), entity.getWdate(), entity.getTitle(), entity.getContent(), entity.getFname(), null);
	}
	
	public ArrayList<DiaryDto> getAll(){
		List<Diary> l = dao.findAll();
		ArrayList<DiaryDto> list = new ArrayList<>();
		for(Diary entity:l) {
			list.add(new DiaryDto(entity.getNum(), entity.getWdate(), entity.getTitle(), entity.getContent(), entity.getFname(), null));
		}
		return list;
	}
	
	public void del(int num) {
		dao.deleteById(num);
	}
}
