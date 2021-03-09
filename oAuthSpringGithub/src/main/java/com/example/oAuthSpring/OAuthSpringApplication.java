package com.example.oAuthSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@RestController
//@EnableOAuth2Sso
public class OAuthSpringApplication {

//	@GetMapping("/")
//	public String welcome(Principal principal) {
//		return " Hello from " + principal.getName();
//	}

	public static void main(String[] args) {
		SpringApplication.run(OAuthSpringApplication.class, args);
	}

}
