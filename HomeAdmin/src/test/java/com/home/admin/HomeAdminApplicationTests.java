package com.home.admin;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import com.home.dto.CategoryRepository;
import com.home.entity.Category;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableJpaRepositories("com.home.dto")
@EntityScan("com.home.entity")
//@EnableJpaRepositories("com.home.dto.UserRepository")
class HomeAdminApplicationTests {
	
	@Autowired
	private CategoryRepository categoryRepository;
//	@Test
//	void contextLoads() {
//	}
	
	@Test
	@Transactional
	public void create() {
		String type = "COMPUTER";
		String title = "컴퓨터";
		LocalDateTime createdAt = LocalDateTime.now();
		String createdBy = "AdminServer";
		
		Category category = new Category();
		category.setType(type);
		category.setTitle(title);
		category.setCreatedAt(createdAt);
		category.setCreatedBy(createdBy);
		
		Category newCategory = categoryRepository.save(category);
		
		Assert.assertNotNull(newCategory);
		Assert.assertEquals(newCategory.getType(), type);
		Assert.assertEquals(newCategory.getTitle(), title);
	}
	
	@Test
	public void read() {
		Optional<Category> optional = categoryRepository.findByType("COMPUTER");
		
		optional.ifPresent(c -> {
			System.out.println(c.getId());
			System.out.println(c.getType());
			System.out.println(c.getTitle());
		});
	}

}
