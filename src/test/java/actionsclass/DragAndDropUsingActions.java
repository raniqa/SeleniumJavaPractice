package actionsclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import base.BaseClass;

public class DragAndDropUsingActions extends BaseClass {

	public static void main(String[] args) {

		// Create object of current class
		DragAndDropUsingActions dragDrop = new DragAndDropUsingActions();

		// Launch browser
		dragDrop.launchBrowser();

		// Navigate to application
		dragDrop.navigateTo("https://testautomationpractice.blogspot.com/");

		// Locate draggable element
		WebElement draggable = dragDrop.driver.findElement(
				By.xpath("//div[@id='draggable']"));

		// Locate droppable element
		WebElement droppable = dragDrop.driver.findElement(
				By.xpath("//div[@id='droppable']"));

		// Create Actions object
		Actions actions = new Actions(dragDrop.driver);

		// Perform drag and drop using clickAndHold, moveToElement and release
		actions
			.clickAndHold(draggable)
			.moveToElement(droppable)
			.release()
			.perform();

		// Verify drag and drop result
		String dropMessage = droppable.getText();

		if (dropMessage.equals("Dropped!")) {

			System.out.println("Verification Passed: Element dropped successfully");

		} else {

			System.out.println("Verification Failed: Element not dropped");
			System.out.println("Actual message: " + dropMessage);
		}

		// Close browser
		dragDrop.closeBrowser();
	}
}
