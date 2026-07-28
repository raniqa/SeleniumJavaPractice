package actionsclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import base.BaseClass;

public class DoubleClickPractice extends BaseClass {

	public static void main(String[] args) {

		// Create object of current class
		DoubleClickPractice doubleClick = new DoubleClickPractice();

		// Launch browser
		doubleClick.launchBrowser();

		// Navigate to application
		doubleClick.navigateTo("https://testautomationpractice.blogspot.com/");

		// Locate elements
		WebElement field1 = doubleClick.driver.findElement(
				By.id("field1"));

		WebElement field2 = doubleClick.driver.findElement(
				By.id("field2"));

		WebElement copyTextButton = doubleClick.driver.findElement(
				By.xpath("//button[normalize-space()='Copy Text']"));

		// Create Actions object
		Actions actions = new Actions(doubleClick.driver);

		// Enter text in Field 1
		String expectedText = "Hello Rani!!!";

		field1.clear();
		field1.sendKeys(expectedText);

		// Double click Copy Text button
		actions.doubleClick(copyTextButton).perform();

		// Get text from Field 2 after copying
		String actualText = field2.getAttribute("value");

		// Compare Field 1 text and Field 2 text
		if (expectedText.equals(actualText)) {

			System.out.println("Verification Passed: Text copied correctly");

		} else {

			System.out.println("Verification Failed: Text not copied correctly");
			System.out.println("Expected Text: " + expectedText);
			System.out.println("Actual Text: " + actualText);
		}

		// Close browser
		doubleClick.closeBrowser();
	}
}