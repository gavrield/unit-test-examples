package testingil.unittesting.examples.demos.d05.spring.d01.configuration;



import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = { ItemRepositoryConfiguration.class })
public class AutowiringUsingConfigurationTest{

	@Autowired
	ItemRepository repository;

	//@Test
	//@Disabled
	public void repository_is_created() {
		Assertions.assertNotNull(repository);
		Assertions.assertNotNull(repository.getTemplate());
	}
}
