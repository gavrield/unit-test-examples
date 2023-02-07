package testingil.unittesting.examples.demos.d02.mocking;

public class Driver {

	private Car car;
	
	public Driver(Car car) {
		this.car = car;
	}

	public boolean canDrive() {
		if (!hasKeys())
			return false;
		return !car.isRunning();
	}

	public boolean hasKeys() {
		return true;
	}
	
	public void drive() {
		car.setAC(new AirCondition(ACMode.On) );
		car.start();
	}
	
	
}
