package com.example.demo.board;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.member.Member2;
@Repository
public interface BoardDao extends JpaRepository<Board2, Integer> {//interface가 interface를 상속할땐 extends
											  // 테이블 , pk키 타입
	//작성자로 검색
	ArrayList<Board2> findByWriter(Member2 writer);//파라메터 타입은 컬럼 타입과 동일해야함
	
	//제목으로 검색
	ArrayList<Board2> findByTitleLike(String title);

	

}

