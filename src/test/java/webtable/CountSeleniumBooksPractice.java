package webtable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import base.BaseClass;

public class CountSeleniumBooksPractice extends BaseClass {

	public static void main(String[] args) throws InterruptedException {

		// Create object of current class
		CountSeleniumBooksPractice tablePractice = new CountSeleniumBooksPractice();

		// Launch browser
		tablePractice.launchBrowser();

		// Navigate to application
		tablePractice.navigateTo("https://testautomationpractice.blogspot.com/");

		// Scroll to the Book Table
		WebElement bookTable = tablePractice.driver.findElement(By.xpath("//table[@name='BookTable']"));

		JavascriptExecutor js = (JavascriptExecutor) tablePractice.driver;
		js.executeScript("arguments[0].scrollIntoView(true);", bookTable);

		Thread.sleep(3000);

		// Count the number of data rows
		List<WebElement> rows = tablePractice.driver.findElements(
				By.xpath("//table[@name='BookTable']//tr[position()>1]"));

		int seleniumBookCount = 0;

		System.out.println("Books Related to Selenium");
		System.out.println("-------------------------");

		// Search for books related to Selenium
		for (int r = 2; r <= rows.size() + 1; r++) {

			WebElement bookTitle = tablePractice.driver.findElement(
					By.xpath("//table[@name='BookTable']//tr[" + r + "]/td[1]"));

			if (bookTitle.getText().contains("Selenium")) {

				System.out.println(bookTitle.getText());
				seleniumBookCount++;
			}
		}

		System.out.println();
		System.out.println("Total Selenium Books : " + seleniumBookCount);

		Thread.sleep(3000);

		// Close browser
		tablePractice.closeBrowser();
	}
}