package frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseClass;

public class NestedFramesPractice extends BaseClass {
	
	public static void main(String[] args) {

		NestedFramesPractice frame = new NestedFramesPractice();
        
		frame.launchBrowser();
		frame.navigateTo("http://uitestingplayground.com/frames");

		// Switch to the outer frame
		WebElement outerFrame = frame.driver.findElement(By.id("frame-outer"));
		frame.driver.switchTo().frame(outerFrame);

		// Switch to the inner frame
		WebElement innerFrame = frame.driver.findElement(By.id("frame-inner"));
		frame.driver.switchTo().frame(innerFrame);
		
		// Click 'Click Me' button inside the nested iframe
		WebElement clickMeBtn = frame.driver.findElement(By.xpath("//button[text()='Click me']"));
		clickMeBtn.click();
		
		String message = frame.driver.findElement(By.id("result")).getText();
		if("Button pressed: Click me".equals(message)) {
			System.out.println("Clicked the'Click Me' button inside the inner frame");
		}
		else {
			System.out.println("Button click verification failed");
		}	
		// Switch to the outer frame Level 1
		frame.driver.switchTo().parentFrame();
		
		String outerFrameText = frame.driver.findElement(By.xpath("//div[@class='frame-label']")).getText();
		if(outerFrameText.equals("Outer Frame (Level 1)")) {
			System.out.println("Switched back from Inner frame to Outer Frame");
		}
		else {
			System.out.println("Switching from Inner Frame to Outer Frame unsuccessful");
		}
			
		// Switch to the main page
		frame.driver.switchTo().defaultContent();

		frame.closeBrowser();
	}
}