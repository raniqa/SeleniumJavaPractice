package webtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import base.BaseClass;

public class ReadSpecificCellPractice extends BaseClass {

	public static void main(String[] args) throws InterruptedException {

		// Create object of current class
		ReadSpecificCellPractice tablePractice = new ReadSpecificCellPractice();

		// Launch browser
		tablePractice.launchBrowser();

		// Navigate to application
		tablePractice.navigateTo("https://testautomationpractice.blogspot.com/");

		// Scroll to the Book Table
		WebElement bookTable = tablePractice.driver.findElement(By.xpath("//table[@name='BookTable']"));

		JavascriptExecutor js = (JavascriptExecutor) tablePractice.driver;
		js.executeScript("arguments[0].scrollIntoView(true);", bookTable);

		Thread.sleep(3000);

		// Read data from Row 4, Column 2
		WebElement cellData = tablePractice.driver.findElement(
				By.xpath("//table[@name='BookTable']//tr[4]/td[2]"));

		System.out.println("Data in Row 4, Column 2 : " + cellData.getText());

		Thread.sleep(3000);

		// Close browser
		tablePractice.closeBrowser();
	}
}