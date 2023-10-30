package com.example.demo.data;

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
	@Query(value="update data set cnt=cnt+1 where num=:num",nativeQuery=true)
	void updateCnt(@Param("num")int num);
	ArrayList<Data> findByTitleLike(String title);
	ArrayList<Data> findByWriter(Member2 writer);
}
