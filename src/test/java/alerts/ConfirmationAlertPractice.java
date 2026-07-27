package alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseClass;

public class ConfirmationAlertPractice extends BaseClass {

	public static void main(String[] args) {

		ConfirmationAlertPractice confirmationAlert = new ConfirmationAlertPractice();

		// Launch browser and navigate to the application
		confirmationAlert.launchBrowser();
		confirmationAlert.navigateTo("https://the-internet.herokuapp.com/javascript_alerts");

		// Locate and click the JS Confirm button
		WebElement confirmAlertButton = confirmationAlert.driver
				.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
		confirmAlertButton.click();

		// Switch to the confirmation alert
		Alert alert = confirmationAlert.driver.switchTo().alert();

		// Get and print the alert message
		String alertMessage = alert.getText();
		System.out.println("Alert Message: " + alertMessage);

		// Accept the alert
		alert.accept();

		// Verify the result message
		String expectedMessage = "You clicked: Ok";

		String actualMessage = confirmationAlert.driver.findElement(By.id("result")).getText();

		if (expectedMessage.equals(actualMessage)) {

			System.out.println("Confirmation Alert handled successfully.");
		} else {

			System.out.println("Verification Failed.");
			System.out.println("Expected: " + expectedMessage);
			System.out.println("Actual  : " + actualMessage);
		}

		// Close browser
		confirmationAlert.closeBrowser();
	}
}