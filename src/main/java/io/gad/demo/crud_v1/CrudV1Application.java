package io.gad.demo.crud_v1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("io.gad.demo") 
public class CrudV1Application {

	public static void main(String[] args) {
		System.out.println("Run From CrudV1Appplication.java");
		SpringApplication.run(CrudV1Application.class, args);
	}

}
