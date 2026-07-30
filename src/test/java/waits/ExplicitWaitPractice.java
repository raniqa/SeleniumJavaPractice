package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;

public class ExplicitWaitPractice extends BaseClass {

	public static void main(String[] args) {

		// Create object of current class
		ExplicitWaitPractice waitPractice = new ExplicitWaitPractice();

		// Launch browser
		waitPractice.launchBrowser();

		// Navigate to application
		waitPractice.navigateTo("https://testautomationpractice.blogspot.com/");

		// Create Explicit Wait
		WebDriverWait wait = new WebDriverWait(waitPractice.driver, Duration.ofSeconds(10));

		// Wait until Name textbox is visible
		WebElement nameTextBox = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id("name")));

		// Enter text
		nameTextBox.sendKeys("Rani");

		System.out.println("Text entered successfully using Explicit Wait.");

		// Close browser
		waitPractice.closeBrowser();
	}
}