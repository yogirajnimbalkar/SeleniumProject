package testexamples;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import basic.PredefinedActions;

public class AlertDemo4 {

	void testOnBasicForms() throws InterruptedException {
		WebDriver driver = PredefinedActions.start();
		
		System.out.println("STEP : Click on Basic Elements menu link");
		driver.findElement(By.linkText("Basic Elements")).click();
		
		Thread.sleep(3000);
		System.out.println("STEP : Enter email address");
		driver.findElement(By.xpath("//input[@name='emailId']")).sendKeys("visapur@trek.com");
		
		System.out.println("STEP : Enter password");
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("VisaPur");
		
		System.out.println("STEP : Click on Submit button");
		driver.findElement(By.xpath("//button[@id='submitb2']")).click();
		
		System.out.println("VERIFY : Alert message");
		Alert alert = driver.switchTo().alert();
		String expectedText = "You successfully clicked on it";
		String actualText = alert.getText();
		if(expectedText.equals(actualText))
			System.out.println("Alert message verified");
		else
			System.out.println("Alert message mismatched");
		
		alert.accept();
		PredefinedActions.tearDown();
	}
	
	public static void main(String[] args) throws InterruptedException {
		new AlertDemo4().testOnBasicForms();
	}
}
