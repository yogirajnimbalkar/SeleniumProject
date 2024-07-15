package testngexamples;

import org.testng.annotations.Test;

public class GroupPropExample1 {

	@Test(groups = "smoke")
	public void m1() {
		System.out.println("Test msg from m1");
	}
	
	@Test(groups = "regression")
	public void m2() {
		System.out.println("Test msg from m2");
	}
	
	@Test(groups = {"smoke","regression"})
	public void m3() {
		System.out.println("Test msg from m3");
	}
	
	@Test(groups = "sanity")
	public void m4() {
		System.out.println("Test msg from m4");
	}
	
	@Test(groups = "smoke")
	public void m5() {
		System.out.println("Test msg from m5");
	}
}
