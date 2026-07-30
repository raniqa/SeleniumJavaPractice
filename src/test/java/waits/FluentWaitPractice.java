package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import base.BaseClass;

public class FluentWaitPractice extends BaseClass {

	public static void main(String[] args) {

		// Create object of current class
		FluentWaitPractice waitPractice = new FluentWaitPractice();

		// Launch browser
		waitPractice.launchBrowser();

		// Navigate to application
		waitPractice.navigateTo("https://testautomationpractice.blogspot.com/");

		// Create Fluent Wait
		FluentWait wait = new FluentWait(waitPractice.driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);

		// Wait until Name textbox is visible
		WebElement nameTextBox = (WebElement) wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id("name")));

		// Enter text
		nameTextBox.sendKeys("Rani");

		System.out.println("Text entered successfully using Fluent Wait.");

		// Close browser
		waitPractice.closeBrowser();
	}
}