package com.sing3demons.products_backend.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
	private long id;
	private String name;
	private String desc;
	private String image;
	private int price;
	private String category;
}
