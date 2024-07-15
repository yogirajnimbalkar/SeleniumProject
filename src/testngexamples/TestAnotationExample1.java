package testngexamples;

import org.testng.annotations.Test;

public class TestAnotationExample1 {

	@Test
	public void m1() {
		System.out.println("Test msg from m1");
	}
	
	@Test
	public void m2() {
		System.out.println("Test msg from m2");
	}
	
	public void m3() {
		System.out.println("Test msg from m3");
	}
	
	@Test
	public void m4() {
		System.out.println("Test msg from m4");
	}
}
