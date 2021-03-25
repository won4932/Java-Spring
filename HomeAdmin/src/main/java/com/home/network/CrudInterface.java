package com.home.network;

public interface CrudInterface<Req, Res> {
	
	Header<Res> create(Header<Req> reqeust);
	
	Header<Res> read(Long id);
	
	Header<Res> update(Header<Req> request);
	
	Header delete(Long id);
}
