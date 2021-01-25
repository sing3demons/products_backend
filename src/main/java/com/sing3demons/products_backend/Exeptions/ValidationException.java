package com.sing3demons.products_backend.Exeptions;

public class ValidationException extends RuntimeException {
	public ValidationException(String message) {
		super(message);
	}
}
