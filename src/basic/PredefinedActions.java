package basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredefinedActions {

	static WebDriver driver;
	
	public static WebDriver start(String url) {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("STEP : Maximize the browser and load url");
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
	
	public static WebDriver start() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("STEP : Maximize the browser and load url");
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		return driver;
	}
	
	public static void tearDown() {
		System.out.println("STEP : Close the browser");
		driver.quit();
	}
}
