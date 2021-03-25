package com.home.admin;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.home.dto.AdminUserRepository;
import com.home.dto.UserRepository;
import com.home.entity.AdminUser;
import com.home.entity.User;

//@DataJpaTest  
//@EnableJpaRepositories("com.home.dto")
//@EntityScan("com.home.entity")
public class UserRepositoryTest extends HomeAdminApplicationTests{
	
	@Autowired
	//@MockBean
	private UserRepository userRepository;
	
	@Autowired
	private AdminUserRepository adminUserRepository;
	
	@Test
//	@Transactional
	public void create() {
		AdminUser user = new AdminUser();
//		System.out.println(user.getAccount());
		user.setAccount("Test03");
		user.setPassword("T3");
		user.setStatus("REGISTER");
//		user.setEmail("test03@gmail.com");
//		user.setPhoneNumber("010-1234-5678");
//		user.setRegisteredAt(LocalDateTime.now());
		user.setRole("Partner");
		
		AdminUser newUser = adminUserRepository.save(user);
		Assert.assertNotNull(newUser);
//		System.out.println(userRepository.save(user));
//		User createUser = userRepository.save(user);
//		System.out.println(userRepository.findAll());
//		//System.out.println(user.getAccount() + "    " + createUser.getAccount());
//		System.out.println("testUser : " + createUser);
	}
	
	@Test
	@Transactional
	public void read() {
//		Optional<User> user = userRepository.findById(2L);
//		
//		user.ifPresent(selectUser -> {
//			System.out.println("user : " + selectUser);
//		});
//		List<User> user = userRepository.findByPhoneNumberOrderByIdDesc("010-1111-2223");
		
//		List<User> user = userRepository.findByFirstPhoneNumberOrderByIdDesc("010-1111-2222");
//		처음에 findByFirstPhoneNumberOrderByIdDesc로 했는데 검색결과가 하나만 나와서 확인해봤던 findBy 네이밍이 맞지 않았음
		
//		System.out.println(user);
//		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Test @@@@@@@@@@@@@@@@@@@@@@@@@@22");
////		
//		for(User a : user) {
//			System.out.println("@@@@@@@@@@@@@@" + a.getAccount() + "  " + a.getCreatedBy());
//		}
//		
		User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");
		user.getOrderGroupList()
		.stream()
		.forEach(orderGroup -> {
			
			System.out.println("수령인 : " + orderGroup.getRevName());
			System.out.println("총금액 : " + orderGroup.getTotalQuantity());
			System.out.println("총수량 : " + orderGroup.getTotalPrice());
			
			System.out.println("@@@@@@@@@@@@@@@@@@@@주문상세@@@@@@@@@@@@@@@@@@@2");
			
			orderGroup.getOrderDetailList()
			.forEach(orderDetail -> {
				System.out.println("주문의 상태 : " + orderDetail.getStatus());
				System.out.println("예정 일자 : " + orderDetail.getArrivalDate());
				System.out.println("파트너사 연관관계 : " + orderDetail
						.getItem()
				.getPartner()
				.getCategory()
				.getTitle());
			});
		});
				
				
	}
	
	@Test
	public void update() {
		Optional<User> user = userRepository.findById(2L);
		
		user.ifPresent(selectUser -> {
			selectUser.setAccount("pppp");
			selectUser.setUpdatedAt(LocalDateTime.now());
			selectUser.setUpdatedBy("UpdateUser");
			
			userRepository.save(selectUser);
		});
		
	}
	
	@Test
	@Transactional
	public void delete() {
		Optional<User> user = userRepository.findById(2L);
		
		Assert.assertTrue(user.isPresent());
		
		user.ifPresent(selectUser -> {
			userRepository.delete(selectUser);
		});
		
		Optional<User> deleteUser = userRepository.findById(2L);
		
//		if(deleteUser.isPresent()) {
//			System.out.println("데이터 존재 : " + deleteUser.get());
//		}else {
//			System.out.println("데이터 삭제 데이터 없음");
//		}
		
		Assert.assertFalse(deleteUser.isPresent());
	}
}
