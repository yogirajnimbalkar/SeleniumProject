package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Example2 {

	/* Fill info on yahoo signup page*/
	void yahooSignUpDemo() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("STEP : Maximize browser and load the URL");
		driver.manage().window().maximize();
		driver.get("https://www.yahoo.com/");
		
		System.out.println("STEP : Clcik on Sign in button");
		driver.findElement(By.xpath("//div[@id='login-container']/a[text()='Sign in']")).click();
		
		Thread.sleep(3000);
		System.out.println("STEP : Click on Create an account button");
		driver.findElement(By.xpath("//a[@id='createacc']")).click();
		Thread.sleep(2000);
		
		System.out.println("STEP : Enter full name ");
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Ranjeet");
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Jahagirdhar");
		
		System.out.println("STEP : Enter user id");
		driver.findElement(By.xpath("//input[@name='userId']")).sendKeys("rrrjahagirdar");
		
		System.out.println("STEP : Enter passsword");
		driver.findElement(By.xpath("//input[@id='usernamereg-password']")).sendKeys("Rrr@32@1jQa");
		
		System.out.println("STEP : Enter Date of birth");
		WebElement monthElement = driver.findElement(By.xpath("//select[@id='usernamereg-month']"));
		Select month = new Select(monthElement);
		month.selectByVisibleText("August");
		driver.findElement(By.xpath("//input[@id='usernamereg-day']")).sendKeys("15");
		driver.findElement(By.xpath("//input[@id='usernamereg-year']")).sendKeys("2010");
		
		System.out.println("STEP : Close the browser");
		driver.quit();
	}
	
	public static void main(String[] args) throws InterruptedException {
		new Example2().yahooSignUpDemo();
	}
}
