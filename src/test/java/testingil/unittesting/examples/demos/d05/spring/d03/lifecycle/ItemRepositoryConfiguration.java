package testingil.unittesting.examples.demos.d05.spring.d03.lifecycle;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class ItemRepositoryConfiguration {
	
	@Bean
	public ItemRepository itemRepository() {
		return Mockito.mock((ItemRepository.class));
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		return Mockito.mock(JdbcTemplate.class);
	}
}
