package javascriptexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import base.BaseClass;

public class JavaScriptSendkeysPractice extends BaseClass {

	public static void main(String[] args) {

		// Create object of current class
		JavaScriptSendkeysPractice jsSendKeys = new JavaScriptSendkeysPractice();

		// Launch browser
		jsSendKeys.launchBrowser();

		// Navigate to URL
		jsSendKeys.navigateTo("https://testautomationpractice.blogspot.com/");

		// Locate Name textbox
		WebElement nameTextBox = jsSendKeys.driver.findElement(By.id("name"));

		// Create JavaScriptExecutor object
		JavascriptExecutor js = (JavascriptExecutor) jsSendKeys.driver;

		// Enter text using JavaScript
		js.executeScript("arguments[0].value='Rani';", nameTextBox);
		
		//Verifying the value is entered into the textbox		
		String enteredValue = nameTextBox.getAttribute("value");
		if(enteredValue.equals("Rani")) {
			System.out.println("Text is entered to textbox successfully");
		}
		else {
			System.out.println("Failed to enter value");
		}
		
		
		// Close browser
		jsSendKeys.closeBrowser();
	}
}