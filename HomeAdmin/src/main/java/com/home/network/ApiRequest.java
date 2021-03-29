package com.home.network;

import java.time.LocalDateTime;

import com.home.entity.UserEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiRequest {
	
	private Long id;
	
	private String account;
	
	private String password;
	
	private UserEnum status;
	
	private String email;
	
	private String phoneNumber;

	private LocalDateTime RegisteredAt;

	private LocalDateTime UnregisteredAt;
}
