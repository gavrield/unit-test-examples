package testingil.unittesting.examples.demos.d01.factorial;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import testingil.unittesting.examples.demos.d01.factorial.Factorial;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParameterizedFactorialTests {

    public static Stream<Arguments> factorial_provider() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(2, 2),
                Arguments.of(3, 6),
                Arguments.of(-3, 0),
                Arguments.of(10, 3628800));
    }

    @ParameterizedTest
    @MethodSource("factorial_provider")
    public void factorial_tests(int input, int result) {
        Factorial factorial = new Factorial();
        assertEquals(factorial.calculate(input), result);
    }

    @ParameterizedTest
    @CsvSource({"1,1", "3,6"})
    public void factorial_tests_csv(int input, int result) {
        Factorial factorial = new Factorial();
        assertEquals(factorial.calculate(input), result);
    }
}