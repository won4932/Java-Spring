package com.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.home.network.ApiRequest;
import com.home.network.ApiResponse;
import com.home.network.CrudInterface;
import com.home.network.Header;
import com.home.service.BaseService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public abstract class CrudController<Req, Res, Entity> implements CrudInterface<Req, Res>{
	
//	protected CrudInterface<Req, Res> baseService;
	@Autowired(required = false)
	protected BaseService<Req, Res, Entity> baseService;
	
	@Override
	@PostMapping("/create")
	public Header<Res> create(@RequestBody Header<Req> request) {
		log.info("{}", request);
		return baseService.create(request);
	}

	@Override
	@GetMapping("{id}")
	public Header<Res> read(@PathVariable(name = "id") Long id) {
		log.info("{}", id);
		// TODO Auto-generated method stub
		return baseService.read(id);
	}

	@Override
	@PutMapping("")
	public Header<Res> update(@RequestBody Header<Req> request) {
		// TODO Auto-generated method stub
		return baseService.update(request);
	}

	@Override
	@DeleteMapping("{id}")
	public Header delete(@PathVariable Long id) {
		// TODO Auto-generated method stub
		return baseService.delete(id);
	}
}
