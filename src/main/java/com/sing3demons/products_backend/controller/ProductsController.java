package com.sing3demons.products_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsController {

	// --> GET http://localhost:8080 ,http://localhost:8080/?name=sing
	@GetMapping("")
	public String findAll(@RequestParam(required = false, defaultValue = "") String name) {
		return "Hello" + " " + name;
	}

	// --> GET /:id
	@GetMapping("{id}")
	public String findOne(@PathVariable int id) {
		return "Hello " + id;
	}

	// --> GET http://localhost:8080/say?firstName=kpsing
	@GetMapping("/say")
	public String find(@RequestParam("firstName") String name) {
		return "Hello " + name;
	}
}
