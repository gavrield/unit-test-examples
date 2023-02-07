package testingil.unittesting.examples.demos.d05.spring.d05.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ItemConfiguration {
	@Bean
	public ItemController itemController() {
		return new ItemController();
	}
}