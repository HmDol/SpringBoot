package com.example.demo.product;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.example.demo.member.Member2;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product2 {
	@Id //pk지정
	@SequenceGenerator(name="seq_gen", sequenceName="seq_prod2", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_prod2")
	private int num;//pk, 번호 자동 생성
	private String name;
	private int price;
	private int amount;
	
	@JoinColumn(nullable=false)
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Member2 seller; //fk. member2(id). ManyToOne관계
}
