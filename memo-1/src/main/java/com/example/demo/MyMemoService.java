package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MyMemoService {
	@Autowired
	private MyMemoDao dao;
	
	//추가 수정
	public MyMemoDto save(MyMemoDto dto) {
		MyMemo d = dao.save(new MyMemo(dto.getNum(),dto.getTitle(),dto.getContent()));
		return new MyMemoDto(d.getNum(),d.getTitle(),d.getContent());
	}
	
	//pk로 검색
	public MyMemoDto getMyMemo(int num) {
		MyMemo d = dao.findById(num).orElse(null);
		return new MyMemoDto(d.getNum(),d.getTitle(),d.getContent());
	}
	
	//전체 검색
	public ArrayList<MyMemoDto> getAll()	{
		List<MyMemo> list = dao.findAll();
		ArrayList<MyMemoDto> list2 = new ArrayList<>();
		for(MyMemo d : list) {
			list2.add(new MyMemoDto(d.getNum(),d.getTitle(),d.getContent()));
		}
		return list2;
	}
	//삭제
	public void delMyMemo(int num) {
		dao.deleteById(num);
	}
	
}
