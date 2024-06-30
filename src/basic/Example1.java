package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Example1 {

	void facebokSignupDemo() throws InterruptedException {
		System.out.println("STEP : Launch browser");
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("STEP : Laod facebook url");
		driver.get("https://www.facebook.com");
		
		System.out.println("STEP : Maximie the browser");
		driver.manage().window().maximize();
		
		System.out.println("STEP : Click on create new account button");
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		Thread.sleep(3000);
		
		System.out.println("STEP : Enter first name");
		driver.findElement(By.name("firstname")).sendKeys("Yogesh");
		
		System.out.println("STEP : Enter last name");
		driver.findElement(By.name("lastname")).sendKeys("Nimbalkar");
		
		System.out.println("STEP : Enter email");
		driver.findElement(By.name("reg_email__")).sendKeys("yogeshn@gmail.com");
		
		System.out.println("STEP : Reenter email");
		driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("yogeshn@gmail.com");
		
		System.out.println("STEP : Enter password");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("Abc@123");
		
		System.out.println("STEP : Select birth date");
		WebElement element =  driver.findElement(By.xpath("//select[@id='day']"));
		Select birthDayElement = new Select(element);
		birthDayElement.selectByVisibleText("28");
		
		element = driver.findElement(By.xpath("//select[@id='month']"));
		Select monthElement = new Select(element);
		monthElement.selectByIndex(6);
		
		element = driver.findElement(By.xpath("//select[@id='year']"));
		Select yearElement = new Select(element);
		yearElement.selectByVisibleText("2020");
		
		System.out.println("STEP : Select Gender");
		driver.findElement(By.xpath("//input[@value='2']")).click();
		
		Thread.sleep(2000);
		System.out.println("STEP : Close Browser");
		driver.close();
	}
	
	public static void main(String[] args) throws InterruptedException {
		new Example1().facebokSignupDemo();
	}
}
