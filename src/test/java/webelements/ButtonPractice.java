package webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import base.BaseClass;

public class ButtonPractice extends BaseClass {

	public static void main(String[] args) {

		ButtonPractice obj = new ButtonPractice();

		// Launch browser and navigate to the button practice page
		obj.launchBrowser();
		obj.navigateTo("https://www.tutorialspoint.com/selenium/practice/buttons.php");

		// Locate the Click Me button
		WebElement clickMeBtn = obj.driver.findElement(By.cssSelector("button.btn.btn-primary"));

		// Identify the position of the Click Me button
		Point clickMePosition = clickMeBtn.getLocation();
		System.out.println("Location of 'Click Me' button: " + clickMePosition);

		// Identify the dimension of the Click Me button
		Dimension clickMeSize = clickMeBtn.getSize();
		System.out.println("Size of 'Click Me' button: " + clickMeSize);

		// Identify button background color
		String buttonColor = clickMeBtn.getCssValue("background-color");
		System.out.println("'Click Me' button background color: " + buttonColor);

		// Perform click operation
		clickMeBtn.click();

		// Close browser
		obj.closeBrowser();
	}
}