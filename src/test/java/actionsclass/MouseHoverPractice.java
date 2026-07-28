package actionsclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import base.BaseClass;

public class MouseHoverPractice extends BaseClass {

	public static void main(String[] args) {

		// Create object of current class
		MouseHoverPractice mouseHover = new MouseHoverPractice();

		// Launch browser
		mouseHover.launchBrowser();

		// Navigate to application
		mouseHover.navigateTo("https://testautomationpractice.blogspot.com/");

		// Locate Point Me button
		WebElement pointMeButton = mouseHover.driver.findElement(By.xpath("//button[normalize-space()='Point Me']"));

		// Locate Mobiles option
		WebElement mobilesOption = mouseHover.driver.findElement(By.xpath("//a[normalize-space()='Mobiles']"));

		// Create Actions object
		Actions actions = new Actions(mouseHover.driver);

		// Hover on Point Me and move to Mobiles option then click
		actions.moveToElement(pointMeButton).moveToElement(mobilesOption).click().perform();

		// Close browser
		mouseHover.closeBrowser();
	}
}