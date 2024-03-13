package com.mk.pizzaexpress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
public class PizzaexpressApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaexpressApplication.class, args);
	}

}
