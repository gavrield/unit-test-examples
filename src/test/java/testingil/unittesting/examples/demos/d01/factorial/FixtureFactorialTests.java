package testingil.unittesting.examples.demos.d01.factorial;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import testingil.unittesting.examples.demos.d01.factorial.Factorial;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FixtureFactorialTests {

	private Factorial factorial;

	@BeforeEach
	public void setup(){
		factorial = new Factorial();
	}

	@Test
	public void factorial_tests() {
		assertEquals(factorial.calculate(1), 1);
		assertEquals(factorial.calculate(2), 2);
		assertEquals(factorial.calculate(3), 6 );
	}

	@Disabled
	@Test
	public void negative_factorial() {
		assertEquals(factorial.calculate(-3), 0);
	}

	@Test
	public void big_factorial() {
		assertEquals(factorial.calculate(10), 3628800);
	}
}