package com.example.demo.test;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity  //jpa table
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book2 {
	@Id //pk지정
	@SequenceGenerator(name="seq_gen", sequenceName="seq_book2", allocationSize=1)//시퀀스 생성. 생성한 시퀀스 이름:seq_board2 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_book2")
	private int num;
	private String writer;
	private Date wdate;
	private String content;
	
	@PrePersist //insert문 실행전 자동 호출
	public void setDate() {
		wdate = new Date();
	}
}
