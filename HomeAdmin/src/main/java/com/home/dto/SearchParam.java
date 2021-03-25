package com.home.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class SearchParam {
	
	private String account;
	private String email;
	private int page;
	
	
}
