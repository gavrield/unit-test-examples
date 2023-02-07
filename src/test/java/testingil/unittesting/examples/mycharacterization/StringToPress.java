package testingil.unittesting.examples.mycharacterization;

public class StringToPress {

    public static void pressString(char[] str, CalculatorDisplay calculatorDisplay){
        for(char ch: str){
            calculatorDisplay.press(String.valueOf(ch));
        }
    }
}
