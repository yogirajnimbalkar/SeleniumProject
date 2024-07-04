package testexamples;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import basic.PredefinedActions;

public class AlertDemo3 {

	void testOnJavaScriptConfirmation() throws InterruptedException {
		WebDriver driver = PredefinedActions.start();
		
		System.out.println("STEP : Click on Basic Elements menulink");
		driver.findElement(By.linkText("Basic Elements")).click();
		
		Thread.sleep(3000);
		System.out.println("STEP : Click on Java Script Conformation button");
		WebElement alertButton = driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']"));
		alertButton.click();
		
		System.out.println("VERIFY : Alert Message");
		Alert alert =  driver.switchTo().alert();
		String expectedMsg = "Are you are doing your homework regularly, Press Okay else Cancel!!";
		String actualMsg = alert.getText();
		if(expectedMsg.equals(actualMsg))
			System.out.println("Alert message verified");
		else
			System.out.println("Alert message mismatched");
		
		System.out.println("STEP : Click OK button on alert");
		alert.accept();
		
		System.out.println("VERIFY : Message after Ok button");
		expectedMsg = "You pressed OK!";
		actualMsg = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		if(expectedMsg.equals(actualMsg))
			System.out.println("Ok button message verified");
		else
			System.out.println("Ok button message mismatched");
		
		System.out.println("STEP : Again Click on Java Script Conformation button");
		alertButton.click();
		
		System.out.println("STEP : Click on Cancel button");
		alert = driver.switchTo().alert();
		alert.dismiss();
		
		System.out.println("VERIFY : Message after Cancel button click");
		expectedMsg = "You pressed Cancel!";
		actualMsg = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		if(expectedMsg.equals(actualMsg))
			System.out.println("Cancel button message verified.");
		else
			System.out.println("Cancel button message mismatched");
		
		PredefinedActions.tearDown();	
	}
	
	void testOnJavaScriptPrompt() throws InterruptedException {
		WebDriver driver = PredefinedActions.start();
		System.out.println("STEP : Click on Basic Elements menulink");
		driver.findElement(By.linkText("Basic Elements")).click();

		Thread.sleep(3000);
		System.out.println("STEP : Click on Javascript Prmompt button");
		WebElement alertButton = driver.findElement(By.xpath("//button[@id='javascriptPromp']"));
		alertButton.click();
		
		System.out.println("VERIFY : Message on alert");
		Alert alert = driver.switchTo().alert();
		String expectedMsg = "Please enter your name :";
		String actualMsg = alert.getText();
		if(expectedMsg.equals(actualMsg))
			System.out.println("Alert message verified");
		else
			System.out.println("Alert message mismatched");
		
		System.out.println("STEP : Click Cancel button");
		alert.dismiss();
		
		System.out.println("VERIFY : Message after Cancel button");
		expectedMsg = "User cancelled the prompt.";
		actualMsg = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		if(expectedMsg.equals(actualMsg))
			System.out.println("Cancel button message verified");
		else
			System.out.println("Cancel button message mismatched");
		
		System.out.println("STEP : Agin click on Java Script prompt button");
		alertButton.click();
		String name = "Yashvant";
		
		System.out.println("STEP : Enter name on alert prompt");
		alert = driver.switchTo().alert();
		alert.sendKeys(name);
		
		System.out.println("STEP: Click on OK button");
		alert.accept();
		
		System.out.println("VERIFY : Message after Ok button click");
		expectedMsg = "Hello " + name + "! How are you today?";
		actualMsg = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		if(expectedMsg.equals(actualMsg))
			System.out.println("Ok button message verified");
		else
			System.out.println("Ok button message mismatched.");
		
		PredefinedActions.tearDown();
	}
	
	public static void main(String[] args) throws InterruptedException {
		AlertDemo3 alertdemo3 = new AlertDemo3();
		alertdemo3.testOnJavaScriptConfirmation();
		alertdemo3.testOnJavaScriptPrompt();
	}
}
