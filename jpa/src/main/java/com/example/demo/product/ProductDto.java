package com.example.demo.product;

import com.example.demo.member.Member2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDto {
	private int num;//pk, 번호 자동 생성
	private String name;
	private int price;
	private int amount;
	private Member2 seller;
}
