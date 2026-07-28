package frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseClass;

public class SingleFramePractice extends BaseClass {

	public static void main(String[] args) {

		SingleFramePractice frame = new SingleFramePractice();

		frame.launchBrowser();
		frame.navigateTo("https://demo.automationtesting.in/Frames.html");

		// Switch to the single frame
		frame.driver.switchTo().frame("singleframe");

		WebElement textBox = frame.driver.findElement(By.xpath("//input[@type='text']"));
		textBox.sendKeys("Hello! Single Frame");
		
		// Return to the main page
		frame.driver.switchTo().defaultContent();
		//frame.driver.switchTo().parentFrame();
		
		frame.closeBrowser();
	}
}