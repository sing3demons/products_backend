package com.sing3demons.products_backend.Exeptions;

public class ProductNotFoundException extends RuntimeException {

	public ProductNotFoundException(Long id) {
		super("Could not find product " + id);
	}

}
