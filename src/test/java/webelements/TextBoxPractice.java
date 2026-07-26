package webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseClass;

public class TextBoxPractice extends BaseClass {

	public static void main(String[] args) {

		TextBoxPractice obj = new TextBoxPractice();

		// Launch browser and navigate to the practice page
		obj.launchBrowser();
		obj.navigateTo("https://www.tutorialspoint.com/selenium/practice/text-box.php");

		//  Name Text Box 
		WebElement fullName = obj.driver.findElement(By.id("fullname"));
		fullName.sendKeys("Malu Rahul");

		// Display the entered value
		System.out.println("Name Entered: " + fullName.getAttribute("value"));

		// Email Text Box 
		WebElement email = obj.driver.findElement(By.id("email"));
		email.sendKeys("malur@yahoo.co.in");

		// Address Text Area 
		WebElement currentAddress = obj.driver.findElement(By.id("address"));
		currentAddress.sendKeys("Krishnatheetham\nCoventry\nWest Midlands\nUK");

		// Count the number of characters entered
		String addressEntered = currentAddress.getAttribute("value");
		System.out.println("Number of characters in Address: " + addressEntered.length());

		// Password Field 
		WebElement password = obj.driver.findElement(By.id("password"));
		password.sendKeys("malur123#456");

		// Verify password masking
		String passwordType = password.getAttribute("type");

		if (passwordType.equals("password")) {
			System.out.println("Password masking is enabled.");
		} else {
			System.out.println("Password masking is not enabled.");
		}

		// Submit Button 
		WebElement submitButton = obj.driver.findElement(By.cssSelector("input.btn.btn-primary"));
		submitButton.click();

		// Close the browser
		obj.closeBrowser();
	}
}