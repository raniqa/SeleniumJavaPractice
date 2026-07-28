package windowhandling;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;

public class MultipleWindowsPractice extends BaseClass {

	public static void main(String[] args) {

		MultipleWindowsPractice window = new MultipleWindowsPractice();

		window.launchBrowser();
		window.navigateTo("https://vinothqaacademy.com/multiple-windows/");

		WebDriverWait wait = new WebDriverWait(window.driver, Duration.ofSeconds(10));

		// Store the parent window handle
		String parentWindow = window.driver.getWindowHandle();

		// Click the "New Browser Window" button
		WebElement newBrowserWindowBtn = window.driver.findElement(By.id("button1"));
		newBrowserWindowBtn.click();

		// Wait until the child window opens
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		// Get all window handles
		Set<String> windowHandles = window.driver.getWindowHandles();

		// Switch to the child window
		for (String handle : windowHandles) {

			if (!handle.equals(parentWindow)) {

				window.driver.switchTo().window(handle);

				System.out.println("Child Window Title: " + window.driver.getTitle());

				// Fill the form in the child window
				window.driver.findElement(By.id("nameInput")).sendKeys("Jack");
				window.driver.findElement(By.id("roleInput")).sendKeys("Manager");
				window.driver.findElement(By.id("emailInput")).sendKeys("jack@yahoo.co.in");
				window.driver.findElement(By.id("locationInput")).sendKeys("Miami");
				window.driver.findElement(By.id("departmentInput")).sendKeys("IT");

				// Click Add button
				window.driver.findElement(By.id("addBtn")).click();

				// Close the child window
				window.driver.close();

				break;
			}
		}

		// Switch back to the parent window
		window.driver.switchTo().window(parentWindow);

		// Verify that the parent window is active
		if (window.driver.getCurrentUrl().contains("multiple-windows")) {
			System.out.println("Successfully switched back to the parent window.");
		} else {
			System.out.println("Failed to switch back to the parent window.");
		}

		window.closeBrowser();
	}
}