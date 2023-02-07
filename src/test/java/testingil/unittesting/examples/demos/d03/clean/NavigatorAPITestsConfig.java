package testingil.unittesting.examples.demos.d03.clean;

import static org.mockito.Mockito.mock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import testingil.unittesting.examples.demos.d03.clean.DistanceProvider;
import testingil.unittesting.examples.demos.d03.clean.NavigationController;
import testingil.unittesting.examples.demos.d03.clean.Navigator;

@Configuration
public class NavigatorAPITestsConfig {
	
	@Bean
	public Navigator navigator() {
		return new Navigator(distanceProvider());
	}
	
	@Bean
	public NavigationController navigationController() {
		return new NavigationController();
	}
	
	@Bean
	public DistanceProvider distanceProvider() {
		return mock(DistanceProvider.class);
	}
}
