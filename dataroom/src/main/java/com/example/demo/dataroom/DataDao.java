package com.example.demo.dataroom;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.member.Member2;
@Repository
public interface DataDao extends JpaRepository<Data, Integer> {
	@Transactional
	@Modifying
	@Query(value="update data set cnt=cnt+1 where num=:num", nativeQuery=true)
	void updateCnt(@Param("num") int num);
	ArrayList<Data> findByWriter(Member2 writer);//작성자로 검색
	ArrayList<Data> findByTitleLike(String title);//제목으로 검색
	ArrayList<Data> findByFnameLike(String fname);//파일명(확장자)으로 검색
}
