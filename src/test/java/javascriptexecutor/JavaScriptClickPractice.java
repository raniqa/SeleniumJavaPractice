package javascriptexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import base.BaseClass;

public class JavaScriptClickPractice extends BaseClass {

	public static void main(String[] args) {

		// Create object of current class
		JavaScriptClickPractice jsClick = new JavaScriptClickPractice();

		// Launch browser
		jsClick.launchBrowser();

		// Navigate to URL
		jsClick.navigateTo("https://testautomationpractice.blogspot.com/");

		// Locate START button
		WebElement startButton = jsClick.driver.findElement(By.xpath("//button[text()='START']"));

		// Typecast WebDriver to JavascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) jsClick.driver;

		// Click using JavaScript
		js.executeScript("arguments[0].click();", startButton);

		// Close browser
		jsClick.closeBrowser();
	}
}