package io.gad.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		System.out.println("Run from Main");
		SpringApplication.run(Main.class, args);
	}

}
