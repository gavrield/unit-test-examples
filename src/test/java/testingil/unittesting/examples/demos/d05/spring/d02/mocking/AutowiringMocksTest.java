package testingil.unittesting.examples.demos.d05.spring.d02.mocking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = { ItemRepositoryConfiguration.class })
public class AutowiringMocksTest{

	@Autowired
	ItemRepository repository;

	@Autowired
	JdbcTemplate mockjdbc;
	
	@BeforeEach
	public void setup() {
		Mockito.reset(mockjdbc);
	}
	
	@Test
	@Disabled
	public void repository_is_created() {
		assertNotNull(repository);
		assertNotNull(repository.getTemplate());
		assertNotNull(repository.getTemplate().getDataSource());
	}
}
