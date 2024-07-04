package testexamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.*;

import basic.PredefinedActions;

public class SelectClassMethodDemo1 {

	void test1() throws InterruptedException {
		WebDriver driver =  PredefinedActions.start("https://www.facebook.com");
		
		System.out.println("STEP : Click on Create new account button");
		driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
		
		Thread.sleep(3000);
		
		//how many options are available in dropdown
		System.out.println("STEP : Check number of options from month dropdown");
		WebElement monthDD =  driver.findElement(By.xpath("//select[@id='month']"));
		Select monthSelectDD = new Select(monthDD);
		List <WebElement> monthList = monthSelectDD.getOptions();
		System.out.println("Total number of options in dropdown : " + monthList.size());
		
		//Print all the available options
		System.out.println("STEP : Print all available options");
		for(WebElement e : monthList) {
			System.out.println(e.getText());
		}
		
		//print selected option
		System.out.println("STEP : Print selected option");
		for(WebElement e : monthList) {
			if(e.isSelected())
				System.out.println(e.getText());
		}
		
		PredefinedActions.tearDown();
	}
	
	void test2() throws InterruptedException {
		WebDriver driver = PredefinedActions.start("http://automationbykrishna.com/");
		
		System.out.println("STEP : Click on basic elements menu tab");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);
		
		//Check drop down is multi select or not
		System.out.println("STEP : Check drop down is multi select or not");
		WebElement multiDD = driver.findElement(By.xpath("//select[@class='form-control']"));
		if(multiDD.getAttribute("multiple") == null) {
			System.out.println("not a multi selct drop down");
		}else if(multiDD.getAttribute("multiple").equals("true")) {
			System.out.println("It is a multi select drop down");
		}
		
		//Select multiple options from multiselect drop down
		System.out.println("STEP : Selct multuple options (1 & 3)");
		Select multiDDList = new Select(multiDD);
		multiDDList.selectByIndex(0);
		multiDDList.selectByVisibleText("3");
		
		//print all selected options
		System.out.println("STEP : Print selected options");
		List<WebElement> listOfAllSelectedOptions = multiDDList.getAllSelectedOptions();
		for(WebElement e : listOfAllSelectedOptions) {
			System.out.println(e.getText());
		}
		
		// Select all deselected options and vice versa
		System.out.println("STEP : Select deselected options and vice vera");
		List<WebElement> listOfAllOptions = multiDDList.getOptions();
		listOfAllOptions.removeAll(listOfAllSelectedOptions);
		multiDDList.deselectAll();
		for(WebElement e : listOfAllOptions) {
			multiDDList.selectByVisibleText(e.getText());
		}
		
		//print first selected option
		System.out.println("STEP : Print first selected option");
		WebElement firstSelected = multiDDList.getFirstSelectedOption();
		System.out.println("First selected option is : " + firstSelected.getText());
		
		//Select second last option from dropdown
		System.out.println("STEP : Select second last option from drop down only");
		multiDDList.deselectAll();
		int secondlastIndex = multiDDList.getOptions().size()-2;
		multiDDList.selectByIndex(secondlastIndex);
		
		PredefinedActions.tearDown();	
	}
	
	public static void main(String[] args) throws InterruptedException {
		SelectClassMethodDemo1 selectDemo = new SelectClassMethodDemo1();
		selectDemo.test1();
		selectDemo.test2();
	}
}
