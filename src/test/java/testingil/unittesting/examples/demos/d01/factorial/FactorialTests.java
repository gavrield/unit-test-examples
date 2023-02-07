package testingil.unittesting.examples.demos.d01.factorial;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import testingil.unittesting.examples.demos.d01.factorial.Factorial;

public class FactorialTests {

	@Test
	public void factorials() {
		assertEquals(1, Factorial.calculate(1));
		assertEquals(2, Factorial.calculate(2));
		assertEquals(6, Factorial.calculate(3));
		assertEquals(3628800, Factorial.calculate(10));
	}
}