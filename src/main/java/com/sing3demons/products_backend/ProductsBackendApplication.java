package com.sing3demons.products_backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sing3demons.products_backend.services.StorageSevice;

@SpringBootApplication
public class ProductsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsBackendApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageSevice storageSevice) {
		return args -> storageSevice.init();
	}

}
