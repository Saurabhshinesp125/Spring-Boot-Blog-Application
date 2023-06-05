package in.saurabh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition (
info = @Info(
title  = "BLOG_APP",
version = "1.0.0",
description = "This project is only for learning!",
termsOfService = "Docodenow",
contact = @Contact(
name = "Mr Saurabh",
email = "Saurabh@gmail.com"
),
license = @License (
name = "licence",
url = "http://localhost:8080"
)
)
)
public class SpringBootBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBlogApplication.class, args);
	}

}
