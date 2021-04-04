package com.home.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@ComponentScan("com.home")
@EnableJpaRepositories("com.home.dto")
@EntityScan({"com.home.entity", "com.home.front"})
public class HomeAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeAdminApplication.class, args);
	}

}
