package com.example.demo.board;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface BoardDao {
	@Insert("insert into board values(seq_board.nextval, sysdate, #{writer}, #{title}, #{content})")
	public void insert(Board b);
	
	@Select("select * from board where num=#{num}")
	public Board select(@Param("num") int num);
	
	@Select("select * from board order by num desc")
	public ArrayList<Board> selectAll();
	
	@Update("update board set title=#{title}, content=#{content} where num=#{num}")
	public void update(Board b);

	@Delete("delete board where num=#{num}")
	public void delete(@Param("num") int num);
}
