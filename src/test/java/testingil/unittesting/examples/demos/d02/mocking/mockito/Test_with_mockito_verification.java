package testingil.unittesting.examples.demos.d02.mocking.mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import testingil.unittesting.examples.demos.d02.mocking.ACMode;
import testingil.unittesting.examples.demos.d02.mocking.AirCondition;
import testingil.unittesting.examples.demos.d02.mocking.Car;
import testingil.unittesting.examples.demos.d02.mocking.Driver;

class Test_with_mockito_verification{

	@Test
	void AC_is_set_before_we_drive() {
		Car mockCar = mock(Car.class);
		Driver driver = new Driver(mockCar);
		driver.drive();
		
		Mockito.verify(mockCar,atLeast(1)).
			setAC(any(AirCondition.class));
	}

	
	@Test
	void AC_is_set_on_before_we_drive() {
		Car mockCar = mock(Car.class);
		Driver driver = new Driver(mockCar);
		ArgumentCaptor<AirCondition> acCaptor = 
				ArgumentCaptor.forClass(AirCondition.class);
		

		driver.drive();
		
		Mockito.verify(mockCar).setAC(acCaptor.capture());
		
		AirCondition ac = acCaptor.getValue();
		assertEquals (ACMode.On, ac.getMode());
	}

}
