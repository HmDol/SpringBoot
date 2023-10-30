package com.example.demo.board;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.member.Member2;
@Repository
public interface BoardDao extends JpaRepository<Board2, Integer> {
	//작성자로검색
	ArrayList<Board2> findByWriter(Member2 writer);
	
	//제목으로검색
	ArrayList<Board2> findByTitleLike(String title);
}

