package com.stock;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StockManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockManagementSystemApplication.class, args);
	  System.out.println("Stock Management System Application is Start Running...");
	}
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
