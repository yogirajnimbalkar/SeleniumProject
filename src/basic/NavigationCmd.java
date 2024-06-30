package basic;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationCmd {

	/* Navigation commands
	 * to(String url)
	 * to(URL)
	 * back()
	 * forward()
	 * refresh()
	 */
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("STEP : load url in browser");
	//	driver.navigate().to("https://www.amazon.in/");
		//or
		driver.navigate().to(new URL("https://www.amazon.in/"));
		
		System.out.println("STEP : Maximized the window");
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		System.out.println("STEP : load flipkart");
		driver.navigate().to("https://www.flipkart.com/");
		Thread.sleep(3000);
		System.out.println("STEP : using back, go to amazon");
		driver.navigate().back();
		Thread.sleep(3000);
		System.out.println("STEP : go to flipkart");
		driver.navigate().forward();
		Thread.sleep(3000);
		System.out.println("STEP : Refresh the page");
		driver.navigate().refresh();
		Thread.sleep(3000);
		System.out.println("STEP : Close browser");
		driver.quit();
	}
}
