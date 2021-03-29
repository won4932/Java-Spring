package com.home.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.home.network.CrudInterface;
import com.home.network.Header;

@Component
public abstract class BaseService<Req, Res, Entity> implements CrudInterface<Req, Res>{

	@Autowired(required = true)
	protected JpaRepository<Entity, Long> baseRepository;

}
