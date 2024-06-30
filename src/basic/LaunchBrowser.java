package basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {

	public static void main(String[] args) {
		//Browser Commands Example.
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("STEP : Load the URL");
		driver.get("https://practice.automationtesting.in/");
		
		System.out.println("STEP : Maximize the browser");
		driver.manage().window().maximize();
		
		System.out.println("STEP : Get current URL");
		System.out.println(driver.getCurrentUrl());
		
		System.out.println("STEP : Get title of Page");
		System.out.println(driver.getTitle());
		
		System.out.println("STEP : Get page source code");
		System.out.println(driver.getPageSource());
		
		System.out.println("STEP : Close the browser");
		driver.close();
		driver.quit();
	}
}
