package alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.BaseClass;

public class PromptAlertPractice extends BaseClass {

	public static void main(String[] args) {

		PromptAlertPractice promptAlert = new PromptAlertPractice();

		// Launch browser
		promptAlert.launchBrowser();

		// Navigate to application
		promptAlert.navigateTo("https://the-internet.herokuapp.com/javascript_alerts");

		// Locate JS Prompt Alert button
		WebElement promptAlertButton = promptAlert.driver.findElement(
				By.xpath("//button[text()='JS Prompt']"));

		promptAlertButton.click();

		// Switch to alert
		Alert pAlert = promptAlert.driver.switchTo().alert();

		// Enter text into prompt alert
		String expectedMessage = "Hello..Prompt Alert Handling in Progress";

		pAlert.sendKeys(expectedMessage);

		// Accept alert
		pAlert.accept();

		// Verify result message
		String actualMessage = promptAlert.driver.findElement(
				By.id("result")).getText();

		Assert.assertEquals(actualMessage, "You entered: " + expectedMessage);

		// Close browser
		promptAlert.closeBrowser();
	}
}