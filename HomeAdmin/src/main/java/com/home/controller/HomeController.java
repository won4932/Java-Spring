package com.home.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.home.dto.SearchParam;
import com.home.network.Header;

@RestController
@RequestMapping("/home")
public class HomeController {

	@RequestMapping(method = RequestMethod.GET, path= "/getMethod")
	public String getRequest(SearchParam searchParam) {
		
		searchParam.getAccount();
		return "Hello Spring Boot";
	}
	
	@GetMapping("/header")
	public Header getHeader() {
		return Header.builder().resultCode("Ok").description("OKK").build();
	}
	
}
