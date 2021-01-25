package com.sing3demons.products_backend.services;

import org.springframework.web.multipart.MultipartFile;

public interface StorageSevice {
	void init();

	String storage(MultipartFile file);

}
