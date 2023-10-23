package com.example.demo.board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {
	
	@Autowired
	private JdbcTemplate temp;
	
	//resultMap : 검색 결과행을 vo에 맴핑
	public class BoardMapper implements RowMapper<Board>{
		
		
		//파람1 : 검색결과 , 파람2 : 현재 처리할 줄 번호
		@Override
		public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			return new Board(rs.getInt(1),rs.getDate(2),rs.getString(3),rs.getString(4),rs.getString(5));
		}
	}
	
	public void insert(Board b) {
		String sql = "insert into board values(seq_board.nextval,sysdate,?,?,?) ";
		temp.update(sql,new Object[] {b.getWriter(),b.getTitle(),b.getContent()});
		
	}
	
	public Board select(int num) { //pk기준 검색. 1줄 검색
		String sql = "select * from board where num=?";
		Board b = null;
		try {
			b = temp.queryForObject(sql, new BoardMapper(),num);
		}catch (Exception e){
			System.out.println("not found");
		}
		return b;
	}
	
	public ArrayList<Board> selectAll(){
		String sql = "select * from board";
		ArrayList<Board> list = (ArrayList<Board>) temp.query(sql, new BoardMapper()); 
		return list;
	}
	public void update(Board b) {
		String sql = "update board set title=?, content=?, where num=?";
		temp.update(sql,new Object[] {b.getTitle(),b.getContent(),b.getNum()});
	}
	public void delete(int num) {
		String sql = "delete board where num=?";
		temp.update(sql,num);
	}
}
