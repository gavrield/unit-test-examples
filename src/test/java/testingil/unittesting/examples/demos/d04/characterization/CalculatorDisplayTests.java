package testingil.unittesting.examples.demos.d04.characterization;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class CalculatorDisplayTests {

	CalculatorDisplay cd;
	TestLogger log;
	
	@BeforeEach
	public void setup() {
		cd = new CalculatorDisplay();
		log = new TestLogger();
	}
	
	@Test
	@Disabled
	public void CheckDisplayTest() throws Exception
	{
		cd.press("1");
		Approvals.verify(cd.getDisplay());
	}
	
	
	@Test
	@Disabled
	public void ComplexOperationsTest() throws Exception	{
		pressSequence("1+2=");
		Approvals.verify(log.getAll());
	}

	private void pressSequence(String sequence) throws Exception {
		sequence.chars().mapToObj(i -> 
			(char) i).forEach(c -> press (c));
	}

	private void press(char key) {
		cd.press(Character.toString(key));
		log.append(key, cd.getDisplay());
	}

}
