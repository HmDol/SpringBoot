package com.example.demo.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.member.Member2;

@Service
public class DataService {
	@Autowired
	private DataDao dao;
	
	public void changeCnt(int num) {
		dao.updateCnt(num);
	}
	
	
	public DataDto save(DataDto dto) {
		Data d = dao.save(new Data(dto.getNum(), dto.getTitle(), dto.getWriter(), dto.getWdate(), dto.getContent(),
				dto.getFname(), dto.getCnt()));
		return new DataDto(d.getNum(), d.getTitle(), d.getWriter(), d.getWdate(), d.getContent(),
				d.getFname(), d.getCnt(), null);
	}
	
	public DataDto getData(int num) {
		Data d = dao.findById(num).orElse(null);
		return new DataDto(d.getNum(), d.getTitle(), d.getWriter(), d.getWdate(), d.getContent(),
				d.getFname(), d.getCnt(), null);
	}
	
	public ArrayList<DataDto> getAll(){
		List<Data> list = dao.findAll();
		ArrayList<DataDto> list2 = new ArrayList<>();
		for(Data d : list) {
			list2.add(new DataDto(d.getNum(), d.getTitle(), d.getWriter(), d.getWdate(), d.getContent(), d.getFname(), d.getCnt(), null));
		}
		return list2;
	}
	
	public void Delete(int num) {
		dao.deleteById(num);
		
	}
	
	//작성자 이름으로 검색
	public ArrayList<DataDto> getByWriter(String writer){
		ArrayList<Data> list = dao.findByWriter(new Member2(writer,"","",""));
		ArrayList<DataDto> list2 = new ArrayList<>();
		for(Data d : list) {
			list2.add(new DataDto(d.getNum(), d.getTitle(), d.getWriter(), d.getWdate(), d.getContent(),
				d.getFname(), d.getCnt(), null));
		}
		return list2;
	}
	
	//
	public ArrayList<DataDto> getByTitle(String title){
		ArrayList<Data> list = dao.findByTitleLike(title);
		ArrayList<DataDto> list2 = new ArrayList<>();
		for(Data d : list) {
			list2.add(new DataDto(d.getNum(), d.getTitle(), d.getWriter(), d.getWdate(), d.getContent(),
				d.getFname(), d.getCnt(), null));
		}
		return list2;
	}
	
	
	
	
}
