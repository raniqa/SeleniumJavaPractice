package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseClass;

public class ImplicitWaitPractice extends BaseClass {

	public static void main(String[] args) {

		// Create object of current class
		ImplicitWaitPractice waitPractice = new ImplicitWaitPractice();

		// Launch browser
		waitPractice.launchBrowser();

		// Apply Implicit Wait
		waitPractice.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Navigate to the application
		waitPractice.navigateTo("https://testautomationpractice.blogspot.com/");

		// Locate Name text box
		WebElement nameTextBox = waitPractice.driver.findElement(By.id("name"));

		// Enter text
		nameTextBox.sendKeys("Rani");

		System.out.println("Text entered successfully using Implicit Wait.");

		// Close browser
		waitPractice.closeBrowser();
	}
}