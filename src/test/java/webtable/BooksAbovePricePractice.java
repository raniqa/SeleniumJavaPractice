package webtable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import base.BaseClass;

public class BooksAbovePricePractice extends BaseClass {

	public static void main(String[] args) throws InterruptedException {

		// Create object of current class
		BooksAbovePricePractice tablePractice = new BooksAbovePricePractice();

		// Launch browser
		tablePractice.launchBrowser();

		// Navigate to application
		tablePractice.navigateTo("https://testautomationpractice.blogspot.com/");

		// Scroll to the Book Table
		WebElement bookTable = tablePractice.driver.findElement(By.xpath("//table[@name='BookTable']"));

		JavascriptExecutor js = (JavascriptExecutor) tablePractice.driver;
		js.executeScript("arguments[0].scrollIntoView(true);", bookTable);

		Thread.sleep(3000);

		// Count rows
		List<WebElement> rows = tablePractice.driver.findElements(
				By.xpath("//table[@name='BookTable']//tr[position()>1]"));

		// Count columns
		List<WebElement> columns = tablePractice.driver.findElements(
				By.xpath("//table[@name='BookTable']//th"));

		System.out.println("Books with Price Greater Than 1000");
		System.out.println("----------------------------------");

		// Print books whose price is greater than 1000
		for (int r = 2; r <= rows.size() + 1; r++) {

			WebElement priceCell = tablePractice.driver.findElement(
					By.xpath("//table[@name='BookTable']//tr[" + r + "]/td[4]"));

			int price = Integer.parseInt(priceCell.getText());

			if (price > 1000) {

				for (int c = 1; c <= columns.size(); c++) {

					WebElement bookDetails = tablePractice.driver.findElement(
							By.xpath("//table[@name='BookTable']//tr[" + r + "]/td[" + c + "]"));

					System.out.print(bookDetails.getText() + "\t");
				}

				System.out.println();
			}
		}

		Thread.sleep(3000);

		// Close browser
		tablePractice.closeBrowser();
	}
}