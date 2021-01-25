package com.sing3demons.products_backend.controller;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductRequest {

	private String name;
	private String desc;
	private MultipartFile image;
	private int price;
	private String category;
}
