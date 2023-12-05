package com.example.demo;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class MyMemo {
	@Id // pk지정
	@SequenceGenerator(name = "seq_gen", sequenceName = "seq_memo", allocationSize = 1) 																						
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_memo")
	private int num;
	private String title;
	private String content;
	
}
