package webtable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import base.BaseClass;

public class StaticWebTablePractice extends BaseClass {

	public static void main(String[] args) {

		// Create object of current class
		StaticWebTablePractice tablePractice = new StaticWebTablePractice();

		// Launch browser
		tablePractice.launchBrowser();

		// Navigate to application
		tablePractice.navigateTo("https://testautomationpractice.blogspot.com/");
		
		// Scroll to the Book Table
		WebElement bookTable = tablePractice.driver.findElement(By.xpath("//table[@name='BookTable']"));

		JavascriptExecutor js = (JavascriptExecutor) tablePractice.driver;
		js.executeScript("arguments[0].scrollIntoView(true);", bookTable);
		
		// Locate all data rows (excluding header row)
		List<WebElement> rows = tablePractice.driver.findElements(
				By.xpath("//table[@name='BookTable']//tr[position()>1]"));

		// Locate all column headers
		List<WebElement> columns = tablePractice.driver.findElements(
				By.xpath("//table[@name='BookTable']//th"));

		// Print row count
		System.out.println("Number of Rows : " + rows.size());

		// Print column count
		System.out.println("Number of Columns : " + columns.size());

		// Close browser
		tablePractice.closeBrowser();
	}
}