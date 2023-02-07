package testingil.unittesting.examples.demos.d05.spring.d04.mockbean;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = { EmptyConfiguration.class })
public class MockBeanTest {

	@MockBean(answer = Answers.RETURNS_DEEP_STUBS)
	@Autowired
	ItemRepository repository;

	@Test
	public void repository_is_created() {
		assertNotNull(repository);
		assertNotNull(repository.getTemplate());
		assertNotNull(repository.getTemplate().getDataSource());
	}
}
