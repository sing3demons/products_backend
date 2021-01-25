package com.sing3demons.products_backend.services;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.sing3demons.products_backend.Exeptions.StorageException;

@Service
public class Storage implements StorageSevice {

	@Value("${app.upload.path:images}")
	private String path;

	private Path rootLocation;

	@Override
	public void init() {
		this.rootLocation = Paths.get(path);
		try {
			Files.createDirectories(rootLocation);// เช็คpathว่ามีหรือไม่ ถ้าไม่มีให้สร้าง
		} catch (IOException ex) {
			throw new StorageException("Could not init storage" + ex.getMessage());
		}

	}

	@Override
	public String storage(MultipartFile file) {
		if (file == null || file.isEmpty()) {
			return null;
		}
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			if (fileName.contains("..")) {
				throw new StorageException("patn outside cerrent directory");
			}
			fileName = UUID.randomUUID() + "." + fileName.substring(fileName.lastIndexOf(".") + 1);

			try (InputStream inputStream = file.getInputStream()) {
				Files.copy(inputStream, this.rootLocation.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
				return fileName;
			}
		} catch (IOException ex) {
			throw new StorageException("faild to store file" + ex.getMessage());
		}
	}

}
