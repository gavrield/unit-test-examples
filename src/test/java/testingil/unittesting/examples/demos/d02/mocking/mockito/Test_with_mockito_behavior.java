package testingil.unittesting.examples.demos.d02.mocking.mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import testingil.unittesting.examples.demos.d02.mocking.Car;
import testingil.unittesting.examples.demos.d02.mocking.Driver;

class Test_with_mockito_behavior {

	@Test
	void a_running_car() {
		Car mockCar = mock(Car.class);
		when(mockCar.isRunning()).thenReturn(true);
		
		Driver driver = new Driver(mockCar);
		
		assertFalse(driver.canDrive());
	}

}
