package com.example.demo.member;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper //mybatis의 매퍼파일. mybatis는 매퍼 인터페이스를 구현해 줌
public interface MemberDao {
	@Insert("insert into member values(#{id}, #{pwd}, #{name}, #{email}, 1)")
	void insert(Member m);
	
	@Select("select * from member where id=#{id}")
	Member select(@Param("id") String id);
	
	@Update("update member set pwd=#{pwd}, name=#{name} where id=#{id}")
	void update(Member m);
	
	@Delete("delete from member where id=#{id}")
	void delete(@Param("id") String id);
}
