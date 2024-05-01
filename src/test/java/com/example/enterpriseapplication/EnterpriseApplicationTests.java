package com.example.enterpriseapplication;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = EnterpriseApplication.class)
class EnterpriseApplicationTests {

	@Test
	void contextLoads() {
		Assertions.assertTrue(true);
	}

}
