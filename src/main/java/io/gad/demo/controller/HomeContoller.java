package io.gad.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeContoller {

	@GetMapping("/")
	public String index()
	{
		return "Hello";
	}
	
}
