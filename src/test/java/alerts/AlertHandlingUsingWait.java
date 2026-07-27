package alerts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;

// Handling delayed alert using Explicit Wait
public class AlertHandlingUsingWait extends BaseClass {

	public static void main(String[] args) {

		AlertHandlingUsingWait test = new AlertHandlingUsingWait();

		// Launch browser
		test.launchBrowser();

		// Navigate to application
		test.navigateTo("https://www.tutorialspoint.com/selenium/practice/alerts.php");

		// Click button that displays alert after few seconds
		test.driver.findElement(By.xpath("(//button[text()='Click Me'])[1]")).click();

		try {

			WebDriverWait wait = new WebDriverWait(test.driver, Duration.ofSeconds(10));

			Alert alert = wait.until(ExpectedConditions.alertIsPresent());

			System.out.println("Alert Message: " + alert.getText());

			alert.accept();

			System.out.println("Alert handled successfully");

		} catch (Exception e) {

			System.out.println("No alert appeared");

		}

		// Close browser
		test.closeBrowser();
	}
}
