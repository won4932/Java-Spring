package com.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.network.ApiRequest;
import com.home.network.ApiResponse;
import com.home.network.CrudInterface;
import com.home.network.Header;
import com.home.service.ApiLogicService;

@RestController
@RequestMapping("/home/user")
public class UserController implements CrudInterface<ApiRequest, ApiResponse> {

	@Autowired
	private ApiLogicService apiLogicService;
	
	@Override
	@PostMapping("/create")
	public Header<ApiResponse> create(@RequestBody Header<ApiRequest> request) {
		// TODO Auto-generated method stub
		return apiLogicService.create(request);
	}

	@Override
	@GetMapping("{id}")
	public Header<ApiResponse> read(@PathVariable(name = "id") Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@PutMapping("")
	public Header<ApiResponse> update(@RequestBody Header<ApiRequest> request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@DeleteMapping("{id}")
	public Header delete(@PathVariable Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
