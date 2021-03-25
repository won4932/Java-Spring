package com.home.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.dto.UserRepository;
import com.home.entity.User;
import com.home.network.ApiRequest;
import com.home.network.ApiResponse;
import com.home.network.CrudInterface;
import com.home.network.Header;

@Service
public class ApiLogicService implements CrudInterface<ApiRequest, ApiResponse>{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Header<ApiResponse> create(Header<ApiRequest> request) {
		
		// 1. request data
		ApiRequest apiRequest = request.getData();
		
		// 2. User 설정
		User user = User.builder()
				.account(apiRequest.getAccount())
				.password(apiRequest.getPassword())
				.status("REGISTERED")
				.phoneNumber(apiRequest.getPhoneNumber())
				.email(apiRequest.getEmail())
				.registeredAt(LocalDateTime.now())
				.build();
		
		User newUser = userRepository.save(user);
		
		// 3. 생성된 데이터 -> userApiResponse Return
		
		return response(newUser);
	}

	@Override
	public Header<ApiResponse> read(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Header<ApiResponse> update(Header<ApiRequest> request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Header delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Header<ApiResponse> response(User user) {
		// user -> apiResponse
		
		ApiResponse apiResponse = ApiResponse.builder()
				.id(user.getId())
				.account(user.getAccount())
				.password(user.getPassword())
				.email(user.getEmail())
				.phoneNumber(user.getPhoneNumber())
				.status(user.getStatus())
				.registeredAt(user.getRegisteredAt())
				.unregisteredAt(user.getUnregisteredAt())
				.build();
		
		return Header.DataOK(apiResponse);
	}
}
