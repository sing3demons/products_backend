package com.sing3demons.products_backend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sing3demons.products_backend.Exeptions.ProductNotFoundException;
import com.sing3demons.products_backend.Exeptions.ValidationException;
import com.sing3demons.products_backend.models.Product;
import com.sing3demons.products_backend.services.StorageSevice;

@RestController
@RequestMapping("api/v1/products")
public class ProductsController {

	private final AtomicLong counter = new AtomicLong();
	private List<Product> products = new ArrayList<>();
	private StorageSevice storageSevice;

	public ProductsController(StorageSevice storageSevice) {
		this.storageSevice = storageSevice;
	}

	// --> GET http://localhost:8080 ,http://localhost:8080/?name=sing
	@GetMapping("")
	public List<Product> findAll(@RequestParam(required = false, defaultValue = "") String name) {
		return products;
	}

	// --> GET /:id
	@GetMapping("{id}")
	public Product findOne(@PathVariable long id) {
		return products.stream().filter(result -> result.getId() == id).findFirst()
				.orElseThrow(() -> new ProductNotFoundException(id));
	}

	// --> GET http://localhost:8080/say?firstName=kpsing
	@GetMapping("/say")
	public String find(@RequestParam("firstName") String name) {
		return "Hello " + name;
	}

	// POST
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping()
	public Product creacte(@Valid ProductRequest productRequest, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			bindingResult.getFieldErrors().stream().forEach(fieldError -> {
				throw new ValidationException(fieldError.getField() + ": " + fieldError.getDefaultMessage());
			});
		}
		String fileName = storageSevice.storage(productRequest.getImage());

		Product data = new Product(counter.incrementAndGet(), productRequest.getName(), productRequest.getDesc(),
				fileName, productRequest.getPrice(), productRequest.getCategory());

		products.add(data);
		return data;
	}

	// Put --> update /:id
	@PutMapping("{id}")
	public void EditProduct(@RequestBody Product product, @PathVariable long id) {
//		Product data;
		products.stream().filter(result -> result.getId() == id).findFirst().ifPresentOrElse(result -> {
			result.setName(product.getName());
			result.setDesc(product.getDesc());
			result.setImage(product.getImage());
			result.setPrice(product.getPrice());
			result.setCategory(product.getCategory());
//			data = result;
		}, () -> {
			throw new ProductNotFoundException(id);
		});

	}

	// --> GET /:id
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("{id}")
	public void delete(@PathVariable long id) {
		products.stream().filter(result -> result.getId() == id).findFirst()
				.ifPresentOrElse(result -> products.remove(result), () -> {
					throw new ProductNotFoundException(id);
				});
	}

}
