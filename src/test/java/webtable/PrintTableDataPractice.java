package webtable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import base.BaseClass;

public class PrintTableDataPractice extends BaseClass {

	public static void main(String[] args) throws InterruptedException {

		// Create object of current class
		PrintTableDataPractice tablePractice = new PrintTableDataPractice();

		// Launch browser
		tablePractice.launchBrowser();

		// Navigate to application
		tablePractice.navigateTo("https://testautomationpractice.blogspot.com/");

		// Scroll to the Book Table
		WebElement bookTable = tablePractice.driver.findElement(By.xpath("//table[@name='BookTable']"));

		JavascriptExecutor js = (JavascriptExecutor) tablePractice.driver;
		js.executeScript("arguments[0].scrollIntoView(true);", bookTable);

		Thread.sleep(3000);

		// Count data rows
		List<WebElement> rows = tablePractice.driver.findElements(
				By.xpath("//table[@name='BookTable']//tr[position()>1]"));

		// Count columns
		List<WebElement> columns = tablePractice.driver.findElements(
				By.xpath("//table[@name='BookTable']//th"));

		System.out.println("Book Table Data");
		System.out.println("------------------------------");

		// Print all table data
		for (int r = 2; r <= rows.size() + 1; r++) {

			for (int c = 1; c <= columns.size(); c++) {

				WebElement cellData = tablePractice.driver.findElement(
						By.xpath("//table[@name='BookTable']//tr[" + r + "]/td[" + c + "]"));

				System.out.print(cellData.getText() + "\t");
			}

			System.out.println();
		}

		// Close browser
		tablePractice.closeBrowser();
	}
}
