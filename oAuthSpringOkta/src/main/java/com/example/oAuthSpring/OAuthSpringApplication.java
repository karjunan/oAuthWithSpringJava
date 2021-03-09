package com.example.oAuthSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;

@SpringBootApplication
@RestController
@EnableOAuth2Sso
public class OAuthSpringApplication {

	@GetMapping("/")
	public String echoTheUsersEmailAddress(Principal principal) {
		return "Hey there! Your email address is: " + principal.getName();
	}

	public static void main(String[] args) {
		SpringApplication.run(OAuthSpringApplication.class, args);
	}


}
