package actionsclass;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;

public class KeyboardActionPractice extends BaseClass {

	public static void main(String[] args) {

		// Create object of current class
		KeyboardActionPractice keyboardAction = new KeyboardActionPractice();

		// Launch browser
		keyboardAction.launchBrowser();

		// Navigate to application
		keyboardAction.navigateTo("https://academy.postman.com/path/api-testing-path-v12");

		// Create Actions object
		Actions actions = new Actions(keyboardAction.driver);

		// Create Explicit Wait object
		WebDriverWait wait = new WebDriverWait(
				keyboardAction.driver, Duration.ofSeconds(10));

		// Store parent window handle
		String parentWindow = keyboardAction.driver.getWindowHandle();

		// Locate Learn link
		WebElement learnLink = keyboardAction.driver.findElement(
				By.xpath("//div[contains(@class,'header-links-container')]/a[1]"));

		// Open link in new tab using Ctrl + Click
		actions
			.moveToElement(learnLink)
			.keyDown(Keys.CONTROL)
			.click()
			.keyUp(Keys.CONTROL)
			.perform();

		// Wait until new tab opens
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		// Get all window handles
		Set<String> windowHandles = keyboardAction.driver.getWindowHandles();

		for (String window : windowHandles) {

			// Switch to window
			keyboardAction.driver.switchTo().window(window);

			// Identify child window
			if (!window.equals(parentWindow)) {

				System.out.println("Child Window URL: "
						+ keyboardAction.driver.getCurrentUrl());

				if (keyboardAction.driver.getCurrentUrl()
						.contains("www.postman.com/learn/")) {

					System.out.println("Link successfully opened in new tab");
				}

				// Close child window
				keyboardAction.driver.close();

				// Switch back to parent window
				keyboardAction.driver.switchTo().window(parentWindow);
			}
		}

		// Print parent window URL
		System.out.println("Parent Window URL: "
				+ keyboardAction.driver.getCurrentUrl());

		// Close browser
		keyboardAction.closeBrowser();
	}
}