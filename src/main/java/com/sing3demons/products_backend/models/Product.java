package com.sing3demons.products_backend.models;

public class Product {
	private long id;
	private String name;
	private String desc;
	private String image;
	private int price;
	private String category;

	public Product(long id, String name, String desc, String image, int price, String category) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.image = image;
		this.price = price;
		this.category = category;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDesc() {
		return desc;
	}

	public String getImage() {
		return image;
	}

	public int getPrice() {
		return price;
	}

	public String getCategory() {
		return category;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
