package com.shihaichen.newsservices;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication
@EnableAutoConfiguration
public class SpringBootWebApplication extends SpringBootServletInitializer {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(SpringBootWebApplication.class, args);
	}

}
