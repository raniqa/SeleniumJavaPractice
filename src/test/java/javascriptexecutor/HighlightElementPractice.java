package javascriptexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import base.BaseClass;

public class HighlightElementPractice extends BaseClass {

	public static void main(String[] args) throws InterruptedException {

		// Create object of current class
		HighlightElementPractice highlight = new HighlightElementPractice();

		// Launch browser
		highlight.launchBrowser();

		// Navigate to application
		highlight.navigateTo("https://testautomationpractice.blogspot.com/");

		// Locate element
		WebElement nameTextBox = highlight.driver.findElement(By.id("name"));

		// Create JavascriptExecutor object
		JavascriptExecutor js = (JavascriptExecutor) highlight.driver;

		// Highlight the element
		js.executeScript(
				"arguments[0].style.border='3px solid red';",
				nameTextBox
		);

		// Wait to observe highlight
		Thread.sleep(3000);
		
		// Close browser
		highlight.closeBrowser();
	}
}