package com.test;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EchallanApplicationTests {
	
	Calculator c = new Calculator();

	@Test
	void contextLoads() {
	}
	
	@Test
	void testSum() {
		
		//expected result
		int expectedResult = 24;
		
		//actual result
		int actualResult = c.sum(12, 4, 8);
		
		assertThat(actualResult).isEqualTo(expectedResult);
	}
	

}
