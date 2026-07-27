package alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseClass;

public class SimpleAlertPractice extends BaseClass {

	public static void main(String[] args) {

		SimpleAlertPractice simpleAlert = new SimpleAlertPractice();

		// Launch browser and navigate to the application
		simpleAlert.launchBrowser();
		simpleAlert.navigateTo("https://the-internet.herokuapp.com/javascript_alerts");

		// Locate and click the JS Alert button
		WebElement jsAlertButton = simpleAlert.driver
				.findElement(By.xpath("//button[text()='Click for JS Alert']"));
		jsAlertButton.click();

		// Switch to the alert
		Alert alert = simpleAlert.driver.switchTo().alert();

		// Get and print the alert message
		String alertMessage = alert.getText();
		System.out.println("Alert Message: " + alertMessage);

		// Accept the alert
		alert.accept();

		// Verify the result message
		String expectedMessage = "You successfully clicked an alert";
		String actualMessage = simpleAlert.driver.findElement(By.id("result")).getText();

		if (expectedMessage.equals(actualMessage)) {
			System.out.println("Simple Alert handled successfully.");
		} else {
			System.out.println("Verification Failed.");
			System.out.println("Expected: " + expectedMessage);
			System.out.println("Actual  : " + actualMessage);
		}

		// Close browser
		simpleAlert.closeBrowser();
	}
}