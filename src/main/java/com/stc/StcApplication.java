package com.stc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@EnableTransactionManagement
@SpringBootApplication
public class StcApplication {

	public static void main(String[] args) {
		SpringApplication.run(StcApplication.class, args);
	}
	
	

}
