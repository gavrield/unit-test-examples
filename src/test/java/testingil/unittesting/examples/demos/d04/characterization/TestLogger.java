package testingil.unittesting.examples.demos.d04.characterization;

public class TestLogger {
	
	private StringBuilder sb = new StringBuilder();
	
	public void append(char key, String display) {
		sb.append("Pressed " + key + ", Display shows: " + display + "\n");
	}
	public void append(String log) {sb.append(log + "\n");}

	public String getAll() {
		return sb.toString();
	}
}
