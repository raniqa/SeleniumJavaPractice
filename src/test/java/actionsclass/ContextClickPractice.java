package actionsclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import base.BaseClass;

public class ContextClickPractice extends BaseClass {

	public static void main(String[] args) {

		// Create object of current class
		ContextClickPractice contextClick = new ContextClickPractice();

		// Launch browser
		contextClick.launchBrowser();

		// Navigate to application
		contextClick.navigateTo("https://vinothqaacademy.com/mouse-event/");

		// Locate Right Click button
		WebElement rightClickButton = contextClick.driver.findElement(
				By.id("rightBtn"));

		// Create Actions object
		Actions actions = new Actions(contextClick.driver);

		// Perform right click
		actions.contextClick(rightClickButton).perform();

		// Locate Edit option from context menu
		WebElement editOption = contextClick.driver.findElement(
				By.xpath("//div[@id='contextMenu']/button[text()='Edit']"));

		// Click Edit option
		actions.moveToElement(editOption).click().perform();

		// Capture status message
		String statusMessage = contextClick.driver.findElement(
				By.xpath("//span[@id='rightStatus' and contains(text(),'Edit')]"))
				.getText();

		System.out.println("Status Message: " + statusMessage);

		// Close browser
		contextClick.closeBrowser();
	}
}