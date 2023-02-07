package testingil.unittesting.examples.demos.d02.mocking.manual;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import testingil.unittesting.examples.demos.d02.mocking.Car;
import testingil.unittesting.examples.demos.d02.mocking.Driver;

class Test_with_manual_mock{

	@Test
	void cannot_drive_a_running_car() {
		Car mockCar = new Mock_RunningCar();
		Driver driver = new Driver(mockCar);
		
		assertFalse(driver.canDrive());
		
	}

}
