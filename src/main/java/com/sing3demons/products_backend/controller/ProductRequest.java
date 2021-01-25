package com.sing3demons.products_backend.controller;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductRequest {

	@NotEmpty
	@Size(min = 2, max = 100)
	private String name;
	private String desc;
	private MultipartFile image;
	private int price;
	private String category;
}
