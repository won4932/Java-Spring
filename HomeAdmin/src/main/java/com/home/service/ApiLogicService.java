package com.home.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.dto.UserRepository;
import com.home.entity.User;
import com.home.entity.UserEnum;
import com.home.network.ApiRequest;
import com.home.network.ApiResponse;
import com.home.network.CrudInterface;
import com.home.network.Header;

@Service
//public class ApiLogicService implements CrudInterface<ApiRequest, ApiResponse>{
public class ApiLogicService extends BaseService<ApiRequest, ApiResponse, User>{

//	@Autowired
//	private UserRepository userRepository;
	
	@Override
	public Header<ApiResponse> create(Header<ApiRequest> request) {
		
		// 1. request data
		ApiRequest apiRequest = request.getData();
		
		// 2. User 설정
		User user = User.builder()
				.account(apiRequest.getAccount())
				.password(apiRequest.getPassword())
				.status(UserEnum.REGISTERED)
				.phoneNumber(apiRequest.getPhoneNumber())
				.email(apiRequest.getEmail())
				.registeredAt(LocalDateTime.now())
				.build();
		
//		User newUser = userRepository.save(user);
		User newUser = baseRepository.save(user);
		// 3. 생성된 데이터 -> userApiResponse Return
		
		return response(newUser);
	}

	@Override
	public Header<ApiResponse> read(Long id) {
		// id -> repository getOne, getById
//		Optional<User> optional = userRepository.findById(id);
//		
//		return optional
//			.map(user -> response(user))
//			.orElseGet(() -> Header.ERROR("데이터 없음"));
		
//		return userRepository.findById(id)
		return baseRepository.findById(id)
		.map(user -> response(user))
		.orElseGet(() -> Header.ERROR("데이터 없음"));
	}

	@Override
	public Header<ApiResponse> update(Header<ApiRequest> request) {
		// 1. data
		ApiRequest apiRequest = request.getData();
		
		// 2. id -> user
//		Optional<User> optional = userRepository.findById(apiRequest.getId());
		Optional<User> optional = baseRepository.findById(apiRequest.getId());
		return optional.map(user -> {
				// 3. update
				user.setAccount(apiRequest.getAccount())
				.setPassword(apiRequest.getPassword())
				.setStatus(apiRequest.getStatus())
				.setPhoneNumber(apiRequest.getPhoneNumber())
				.setEmail(apiRequest.getEmail())
				.setRegisteredAt(apiRequest.getRegisteredAt())
				.setUnregisteredAt(apiRequest.getUnregisteredAt());
				
				return user;
				})
//				.map(user -> userRepository.save(user)) // update
				.map(user -> baseRepository.save(user))
				.map(updateUser -> response(updateUser)) // userApiResonse
				.orElseGet(() -> Header.ERROR("데이터 없음"));
		
		// 4. userApiResponse
	}

	@Override
	public Header delete(Long id) {
//		Optional<User> optional = userRepository.findById(id);
//		
//		return optional.map(user -> {
//			userRepository.delete(user);
Optional<User> optional = baseRepository.findById(id);
		
		return optional.map(user -> {
			baseRepository.delete(user);
			
			return Header.OK();
		})
		.orElseGet(() -> Header.ERROR("데이터 없음!!"));
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
