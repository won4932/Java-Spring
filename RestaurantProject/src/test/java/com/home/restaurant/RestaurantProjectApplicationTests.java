package com.home.restaurant;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.home.dto.Restaurant;

@SpringBootTest
class RestaurantProjectApplicationTests {

	@Test
	void contextLoads() {
		Restaurant restau = new Restaurant();
		
		assertThat(restau.getName(), is("Bpb zip"));
	}
	

}
