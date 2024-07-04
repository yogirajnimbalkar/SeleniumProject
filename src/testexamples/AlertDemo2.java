package testexamples;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import basic.PredefinedActions;

public class AlertDemo2 {

	void test1() throws InterruptedException {
		WebDriver driver = PredefinedActions.start();
		System.out.println("STEP : Click on Basic Elements menu link");
		driver.findElement(By.linkText("Basic Elements")).click();
		
		Thread.sleep(3000);
		System.out.println("STEP : Enter First name");
		String firstname = "Tushar";
		driver.findElement(By.xpath("//input[@id='UserFirstName']")).sendKeys(firstname);
		
		System.out.println("STEP : Enter last name");
		String lastname = "Patil";
		driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys(lastname);
		
		System.out.println("STEP : Enter Company name");
		String companyname = "Infosys";
		driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys(companyname);
		
		System.out.println("STEP : Click on submit button");
		driver.findElement(By.xpath("//button[@onclick='myFunctionPopUp()']")).click();
		
		System.out.println("VERIFY : Alert Message");
		String expectedMsg = firstname + " and " + lastname + " and " + companyname;
		Alert alert = driver.switchTo().alert();
		String actualMsg = alert.getText();
		if(expectedMsg.equals(actualMsg))
			System.out.println("Alert message verified");
		else
			System.out.println("Alert message mismatched");
		
		alert.accept();
		PredefinedActions.tearDown();
	}
	
	void test2() throws InterruptedException {
		WebDriver driver = PredefinedActions.start();
		System.out.println("STEP : Click on Basic Elements menu link");
		driver.findElement(By.linkText("Basic Elements")).click();
		
		Thread.sleep(3000);
		System.out.println("STEP : Click on Alert button");
		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();
		
		System.out.println("VERIFY : Alert Message");
		Alert alert = driver.switchTo().alert();
		String expectedMsg = "You must be TechnoCredits student!!";
		String actualMsg = alert.getText();
		if(expectedMsg.equals(actualMsg))
			System.out.println("Alert message verified");
		else
			System.out.println("Alert message mismatched");
		
		alert.accept();
		PredefinedActions.tearDown();
	}
	
	public static void main(String[] args) throws InterruptedException {
		AlertDemo2 alertdemo2 = new AlertDemo2();
		alertdemo2.test1();
		alertdemo2.test2();
	}
}
