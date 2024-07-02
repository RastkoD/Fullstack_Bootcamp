package com.iktpreobuka.testing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iktpreobuka.testing.controllers.HomeController;

@SpringBootTest
class TestingProjectApplicationTests {
	
	@Autowired
	HomeController homeController;

	@Test
	void contextLoads() throws Exception {
		assertThat(homeController).isNotNull();
		//assertThat(homeController).isNull(); // Fail
	}

}
