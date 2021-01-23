package com.sing3demons.products_backend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sing3demons.products_backend.models.Product;

@RestController
@RequestMapping("api/v1/products")
public class ProductsController {

	private final AtomicLong counter = new AtomicLong();
	private List<Product> products = new ArrayList<>();

	// --> GET http://localhost:8080 ,http://localhost:8080/?name=sing
	@GetMapping("")
	public List<Product> findAll(@RequestParam(required = false, defaultValue = "") String name) {
		return products;
	}

	// --> GET /:id
	@GetMapping("{id}")
	public Product findOne(@PathVariable int id) {
		return products.stream().filter(result -> result.getId() == id).findFirst().orElseThrow();
	}

	// --> GET http://localhost:8080/say?firstName=kpsing
	@GetMapping("/say")
	public String find(@RequestParam("firstName") String name) {
		return "Hello " + name;
	}

	@PostMapping()
	public Product creacte(@RequestBody Product product) {
		Product data = new Product(counter.incrementAndGet(), product.getName(), product.getDesc(), product.getImage(),
				product.getPrice(), product.getCategory());

		products.add(data);
		return data;
	}
}
