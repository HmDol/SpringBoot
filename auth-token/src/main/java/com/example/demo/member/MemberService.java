package com.example.demo.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	@Autowired
	private MemberDao dao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	//추가, 수정
	//jpa의 save(entity): 한줄추가, 전체컬럼수정, 방금 추가/수정한 객체를 반환
	public MemberDto save(MemberDto dto) {
		Member2 m2 = dao.save(new Member2(dto.getId(), passwordEncoder.encode(dto.getPwd()), dto.getName(), dto.getEmail()));
//		Member2 m2 = dao.save(new Member2(dto.getId(), dto.getPwd(), dto.getName(), dto.getEmail()));
		return new MemberDto(m2.getId(), m2.getPwd(), m2.getName(), m2.getEmail());
	}
	
	public MemberDto getMember(String id) {
		//findById(값): pk컬럼 값으로 찾음. 없으면 예외발생. orElse(null)를 붙이면 없으면 null반환
		Member2 m = dao.findById(id).orElse(null);
		if(m==null) {
			return null;
		}
		return new MemberDto(m.getId(), m.getPwd(), m.getName(), m.getEmail());
	}
	
	public void delMember(String id) {
		//deleteById(값): pk 기준으로 삭제
		dao.deleteById(id);
	}
}
