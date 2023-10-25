package com.example.demo.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	@Autowired
	private MemberDao dao;

	public void join(Member m) {
		dao.insert(m);
	}

	public Member getMember(String id) {
		return dao.select(id);
	}
	
	public void editMember(Member m) {
		dao.update(m);
	}
	
	public void delMember(String id) {
		dao.delete(id);
	}
	
}






