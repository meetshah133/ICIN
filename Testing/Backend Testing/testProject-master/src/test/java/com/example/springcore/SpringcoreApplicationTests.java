package com.example.springcore;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.icin.bank.BankApplication;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes=BankApplication.class)
public class SpringcoreApplicationTests {

	@Test
	void contextLoads() {
	}

}
