package testexamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import basic.PredefinedActions;

public class TestExample1 {

	/*https://www.globalsqa.com/contact-us/
	 validate contact info
	 fill the contact form
	 */
	
	void test1() throws InterruptedException {
		WebDriver driver = PredefinedActions.start("https://www.globalsqa.com");
		System.out.println("STEP : Click on Contact Us button");
		driver.findElement(By.xpath("//li[@id='menu-item-1561']/a[contains(text(),'Contact Us')]")).click();
		
		Thread.sleep(4000);
		System.out.println("VERIFY : Phone number");
		String expectedPhoneNumber = "+91-9910979218"; 
		String actualPhoneNumber = driver.findElement(By.xpath("//div[@class='icon_phone']")).getText();
		if(expectedPhoneNumber.equals(actualPhoneNumber))
			System.out.println("Phone number matches");
		else
			System.out.println("Phone number does not match " + actualPhoneNumber);
		
		System.out.println("VERIFY : Email address");
		String expectedEmailId = "contact@globalsqa.com";
		String actualEmailId = driver.findElement(By.xpath("//div[@id='contact_info-widget-3']/div[@class='icon_mail']")).getText();
		if(expectedEmailId.equals(actualEmailId))
			System.out.println("email contact matched");
		else
			System.out.println("email contact does not match " + actualEmailId);
		
		System.out.println("VERIFY : Address");
		String expectedAddress = "146, VP Block, Pitampura, New Delhi-110034";
		String actualAddress = driver.findElement(By.xpath("//div[@class='icon_loc']")).getText();
		if(expectedAddress.equals(actualAddress))
			System.out.println("Address matched");
		else
			System.out.println("Fail to match the address " + actualAddress);
		
		PredefinedActions.tearDown();
	}
	
	void test2() throws InterruptedException {
		WebDriver driver = PredefinedActions.start("https://www.globalsqa.com");
		System.out.println("STEP : Click on Contact Us button");
		driver.findElement(By.xpath("//li[@id='menu-item-1561']/a[contains(text(),'Contact Us')]")).click();
		
		Thread.sleep(4000);
		System.out.println("STEP : Enter name");
		driver.findElement(By.xpath("//input[@id='comment_name']")).sendKeys("Vedant");
		
		System.out.println("STEP: Enter email");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("vedant12@rediff.com");
		
		System.out.println("STEP : Enter Subject");
		driver.findElement(By.xpath("//input[@id='subject']")).sendKeys("Test subject");
		
		System.out.println("STEP : Enter Message");
		driver.findElement(By.xpath("//textarea[@id='comment']")).sendKeys("This is comment test line");
		
		PredefinedActions.tearDown();
	}
	
	public static void main(String[] args) throws InterruptedException {
		TestExample1 testexample1 = new TestExample1();
		testexample1.test1();
		testexample1.test2();
	}
}
