package com.example.demo.guestbook;

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
public class GuestBook2 {
	@Id // pk지정
	@SequenceGenerator(name="seq_gen",sequenceName="seq_guestbook2", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_guestbook2")
	private int num;
	
	@ManyToOne // 외래키 관계 설정
	@JoinColumn(nullable=false)//member2(id)에 조인. 널 허용 안함
	@OnDelete(action = OnDeleteAction.CASCADE) // on Delete cascade 설정
	private Member2 writer;
	private Date wdate;
	private String content;
	
	@PrePersist
	public void setDate() {
		wdate = new Date(); // 현재날짜 생성 후 wadate에 자동 삽입
	}
}
