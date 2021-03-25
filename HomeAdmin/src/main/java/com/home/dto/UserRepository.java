package com.home.dto;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.home.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	List<User> findByPhoneNumberOrderByIdDesc(String phoneNumber);
	
	User findFirstByPhoneNumberOrderByIdDesc(String phoneNumber);
}
