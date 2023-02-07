package testingil.unittesting.examples.demos.d05.spring.d06.clients;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ItemClientConfiguration {
	
	@Bean
	public ItemClient client() {
		return new ItemClient();
	}
	
	@Bean 
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}	
	
}
