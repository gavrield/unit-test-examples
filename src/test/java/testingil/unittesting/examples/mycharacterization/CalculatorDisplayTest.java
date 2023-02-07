package testingil.unittesting.examples.mycharacterization;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CalculatorDisplayTest {
    ExternalDisplay externalDisplay = mock(ExternalDisplay.class);
    CalculatorDisplay calculatorDisplay = new CalculatorDisplay(externalDisplay);
    @Captor
    ArgumentCaptor<String> stringArgumentCaptor = null;

    @ParameterizedTest
    @CsvFileSource(resources = "/arguments.csv")
    void whenStringPressed_thenEqualsExpected(String input, String expected){
        StringToPress.pressString(input.toCharArray(), calculatorDisplay);
        Assertions.assertEquals(expected, calculatorDisplay.getDisplay());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/arguments.csv")
    void whenStringPressed_thenOnExternalDisplayEqualsExpected(String input, String expected){
        when(externalDisplay.isOn()).thenReturn(true);
        StringToPress.pressString(input.toCharArray(), calculatorDisplay);
        calculatorDisplay.showOtherDisplay();
        verify(externalDisplay).show(stringArgumentCaptor.capture());
        Assertions.assertEquals(expected, stringArgumentCaptor.getValue());
    }
}
