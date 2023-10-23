package com.example.demo.product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.board.Board;

@Repository
public class ProductDao {
	@Autowired
	private JdbcTemplate temp;
	
	public class ProductMapper implements RowMapper<Product>{

		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			return new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5));
		}
		
	}
	
	public void insert(Product p) {
		String sql = "insert into product values(seq_product.nextval,?,?,?,?) ";
		temp.update(sql,new Object[] {p.getName(),p.getPrice(),p.getAmount(),p.getSeller()});
	}
	
	public Product select(int num ) {
		String sql = "select * from Product where num=?";
		Product p = temp.queryForObject(sql, new ProductMapper(),num);
		return p;
	}
	
	public ArrayList<Product> selectAll() {
		String sql = "select * from product";
		ArrayList<Product> list = (ArrayList<Product>) temp.query(sql, new ProductMapper());
		return list;
	}
	
	public ArrayList<Product> selectByname(String name){
		String sql = "select * from product where name like ?";
		ArrayList<Product> list = (ArrayList<Product>) temp.query(sql, new ProductMapper(),"%"+name+"%");
		return list;
	}
	public ArrayList<Product> selectByprice(int price1, int price2){
		String sql = "select * from product where price between ? and ?";
		ArrayList<Product> list = (ArrayList<Product>) temp.query(sql, new ProductMapper(),price1, price2);
		return list;
	}
	public ArrayList<Product> selectByseller(String seller){
		String sql = "select * from product where seller = ?";
		ArrayList<Product> list = (ArrayList<Product>) temp.query(sql, new ProductMapper(),seller);
		return list;
	}
	
	public void update(Product p) {
		String sql ="update product set pr=?, amount=? where num=?";
		temp.update(sql,new Object[] {p.getName(),p.getAmount(),p.getNum()});
	}
	
	public void delete(int num) {
		String sql = "delete product where num=?";
		temp.update(sql,num);
	}
}
