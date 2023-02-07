package testingil.unittesting.examples.demos.d05.spring.d03.lifecycle;

public class Item {
	String name;
	int value;
	
	public Item() {}
	public Item (String name, int value)
	{
		this.name = name;
		this.value = value;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setValue(int value) {
		this.value = value;
	}

}
