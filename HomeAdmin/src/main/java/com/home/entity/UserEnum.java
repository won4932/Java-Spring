package com.home.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserEnum {
	
	REGISTERED(0, "등록상테", "시용자 등록상테"), 
	UNREGISTERED(1, "해지", "사용자 해지상태");
	
	private Integer id;
	private String title;
	private String description;
}
