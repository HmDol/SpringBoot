package com.example.demo.diary;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiaryService {
	@Autowired
	private DiaryDao dao;
	
	//추가,수정
	public DiaryDto save(DiaryDto dto) {
		Diary d = dao.save(new Diary(dto.getNum(),dto.getWdate(),dto.getTitle(),dto.getContent(),dto.getFname()));
		return new DiaryDto(d.getNum(),d.getWdate(),d.getTitle(),d.getContent(),d.getFname(),null);
	}
	
	//pk로 검색
	public DiaryDto getDiary(int num) {
		Diary d = dao.findById(num).orElse(null);
		return new DiaryDto(d.getNum(),d.getWdate(),d.getTitle(),d.getContent(),d.getFname(),null);
	}
	
	//전체 검색
	public ArrayList<DiaryDto> getAll()	{
		List<Diary> list = dao.findAll();
		ArrayList<DiaryDto> list2 = new ArrayList<>();
		for(Diary d : list) {
			list2.add(new DiaryDto(d.getNum(),d.getWdate(),d.getTitle(),d.getContent(),d.getFname(),null));
		}
		return list2;
	}
	//삭제
	public void delDiary(int num) {
		dao.deleteById(num);
	}
}
