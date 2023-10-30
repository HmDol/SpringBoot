package com.example.demo.dataroom;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.member.Member2;

@Service
public class DataService {
	@Autowired
	private DataDao dao;

	// 추가, 수정
	public void saveData(DataDto dto) {
		Data d = dao.save(new Data(dto.getNum(), dto.getWriter(), dto.getWdate(), dto.getTitle(), dto.getContent(),
				dto.getFname(), dto.getCnt()));
	}

	// 전체검색
	public ArrayList<DataDto> getAll() {
		List<Data> l = dao.findAll();
		ArrayList<DataDto> list = new ArrayList<DataDto>();
		for (Data d : l) {
			list.add(new DataDto(d.getNum(), d.getWriter(), d.getWdate(), d.getTitle(), d.getContent(), d.getFname(),
					d.getCnt(), null));
		}
		return list;
	}

	// pk로 검색
	public DataDto getData(int num) {
		Data d = dao.findById(num).orElse(null);
		return new DataDto(d.getNum(), d.getWriter(), d.getWdate(), d.getTitle(), d.getContent(), d.getFname(),
				d.getCnt(), null);
	}

	// writer로 검색
	public ArrayList<DataDto> getByWriter(String writer) {
		List<Data> l = dao.findByWriter(new Member2(writer, "", "", ""));
		ArrayList<DataDto> list = new ArrayList<DataDto>();
		for (Data d : l) {
			list.add(new DataDto(d.getNum(), d.getWriter(), d.getWdate(), d.getTitle(), d.getContent(), d.getFname(),
					d.getCnt(), null));
		}
		return list;
	}

	// 제목으로 검색
	public ArrayList<DataDto> getByTitle(String title) {
		List<Data> l = dao.findByTitleLike("%" + title + "%");
		ArrayList<DataDto> list = new ArrayList<DataDto>();
		for (Data d : l) {
			list.add(new DataDto(d.getNum(), d.getWriter(), d.getWdate(), d.getTitle(), d.getContent(), d.getFname(),
					d.getCnt(), null));
		}
		return list;
	}

	// 확장자로 검색
	public ArrayList<DataDto> getByFname(String fname) {
		List<Data> l = dao.findByFnameLike("%" + fname);
		ArrayList<DataDto> list = new ArrayList<DataDto>();
		for (Data d : l) {
			list.add(new DataDto(d.getNum(), d.getWriter(), d.getWdate(), d.getTitle(), d.getContent(), d.getFname(),
					d.getCnt(), null));
		}
		return list;
	}
	
	//다운로드 카운트
	public void editCnt(int num) {
		dao.updateCnt(num);
	}
}








