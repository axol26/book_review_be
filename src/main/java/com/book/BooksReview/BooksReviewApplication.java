package com.book.BooksReview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class BooksReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksReviewApplication.class, args);
	}

	@GetMapping("/root")
	public String apiRoot() {
		return "Hello World";
	}

}
