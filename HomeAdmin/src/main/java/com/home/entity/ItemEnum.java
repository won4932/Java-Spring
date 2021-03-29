package com.home.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ItemEnum {
	
	REGISTERED(0, "등록", "상품 등록상테"), 
	UNREGISTERED(1, "해지", "상품 해지상태"),
	WAITING(2, "검수(대기)", "상품 겸수 상태");
	
	private Integer id;
	private String title;
	private String description;
}
