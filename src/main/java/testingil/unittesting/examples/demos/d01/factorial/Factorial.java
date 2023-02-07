package testingil.unittesting.examples.demos.d01.factorial;

public class Factorial {
	public static int calculate(int number) {
		if (number <= 1)
			return number;
		else
			return calculate(number-1)*number;
	}
}
