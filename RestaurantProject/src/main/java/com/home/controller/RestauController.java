package com.home.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.dto.Restaurant;

@RestController
public class RestauController {

	@GetMapping("/restau")
	public List<Restaurant> list() {
		List<Restaurant> list = new ArrayList<>();
		
		Restaurant restau = new Restaurant("Bob zip");
		
		list.add(restau);
		
		return list;
	}
	
	@GetMapping("/")
	public String home() {
		return "Heool, world!";
	}
}
