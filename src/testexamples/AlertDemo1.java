package testexamples;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import basic.PredefinedActions;

public class AlertDemo1 {

	void test1() throws InterruptedException {
		WebDriver driver = PredefinedActions.start();
		
		System.out.println("STEP : Click on the Registration menu link");
		driver.findElement(By.linkText("Registration")).click();
		
		Thread.sleep(3000);
		System.out.println("STEP : Enter user name");
		WebElement username = driver.findElement(By.xpath("//input[@id='unameSignin']"));
		username.sendKeys("yogesh");
		
		System.out.println("STEP : Enter password - more than 8 characters");
		WebElement password = driver.findElement(By.xpath("//input[@id='pwdSignin']"));
		password.sendKeys("yogesh1234");
		
		System.out.println("STEP : Click on submit button");
		WebElement submitbtn = driver.findElement(By.xpath("//button[@id='btnsubmitdetails']"));
		submitbtn.click();
		
		System.out.println("VERIFY : Alert message");
		String expectedMsg = "Success!";
		Alert alert = driver.switchTo().alert();
		String actualMsg = alert.getText();
		if(expectedMsg.equals(actualMsg))
			System.out.println("Alert message verified");
		else
			System.out.println("Alert message mismatch");
		
		alert.accept();
		
		System.out.println("STEP : Clear data and enter user name");
		username.clear();
		username.sendKeys("Hemant");
		
		System.out.println("STEP : Clear data and enter password - less than 8 characters");
		password.clear();
		password.sendKeys("he123");
		
		System.out.println("STEP : Click on submit button");
		submitbtn.click();
		
		System.out.println("VERIFY : Alert message");
		expectedMsg = "Failed! please enter strong password";
		alert = driver.switchTo().alert();
		actualMsg = alert.getText();
		if(expectedMsg.equals(actualMsg))
			System.out.println("Alert message verified");
		else
			System.out.println("Alert message mismatch");
		
		alert.accept();
		
		PredefinedActions.tearDown();
	}
	
	public static void main(String[] args) throws InterruptedException {
		new AlertDemo1().test1();
	}
	
}
