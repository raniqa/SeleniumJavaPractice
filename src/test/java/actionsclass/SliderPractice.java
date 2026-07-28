package actionsclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import base.BaseClass;

public class SliderPractice extends BaseClass {

	public static void main(String[] args) {

		// Create object of current class
		SliderPractice slider = new SliderPractice();

		// Launch browser
		slider.launchBrowser();

		// Navigate to application
		slider.navigateTo("https://testautomationpractice.blogspot.com/");

		// Locate slider element
		WebElement minSlider = slider.driver.findElement(
				By.xpath("(//span[starts-with(@class,'ui-slider-handle')])[1]"));
		
		// Get slider location before moving
		System.out.println("Location of minSlider before dragging: "+minSlider.getLocation().getX());

		// Create Actions object
		Actions actions = new Actions(slider.driver);

		// Move slider using clickAndHold and moveByOffset
		actions
			.clickAndHold(minSlider)
			.moveByOffset(100, 0)
			.release()
			.perform();

		// Get slider location after moving
		System.out.println("Location of minSlider after dragging: "+minSlider.getLocation().getX());

		System.out.println("Slider movement completed");

		// Close browser
		slider.closeBrowser();
	}
}