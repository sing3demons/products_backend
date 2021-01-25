package com.sing3demons.products_backend.Exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@RestControllerAdvice
public class ExceptionAdvice {

	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String handlerProductNotFound(ProductNotFoundException ex) {
		return ex.getMessage();
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	String hadlerStorsgeException(StorageException ex) {
		return ex.getMessage();
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	String hadlerMaxUploadSize(MaxUploadSizeExceededException ex) {
		return "Maximum  upload size";
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	String hadlerValidation(ValidationException ex) {
		return ex.getMessage();
	}
}
