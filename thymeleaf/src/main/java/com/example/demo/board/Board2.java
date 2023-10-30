package com.example.demo.board;

import java.util.Date;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.example.demo.member.Member2;

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
public class Board2 {
	@Id //pk지정
	@SequenceGenerator(name="seq_gen", sequenceName="seq_board2", allocationSize=1)//시퀀스 생성. 생성한 시퀀스 이름:seq_board2 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_board2")//자동으로 값 할당
	private int num;
	private Date wdate;
	
	@ManyToOne
	@JoinColumn(nullable=false)//member2(id)에 조인. 널 허용 안함
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Member2 writer;
	private String title;
	private String content;
	
	@PrePersist //insert문 실행전 자동 호출
	public void setDate() {
		wdate = new Date();
	}
}
