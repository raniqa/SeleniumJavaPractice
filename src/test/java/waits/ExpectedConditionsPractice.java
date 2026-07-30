package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;

public class ExpectedConditionsPractice extends BaseClass {

	public static void main(String[] args) {

		// Create object of current class
		ExpectedConditionsPractice practice = new ExpectedConditionsPractice();

		// Launch browser
		practice.launchBrowser();

		// Navigate to application
		practice.navigateTo("https://testautomationpractice.blogspot.com/");

		// Create Explicit Wait
		WebDriverWait wait = new WebDriverWait(practice.driver, Duration.ofSeconds(10));

		// 1. Wait until page title contains text
		wait.until(ExpectedConditions.titleContains("Automation"));

		System.out.println("Title Verified : " + practice.driver.getTitle());

		// 2. Wait until Name textbox is visible
		WebElement nameTextBox = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id("name")));

		nameTextBox.sendKeys("Rani Mohanlal");

		System.out.println("Name entered successfully.");

		// 3. Wait until START button is clickable
		WebElement startButton = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='START']")));

		startButton.click();

		System.out.println("START button clicked successfully.");

		// Close browser
		practice.closeBrowser();
	}
}