package testingil.unittesting.examples.demos.d02.mocking;

public class AirCondition {

	protected ACMode mode;

	public AirCondition(ACMode mode) {
		this.mode = mode;
	}
	
	public ACMode getMode() {
		return this.mode;
	}
}
